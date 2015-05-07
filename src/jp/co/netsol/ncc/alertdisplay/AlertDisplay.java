/**
 * �A���[�g�f�B�X�v���C��ʂł��B
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
 NetExpert�ʐM�I�u�W�F�N�g
----------------------------------------------------------------------------- */
	/** NxCAAccessor */
	protected NxCAAccessor access;

	/** NxAlertNotification */
	protected NxAlertNotification notification;

/* -----------------------------------------------------------------------------
 �R���|�[�l���g
----------------------------------------------------------------------------- */
	/** ���\�[�X�擾�p�N���X�� */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** �^�C�g�� */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "AlertDisplay");

	/** �e�[�u�� */
	protected AlertDisplayTable table = new AlertDisplayTable();

	/** ���j���[�o�[ */
	protected AlertDisplayMenuBar menubar = new AlertDisplayMenuBar(this, table);


/* -----------------------------------------------------------------------------
 �R���X�g���N�^
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplay���\�z���܂��B
	 *
	 * @param rt		�e�I�u�W�F�N�g
	 * @param access	NxCAAccessor
	 */
	public AlertDisplay(Returnable rt, NxCAAccessor access){
		super(rt);

		this.access = access;

		// ���j���[�o�[��ݒ�
		setJMenuBar(menubar);

		// �e�[�u���̍\�z
		initTable();

		// �R���|�[�l���g�̔z�u�y�я�����
		initComponents();

		// �C�x���g�ݒ�
		setEvent();

	}

	/**
	 * �R���|�[�l���g�������y�сA�z�u�����܂��B
	 *
	 */
	protected void initComponents(){
		// �^�C�g���ݒ�
		setTitle(title);

		// ���C���p�l��
		JPanel panel = getMainPanel();
		panel.setLayout(new BorderLayout());

		// �e�[�u�� add
		JScrollPane scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(900, 500));
		scroll.setViewportView(table);
		panel.add(scroll, BorderLayout.CENTER);

		pack();

		centerScreen();

	}

	/**
	 * �e�[�u����ݒ肵�܂��B
	 *
	 */
	protected void initTable(){
		// �J�������ݒ�
		table.setColumnNames(columnName);
		// �J�������ݒ�
		table.setPreferredColumnWidth(columnWidth);

		// SeverityTableCellRenderer �ݒ�
		TableColumnModel columnModel = table.getColumnModel();
		for(int i = 0; i < columnModel.getColumnCount(); i++){
			TableColumn column = columnModel.getColumn(i);
			column.setCellRenderer(new SeverityTableCellRenderer());
		}

		// �\�[�g
		table.setSort(true);
		table.setComparator(AlertComparatorFactory.create(AlertComparatorFactory.SORT_ALERTID));

		// NxCAAccessor�ݒ�
		table.setNxCAAccessor(access);
	}

	/**
	 * �C�x���g��ݒ肵�܂��B
	 *
	 */
	protected void setEvent(){

		// registerNxCallback �o�^
		registerNxCallback();
	}

	/**
	 * �N���[�Y�������I�[�o�[���C�h���܂��B
	 * NxAlertNotification���L���Ȃ�Ζ����ɂ���B
	 * 
	 */
	public void close(){
		// NxAlertNotification���N���[�Y
		if(notification != null){
			unregisterNxCallback();
		}
		super.close();
	}

	/**
	 * �A���[�g�e�[�u���̓��e���폜���āA�A���[�g���擾���܂��B
	 *
	 */
	public void openAlert(){
		// �e�[�u���폜
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
	 * �A���[�g�擾���������ł��B
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
			// synchronized������
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
	 * registerNxCallback ��o�^����
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
	 * registerNxCallback ����������
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
