/**
 * アラートディスプレイ用テーブルモデルです。
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class AlertDisplayTableModel extends SortSimpleTableModel implements AlertDisplayConstants{

/* -----------------------------------------------------------------------------
 フィールド
----------------------------------------------------------------------------- */
	/** AlertDisplayTable */
	protected AlertDisplayTable table;

/* -----------------------------------------------------------------------------
 コンストラクタ
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayTableModelを構築します。
	 *
	 * @param table		AlertDisplayTable
	 */
	public AlertDisplayTableModel(AlertDisplayTable table){
		super();

		this.table = table;
	}


	/**
	 * 選択行が解除されてしますので fireTableDataChangedをオーバーライドします。
	 *
	 */
/*
	public void fireTableDataChanged(){

		// 選択行の取得
		int[] index = table.getSelectedRows();

System.out.println("----- getSelectedRows -----");
		// AlertId取得
		Vector v = new Vector();
		for(int i = 0; i < index.length; i++){
			Object obj = getData(index[i], COLUMN_ALERT_ID);
System.out.println("index[" + i + "]=" + index[i]);
			v.add(obj.toString());
		}

		super.fireTableDataChanged();

		// 選択行を戻す
		for(int i = 0; i < table.getRowCount(); i++){
			// 選択行がない場合は終了
			if(v.isEmpty()){
				break;
			}

			// テーブルのCOLUMN_ALERT_IDの値を取得
			Object obj = table.getData(i, COLUMN_ALERT_ID);
			// fireTableDataChangedメソッドが呼ばれる前の選択アラートIDと比較する
			for(int j = 0; j < v.size(); j++){
				Object id = v.get(j);
				if(id.toString().equals(obj.toString())){
					// 行を選択する
					table.setRowSelectionInterval(i, i);
System.out.println("setRowSelectionInterval : AlertId =  " + id.toString() + " : row = " + i);
					// 選択されたAlertIdをリストから削除
					v.remove(id);
					break;
				}
			}
		}
	}
*/
}
