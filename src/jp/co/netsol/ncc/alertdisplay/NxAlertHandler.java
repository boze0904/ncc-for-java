
package jp.co.netsol.ncc.alertdisplay;

import NxCorba.*;

import jp.co.netsol.ncc.components.table.*;

public class NxAlertHandler extends AlertHandler implements AlertAttributeConstants, AlertDisplayConstants{

	protected AlertDisplayTable table;

	public NxAlertHandler(AlertDisplayTable table){
		this.table = table;
	}


	/**
	 * Alertが発生した時の処理を定義します。
	 *
	 * @param alert_in 発生したAlert
	 */
	public synchronized void createNxAlert(AlertWrapper alert_in){

		int severity = alert_in.getSeverity().getValue();
		table.addRow(new Object[]{
			new SeverityColor(severity, alert_in.getId()),
			new SeverityColor(severity, alert_in.getAlertDef()),
			new SeverityColor(severity, alert_in.getObjectId()),
			new SeverityColor(severity, alert_in.getObjectClass()),
			new SeverityColor(severity, alert_in.getManager()),
			new SeverityColor(severity, alert_in.getManagerClass()),
			new SeverityColor(severity, new Integer(alert_in.getCount())),
			new SeverityColor(severity, alert_in.getAckOper()),
			new SeverityColor(severity, alert_in.getCurrOper()),
			new SeverityColor(severity, alert_in.getSeverity().getString()),
			new SeverityColor(severity, alert_in.getStatusType().getString()),
			new SeverityColor(severity, alert_in.getClearedBy().getString()),
			new SeverityColor(severity, new Integer(alert_in.getFirst())),
			new SeverityColor(severity, new Integer(alert_in.getLast())),
			new SeverityColor(severity, new Integer(alert_in.getClearedAt())),
			new SeverityColor(severity, new Integer(alert_in.getAckedAt())),
			new SeverityColor(severity, alert_in.getText()),
			new SeverityColor(severity, alert_in.getTTicket()),
		});

	}

	/**
	 * Alertが削除された時の処理を定義します。
	 *
	 * @alert_in 削除されたAlert
	 */
	public synchronized void deleteNxAlert(String alert_in){
	}

