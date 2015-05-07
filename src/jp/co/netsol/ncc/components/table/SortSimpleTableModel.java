/**
 * ソート可能なテーブルモデルです。
 *
 */
package jp.co.netsol.ncc.components.table;

import java.util.*;

public class SortSimpleTableModel extends SimpleTableModel{
/* -------------------------------------------------------------------
 フィールド
------------------------------------------------------------------- */
	/** ソートフラグ */
	protected boolean sort;
	/** Comparator */
	protected Comparator comparator;

/* -------------------------------------------------------------------
 データ設定
------------------------------------------------------------------- */
	/**
	 * データ設定<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	data	データ
	 */
	public void setData(Object[][] data) {
		clear();
		for(int i = 0; i < data.length; i++) {
			this.data.add(data[i]);
		}
		// ソート
		sort();
	}

	/**
	 * データ追加<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	data	データ
	 */
	public void addRow(Object[] data) {
		this.data.add(data);
		// ソート
		sort();
	}

	/**
	 * データ追加<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	data	データ
	 */
	public void addRow(Vector data) {
		if(data.size() > 0) {
			Object[] o = data.toArray();
			addRow(o);
		}
	}

/* -------------------------------------------------------------------
 データ変更
------------------------------------------------------------------- */
	/**
	 * セルのデータ設定<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	row		行
	 * @param	col		列
	 * @param	obj		データ
	 */
	public void setCellValue(int row, int col, Object obj) {
		if( obj != null ){
			if( row < data.size() ){
				Object[] o = (Object[])data.get(row);
				if( col < o.length ){
					o[col] = obj;
				}
			}
		}
		// ソート
		sort();
	}

/* -------------------------------------------------------------------
 行の削除
------------------------------------------------------------------- */
	/**
	 * 行の削除<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param row		行番号
	 */
	public void removeRow(int row){
		Object[] obj = getRow(row);
		if(obj == null){
			return;
		}
		data.remove(row);
		// ソート
		sort();
	}
	/**
	 * 行の削除<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param row		行番号
	 */
	public void removeRow(int[] row){
		Collection c = new Vector();
		for(int i = 0; i < row.length; i++){
			Object[] obj = getRow(row[i]);
			c.add(obj);
		}
		data.removeAll(c);
		// ソート
		sort();
	}

/* -------------------------------------------------------------------
 ソート処理
------------------------------------------------------------------- */
	/**
	 * ソート処理をします。
	 *
	 */
	protected void sort(){
		if(! sort){
			fireTableDataChanged();
			return;
		}
		if(comparator == null){
			fireTableDataChanged();
			return;
		}

		Object[][] obj = new Object[data.size()][];
		for(int i = 0; i < obj.length; i++){
			obj[i] = (Object[])data.get(i);
		}
		if(obj.length > 1){
			Arrays.sort(obj, comparator);
		}
		data.removeAllElements();
		for(int i = 0; i < obj.length; i++){
			data.add(obj[i]);
		}

		fireTableDataChanged();
	}

}
