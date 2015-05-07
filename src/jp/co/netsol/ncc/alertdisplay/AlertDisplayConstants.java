/**
 * アラートディスプレイフィールド定義です。
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.resource.*;

public interface AlertDisplayConstants{

	/** リソース取得用クラス名 */
	String CONST_NAME = "jp.co.netsol.ncc.alertdisplay.AlertDisplayConstants.";

	/** カラム名 */
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

	/** カラム名推奨幅 */
	int[] columnWidth = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

	/** AlertIdカラム番号 */
	int COLUMN_ALERT_ID				= 0;
	/** AlertDefカラム番号 */
	int COLUMN_ALERT_DEF			= 1;
	/** ObjectIdカラム番号 */
	int COLUMN_OBJECT_ID			= 2;
	/** ObjectClassカラム番号 */
	int COLUMN_OBJECT_CLASS			= 3;
	/** Managerカラム番号 */
	int COLUMN_MANAGER				= 4;
	/** ManagerClassカラム番号 */
	int COLUMN_MANAGER_CLASS		= 5;
	/** Countカラム番号 */
	int COLUMN_COUNT				= 6;
	/** AckOperカラム番号 */
	int COLUMN_ACK_OPER				= 7;
	/** CurrOperカラム番号 */
	int COLUMN_CURR_OPER			= 8;
	/** Severityカラム番号 */
	int COLUMN_SEVERITY				= 9;
	/** Statusカラム番号 */
	int COLUMN_STATUS				= 10;
	/** ClearedByカラム番号 */
	int COLUMN_CLEARED_BY			= 11;
	/** Firstカラム番号 */
	int COLUMN_FIRST				= 12;
	/** Lastカラム番号 */
	int COLUMN_LAST					= 13;
	/** CrearedAtカラム番号 */
	int COLUMN_CLEARED_AT			= 14;
	/** AckedAtカラム番号 */
	int COLUMN_ACKED_AT				= 15;
	/** Textカラム番号 */
	int COLUMN_TEXT					= 16;
	/** Ticketカラム番号 */
	int COLUMN_TICKET				= 17;


}
