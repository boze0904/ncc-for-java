/**
 * �A���[�g�f�B�X�v���C�t�B�[���h��`�ł��B
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.resource.*;

public interface AlertDisplayConstants{

	/** ���\�[�X�擾�p�N���X�� */
	String CONST_NAME = "jp.co.netsol.ncc.alertdisplay.AlertDisplayConstants.";

	/** �J������ */
	String[] columnName = {
							NameResource.getLabelName(CONST_NAME + "Column_AlertId", "AlertId"),
							NameResource.getLabelName(CONST_NAME + "Column_AlertDef", "AlertDef"),
							NameResource.getLabelName(CONST_NAME + "Column_ObjectId", "ObjectId"),
							NameResource.getLabelName(CONST_NAME + "Column_ObjectClass", "ObjectClass"),
							NameResource.getLabelName(CONST_NAME + "Column_Manager", "Manager"),
							NameResource.getLabelName(CONST_NAME + "Column_ManagerClass", "ManagerClass"),
							NameResource.getLabelName(CONST_NAME + "Column_Count", "Count"),
							NameResource.getLabelName(CONST_NAME + "Column_AckOper", "AckOper"),
							NameResource.getLabelName(CONST_NAME + "Column_CurrOper", "CurrOper"),
							NameResource.getLabelName(CONST_NAME + "Column_Severity", "Severity"),
							NameResource.getLabelName(CONST_NAME + "Column_Status", "Status"),
							NameResource.getLabelName(CONST_NAME + "Column_ClearedBy", "ClearedBy"),
							NameResource.getLabelName(CONST_NAME + "Column_First", "First"),
							NameResource.getLabelName(CONST_NAME + "Column_Last", "Last"),
							NameResource.getLabelName(CONST_NAME + "Column_CrearedAt", "CrearedAt"),
							NameResource.getLabelName(CONST_NAME + "Column_AckedAt", "AckedAt"),
							NameResource.getLabelName(CONST_NAME + "Column_Text", "Text"),
							NameResource.getLabelName(CONST_NAME + "Column_Ticket", "Ticket")
						};

	/** �J������������ */
	int[] columnWidth = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

	/** AlertId�J�����ԍ� */
	int COLUMN_ALERT_ID				= 0;
	/** AlertDef�J�����ԍ� */
	int COLUMN_ALERT_DEF			= 1;
	/** ObjectId�J�����ԍ� */
	int COLUMN_OBJECT_ID			= 2;
	/** ObjectClass�J�����ԍ� */
	int COLUMN_OBJECT_CLASS			= 3;
	/** Manager�J�����ԍ� */
	int COLUMN_MANAGER				= 4;
	/** ManagerClass�J�����ԍ� */
	int COLUMN_MANAGER_CLASS		= 5;
	/** Count�J�����ԍ� */
	int COLUMN_COUNT				= 6;
	/** AckOper�J�����ԍ� */
	int COLUMN_ACK_OPER				= 7;
	/** CurrOper�J�����ԍ� */
	int COLUMN_CURR_OPER			= 8;
	/** Severity�J�����ԍ� */
	int COLUMN_SEVERITY				= 9;
	/** Status�J�����ԍ� */
	int COLUMN_STATUS				= 10;
	/** ClearedBy�J�����ԍ� */
	int COLUMN_CLEARED_BY			= 11;
	/** First�J�����ԍ� */
	int COLUMN_FIRST				= 12;
	/** Last�J�����ԍ� */
	int COLUMN_LAST					= 13;
	/** CrearedAt�J�����ԍ� */
	int COLUMN_CLEARED_AT			= 14;
	/** AckedAt�J�����ԍ� */
	int COLUMN_ACKED_AT				= 15;
	/** Text�J�����ԍ� */
	int COLUMN_TEXT					= 16;
	/** Ticket�J�����ԍ� */
	int COLUMN_TICKET				= 17;


}
