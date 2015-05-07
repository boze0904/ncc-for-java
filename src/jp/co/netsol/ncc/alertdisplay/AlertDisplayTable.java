/**
 * アラートディスプレイ用テーブルです。
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import NxCorba.*;

import javax.swing.*;
import javax.swing.table.*;


public class AlertDisplayTable extends SortSimpleTable implements AlertDisplayConstants{

/* -----------------------------------------------------------------------------
 コンポーネント
----------------------------------------------------------------------------- */
	/** テーブルモデル */
	protected AlertDisplayTableModel alertModel = new AlertDisplayTableModel(this);
	/** TableColumnModel */
//	protected TableColumnModel columnModel = getColumnModel();

/* -----------------------------------------------------------------------------
 NetExpert通信オブジェクト
----------------------------------------------------------------------------- */
	/** NxCAAccessor */
	protected NxCAAccessor access;

/* -----------------------------------------------------------------------------
 コンストラクタ
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayTableを構築します。
	 *
	 */
	public AlertDisplayTable(){
		this(null);
	}

	/**
	 * AlertDisplayTableを構築します。
	 *
	 * @param access		NxCAAccessor
	 */
	public AlertDisplayTable(NxCAAccessor access){
		super();

		this.access = access;

		setModel(alertModel);
	}

/* -------------------------------------------------------------------
 setModelメソッドオーバーライド
------------------------------------------------------------------- */
	/**
	 * setModelメソッドをオーバーライドして自データモデルもセットします。
	 *
	 * @param model		データモデル
	 */
	public void setModel(AlertDisplayTableModel dataModel){
		sortModel = dataModel;

		super.setModel(dataModel);
	}

/* -----------------------------------------------------------------------------
 NxCAAccessorセット
----------------------------------------------------------------------------- */
	/**
	 * NxCAAccessorを設定します。
	 *
	 * @param access		NxCAAccessor
	 */
	public void setNxCAAccessor(NxCAAccessor access){
		this.access = access;
	}

/* -----------------------------------------------------------------------------
 アラート操作
----------------------------------------------------------------------------- */
	/**
	 * アラートを削除します。
	 *
	 */
	public void clearAlert(){

		// AlertId取得
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// アラート削除
		try{
			access.clearNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}

		// 選択行の取得
//		int[] index = getSelectedRows();
		// テーブル行削除
//		removeRow(index);
	}

	/**
	 * アラートを認知します。
	 *
	 */
	public void acknowledgeAlert(){

		// AlertId取得
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// アラート認知
		try{
			access.acknowledgeNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * アラートを非認知します。
	 *
	 */
	public void unacknowledgeAlert(){

		// AlertId取得
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// アラート非認知
		try{
			access.unacknowledgeNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * テーブルからアラートIDを返します。
	 *
	 * @return			アラートIDの配列  選択されていない場合null
	 */
	private String[] getSelectedAlertId(){
		// 選択されているか
		if(getSelectedRow() == -1){
			return null;
		}

		// 選択行の取得
		int[] index = getSelectedRows();

		// AlertId取得
		String[] alertId = new String[index.length];
		for(int i = 0; i < index.length; i++){
			Object obj = getData(index[i], COLUMN_ALERT_ID);
			alertId[i] = obj.toString();
		}

		return alertId;
	}


/*
	public void setRowSelectionInterval(int index0, int index1){

		for(int i = index0; i <= index1; i++){
			SeverityColor obj = (SeverityColor)alertModel.getData(i, COLUMN_ALERT_ID);
			obj.select(true);
		}

		super.setRowSelectionInterval(index0, index1);
	}
*/
}

