/**
 * �A���[�g�f�B�X�v���C�p�e�[�u���ł��B
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import NxCorba.*;

import javax.swing.*;
import javax.swing.table.*;


public class AlertDisplayTable extends SortSimpleTable implements AlertDisplayConstants{

/* -----------------------------------------------------------------------------
 �R���|�[�l���g
----------------------------------------------------------------------------- */
	/** �e�[�u�����f�� */
	protected AlertDisplayTableModel alertModel = new AlertDisplayTableModel(this);
	/** TableColumnModel */
//	protected TableColumnModel columnModel = getColumnModel();

/* -----------------------------------------------------------------------------
 NetExpert�ʐM�I�u�W�F�N�g
----------------------------------------------------------------------------- */
	/** NxCAAccessor */
	protected NxCAAccessor access;

/* -----------------------------------------------------------------------------
 �R���X�g���N�^
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayTable���\�z���܂��B
	 *
	 */
	public AlertDisplayTable(){
		this(null);
	}

	/**
	 * AlertDisplayTable���\�z���܂��B
	 *
	 * @param access		NxCAAccessor
	 */
	public AlertDisplayTable(NxCAAccessor access){
		super();

		this.access = access;

		setModel(alertModel);
	}

/* -------------------------------------------------------------------
 setModel���\�b�h�I�[�o�[���C�h
------------------------------------------------------------------- */
	/**
	 * setModel���\�b�h���I�[�o�[���C�h���Ď��f�[�^���f�����Z�b�g���܂��B
	 *
	 * @param model		�f�[�^���f��
	 */
	public void setModel(AlertDisplayTableModel dataModel){
		sortModel = dataModel;

		super.setModel(dataModel);
	}

/* -----------------------------------------------------------------------------
 NxCAAccessor�Z�b�g
----------------------------------------------------------------------------- */
	/**
	 * NxCAAccessor��ݒ肵�܂��B
	 *
	 * @param access		NxCAAccessor
	 */
	public void setNxCAAccessor(NxCAAccessor access){
		this.access = access;
	}

/* -----------------------------------------------------------------------------
 �A���[�g����
----------------------------------------------------------------------------- */
	/**
	 * �A���[�g���폜���܂��B
	 *
	 */
	public void clearAlert(){

		// AlertId�擾
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// �A���[�g�폜
		try{
			access.clearNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}

		// �I���s�̎擾
//		int[] index = getSelectedRows();
		// �e�[�u���s�폜
//		removeRow(index);
	}

	/**
	 * �A���[�g��F�m���܂��B
	 *
	 */
	public void acknowledgeAlert(){

		// AlertId�擾
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// �A���[�g�F�m
		try{
			access.acknowledgeNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * �A���[�g���F�m���܂��B
	 *
	 */
	public void unacknowledgeAlert(){

		// AlertId�擾
		String[] alertId = getSelectedAlertId();
		if(alertId == null){
			return;
		}

		// �A���[�g��F�m
		try{
			access.unacknowledgeNxAlerts(alertId);
		}catch(NxException e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * �e�[�u������A���[�gID��Ԃ��܂��B
	 *
	 * @return			�A���[�gID�̔z��  �I������Ă��Ȃ��ꍇnull
	 */
	private String[] getSelectedAlertId(){
		// �I������Ă��邩
		if(getSelectedRow() == -1){
			return null;
		}

		// �I���s�̎擾
		int[] index = getSelectedRows();

		// AlertId�擾
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