	/**
	 * Alertが更新された時の処理を定義します。
	 *
	 * @param alert_in 更新されたAlert
	 * @param newAttributes_in アトリビュート
	 */
	public synchronized void updateNxAlert(String alert_in, NxAttributeWrapper[] newAttributes_in){

		// AlertIdの行番号
		int row = 0;
		boolean b = false;
		for(int i = 0; i < table.getRowCount(); i++){
			// AlertIdはカラムの０番目
			Object obj = table.getData(i, COLUMN_ALERT_ID);
			if(obj.toString().equals(alert_in)){
				row = i;
				b = true;
				break;
			}
		}

		// 該当AlertIdが見つからない
		if(!b){
			return;
		}

		for(int i = 0; i < newAttributes_in.length; i++){
			if(newAttributes_in[i].isNxAttribute(ALERT_DEF)){
//System.out.println("isNxAttribute(ALERT_DEF)");
				// alertDef
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_ALERT_DEF);
				table.setCellValue(row, COLUMN_ALERT_DEF,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(OBJECT_ID)){
//System.out.println("isNxAttribute(OBJECT_ID)");
				// objectId
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_OBJECT_ID);
				table.setCellValue(row, COLUMN_OBJECT_ID,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(OBJECT_CLASS)){
//System.out.println("isNxAttribute(OBJECT_CLASS)");
				// objectClass
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_OBJECT_CLASS);
				table.setCellValue(row, COLUMN_OBJECT_CLASS,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(MANAGER)){
//System.out.println("isNxAttribute(MANAGER)");
				// manager
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_MANAGER);
				table.setCellValue(row, COLUMN_MANAGER,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(MANAGER_CLASS)){
//System.out.println("isNxAttribute(MANAGER_CLASS)");
				// managerClass
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_MANAGER_CLASS);
				table.setCellValue(row, COLUMN_MANAGER_CLASS,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(COUNT)){
//System.out.println("isNxAttribute(COUNT)");
				// count
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_COUNT);
				table.setCellValue(row, COLUMN_COUNT,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(ACK_OPER)){
//System.out.println("isNxAttribute(ACK_OPER)");
				// ackOper
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_ACK_OPER);
				table.setCellValue(row, COLUMN_ACK_OPER,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(CURR_OPER)){
//System.out.println("isNxAttribute(CURR_OPER)");
				// currOper
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_CURR_OPER);
				table.setCellValue(row, COLUMN_CURR_OPER,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(SEVERITY)){
//System.out.println("isNxAttribute(SEVERITY)");
				// severity
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_SEVERITY);
				Object newSeverity = newAttributes_in[i].getNxAttribute();
				int newSeverityNum = (Integer.valueOf(newSeverity.toString())).intValue();
				String newSeverityString = AlertSeverityWrapper.getString(newSeverityNum);

				Object[] rowObject = table.getRow(row);
				for(int j = 0; j < rowObject.length; j++){
					if(j == COLUMN_SEVERITY){
						table.setCellValue(row, j, new SeverityColor(newSeverityNum, newSeverityString));
					}else{
						SeverityColor otherObj = (SeverityColor)rowObject[j];
						table.setCellValue(row, j, new SeverityColor(newSeverityNum, otherObj.toString()));
					}
				}
			}else
			if(newAttributes_in[i].isNxAttribute(STATUS)){
//System.out.println("isNxAttribute(STATUS)");
				// status
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_STATUS);
				Object newStatus = newAttributes_in[i].getNxAttribute();
				int newStatusNum = (Integer.valueOf(newStatus.toString())).intValue();
				String newStatusString = AlertStatusTypeWrapper.getString(newStatusNum);
				table.setCellValue(row, COLUMN_STATUS, new SeverityColor(sevirityObj.getSeverity(), newStatusString));
			}else
			if(newAttributes_in[i].isNxAttribute(CLEARED_BY)){
//System.out.println("isNxAttribute(CLEARED_BY)");
				// clearedBy
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_CLEARED_BY);
				Object newClearedBy = newAttributes_in[i].getNxAttribute();
				int newClearedByNum = (Integer.valueOf(newClearedBy.toString())).intValue();
				String newClearedByString = ClearedByTypeWrapper.getString(newClearedByNum);
				table.setCellValue(row, COLUMN_CLEARED_BY, new SeverityColor(sevirityObj.getSeverity(), newClearedByString));
			}else
			if(newAttributes_in[i].isNxAttribute(FIRST)){
//System.out.println("isNxAttribute(FIRST)");
				// first
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_FIRST);
				table.setCellValue(row, COLUMN_FIRST,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(LAST)){
//System.out.println("isNxAttribute(LAST)");
				// last
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_LAST);
				table.setCellValue(row, COLUMN_LAST,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(CLEARED_AT)){
//System.out.println("isNxAttribute(CLEARED_AT)");
				// clearedAt
				table.removeRow(row);
//				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_CLEARED_AT);
//				table.setCellValue(row, COLUMN_CLEARED_AT,
//									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(ACKED_AT)){
//System.out.println("isNxAttribute(ACKED_AT)");
				// ackedAt
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_ACKED_AT);
				table.setCellValue(row, COLUMN_ACKED_AT,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(TEXT)){
//System.out.println("isNxAttribute(TEXT)");
				// text
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_TEXT);
				table.setCellValue(row, COLUMN_TEXT,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}else
			if(newAttributes_in[i].isNxAttribute(TICKET)){
//System.out.println("isNxAttribute(TICKET)");
				// tTicket
				SeverityColor sevirityObj = (SeverityColor)table.getData(row, COLUMN_TICKET);
				table.setCellValue(row, COLUMN_TICKET,
									new SeverityColor(sevirityObj.getSeverity(), newAttributes_in[i].getNxAttribute()));
			}
		}
	}

}
