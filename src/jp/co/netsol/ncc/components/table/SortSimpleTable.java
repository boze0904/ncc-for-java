/**
 * ソート可能なテーブルです。
 *
 */
package jp.co.netsol.ncc.components.table;

import java.util.*;

public class SortSimpleTable extends SimpleTable{
/* -------------------------------------------------------------------
 フィールド
------------------------------------------------------------------- */
	/** テーブルモデル */
	protected SortSimpleTableModel sortModel = new SortSimpleTableModel();

/* -------------------------------------------------------------------
 コンストラクタ
------------------------------------------------------------------- */
	/**
	 * シンプルテーブルを作成する
	 */
	public SortSimpleTable() {
		super();

		setModel(sortModel);
	}

/* -------------------------------------------------------------------
 setModelメソッドオーバーライド
------------------------------------------------------------------- */
	/**
	 * setModelメソッドをオーバーライドして自データモデルもセットします。
	 *
	 * @param model		データモデル
	 */
	public void setModel(SortSimpleTableModel dataModel){
		sortModel = dataModel;

		super.setModel(dataModel);
	}

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
		sortModel.setData(data);
	}

	/**
	 * データ追加<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	data	データ
	 */
	public void addRow(Object[] data) {
		sortModel.addRow(data);
	}

	/**
	 * データ追加<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param	data	データ
	 */
	public void addRow(Vector data) {
		sortModel.addRow(data);
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
		sortModel.setCellValue(row, col, obj);
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
		sortModel.removeRow(row);
	}
	/**
	 * 行の削除<p>
	 * パフォーマンスの為、オーバーライドされます。
	 *
	 * @param row		行番号
	 */
	public void removeRow(int[] row){
		sortModel.removeRow(row);
	}

/* -------------------------------------------------------------------
 ソート
------------------------------------------------------------------- */
	/**
	 * ソートしているかどうかを返します。
	 *
	 * @return			true - ソート可  false - ソート不可
	 */
	public boolean isSort(){
		return sortModel.sort;
	}

	/**
	 * ソートするかどうかの設定をします。
	 *
	 * @param sort			true - ソート可  false - ソート不可
	 */
	public void setSort(boolean sort){
		sortModel.sort = sort;
	}

	/**
	 * ソートアルゴリズム(Comparator)をセットします。
	 *
	 * @param comparator		Comparator
	 */
	public void setComparator(Comparator comparator){
		sortModel.comparator = comparator;
	}

	/**
	 * ソートアルゴリズム(Comparator)を返します。
	 *
	 * @return 				Comparator
	 */
	public Comparator getComparator(){
		return sortModel.comparator;
	}

	/**
	 * ソート処理をします。
	 *
	 */
	public void sort(){
		sortModel.sort();
	}

}
