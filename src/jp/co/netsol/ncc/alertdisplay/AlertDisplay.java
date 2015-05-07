/**
 * アラートディスプレイ画面です。
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.*;
import jp.co.netsol.ncc.components.table.*;
import jp.co.netsol.ncc.resource.*;
import jp.co.netsol.ncc.util.*;

import NxCorba.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AlertDisplay extends DefaultFrame implements AlertDisplayConstants{

	public static void main(String[] args){
		AlertDisplay alert = new AlertDisplay(new DefaultFrame(), null);
		for(int i = 1; i < 11; i++){
			alert.table.addRow(new Object[]{
/*
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i),
				String.valueOf(i)
*/

				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i)),
				new SeverityColor(SeverityColor.Critical, String.valueOf(i))


			});
		}

		alert.setVisible(true);
	}


/* -----------------------------------------------------------------------------
 NetExpert通信オブジェクト
----------------------------------------------------------------------------- */
	/** NxCAAccessor */
	protected NxCAAccessor access;

	/** NxAlertNotification */
	protected NxAlertNotification notification;

/* -----------------------------------------------------------------------------
 コンポーネント
----------------------------------------------------------------------------- */
	/** リソース取得用クラス名 */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** タイトル */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "AlertDisplay");

	/** テーブル */
	protected AlertDisplayTable table = new AlertDisplayTable();

	/** メニューバー */
	protected AlertDisplayMenuBar menubar = new AlertDisplayMenuBar(this, table);


/* -----------------------------------------------------------------------------
 コンストラクタ
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayを構築します。
	 *
	 * @param rt		親オブジェクト
	 * @param access	NxCAAccessor
	 */
	public AlertDisplay(Returnable rt, NxCAAccessor access){
		super(rt);

		this.access = access;

		// メニューバーを設定
		setJMenuBar(menubar);

		// テーブルの構築
		initTable();

		// コンポーネントの配置及び初期化
		initComponents();

		// イベント設定
		setEvent();

	}

	/**
	 * コンポーネント初期化及び、配置をします。
	 *
	 */
	protected void initComponents(){
		// タイトル設定
		setTitle(title);

		// メインパネル
		JPanel panel = getMainPanel();
		panel.setLayout(new BorderLayout());

		// テーブル add
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(900, 500));
		scroll.setViewportView(table);
		panel.add(scroll, BorderLayout.CENTER);

		pack();

		centerScreen();

	}

	/**
	 * テーブルを設定します。
	 *
	 */
	protected void initTable(){
		// カラム名設定
		table.setColumnNames(columnName);
		// カラム幅設定
		table.setPreferredColumnWidth(columnWidth);

		// SeverityTableCellRenderer 設定
		TableColumnModel columnModel = table.getColumnModel();
		for(int i = 0; i < columnModel.getColumnCount(); i++){
			TableColumn column = columnModel.getColumn(i);
			column.setCellRenderer(new SeverityTableCellRenderer());
		}

		// ソート
		table.setSort(true);
		table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ALERTID));

		// NxCAAccessor設定
		table.setNxCAAccessor(access);
	}

	/**
	 * イベントを設定します。
	 *
	 */
	protected void setEvent(){

		// registerNxCallback 登録
		registerNxCallback();
	}

	/**
	 * クローズ処理をオーバーライドします。
	 * NxAlertNotificationが有効ならば無効にする。
	 * 
	 */
	public void close(){
		// NxAlertNotificationをクローズ
		if(notification != null){
			unregisterNxCallback();
		}
		super.close();
	}

	/**
	 * アラートテーブルの内容を削除して、アラートを取得します。
	 *
	 */
	public void openAlert(){
		// テーブル削除
		table.removeAll();

		final WaitDialog wait = new WaitDialog(this);
		wait.setMessage(NameResource.getLabelName(CLASS_NAME + "ProcessOpenAlert", "Open Alert....."));
		wait.setProcess(new Runnable(){
			public void run(){
				processOpenAlert();
			}
		});
		wait.show();

		while(wait.isStatus()){
			try{
				Thread.sleep(1000);
			}catch(Exception e){}
		}

		wait.setVisible(false);

	}

	/**
	 * アラート取得内部処理です。
	 *
	 */
	private void processOpenAlert(){
		AlertWrapper[] alert_in = null;
		try{
			alert_in = access.getNxOpenAlerts("");
		}catch(Exception e){
			e.printStackTrace();
			return;
		}

		for(int i = 0; i < alert_in.length; i++){
			// synchronizedさせる
			synchronized(table){
				int severity = alert_in[i].getSeverity().getValue();
				table.addRow(new Object[]{
					new SeverityColor(severity, alert_in[i].getId()),
					new SeverityColor(severity, alert_in[i].getAlertDef()),
					new SeverityColor(severity, alert_in[i].getObjectId()),
					new SeverityColor(severity, alert_in[i].getObjectClass()),
					new SeverityColor(severity, alert_in[i].getManager()),
					new SeverityColor(severity, alert_in[i].getManagerClass()),
					new SeverityColor(severity, new Integer(alert_in[i].getCount())),
					new SeverityColor(severity, alert_in[i].getAckOper()),
					new SeverityColor(severity, alert_in[i].getCurrOper()),
					new SeverityColor(severity, alert_in[i].getSeverity().getString()),
					new SeverityColor(severity, alert_in[i].getStatusType().getString()),
					new SeverityColor(severity, alert_in[i].getClearedBy().getString()),
					new SeverityColor(severity, new Integer(alert_in[i].getFirst())),
					new SeverityColor(severity, new Integer(alert_in[i].getLast())),
					new SeverityColor(severity, new Integer(alert_in[i].getClearedAt())),
					new SeverityColor(severity, new Integer(alert_in[i].getAckedAt())),
					new SeverityColor(severity, alert_in[i].getText()),
					new SeverityColor(severity, alert_in[i].getTTicket()),
				});
			}
		}
	}

	/**
	 * registerNxCallback を登録する
	 */
	private void registerNxCallback(){

		NxAlertHandler handler = new NxAlertHandler(table);

		AlertNotificationTypeWrapper[] type = new AlertNotificationTypeWrapper[3];
		type[0] = new AlertNotificationTypeWrapper(AlertNotificationTypeWrapper.AlertCreation);
		type[1] = new AlertNotificationTypeWrapper(AlertNotificationTypeWrapper.AlertDeletion);
		type[2] = new AlertNotificationTypeWrapper(AlertNotificationTypeWrapper.AttributeValueChange);

		AlertNotificationFilterWrapper filter = new AlertNotificationFilterWrapper(type, new String[0], "");

		try{
			if(notification == null){
				notification = new NxAlertNotification(access);
			}
			notification.registerCallbackAlert(filter, handler);
		}catch(NxException ne){
			ne.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * registerNxCallback を解除する
	 */
	private void unregisterNxCallback(){
		try{
			notification.unregisterCallbackAlert();
		}catch(NxException ne){
			ne.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
