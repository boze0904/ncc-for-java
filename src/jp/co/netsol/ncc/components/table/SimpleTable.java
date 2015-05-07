/**
 * 簡易テーブル.
 * セルを直接編集できない。
 * SimpleTableModelを使用している。
 * 
 * @version $Revision: 1.3 $ $Date: 2003/03/13 05:51:59 $
 */
package jp.co.netsol.ncc.components.table;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 * 簡易テーブル.
 * セルを直接編集できない。
 * SimpleTableModelを使用している。
 */
public class SimpleTable extends JTable {
/* -------------------------------------------------------------------
 フィールド
------------------------------------------------------------------- */
	/** テーブルモデル */
	protected SimpleTableModel simpleModel = new SimpleTableModel();
	/** スクローラー */
	protected TableScroller scroller;

/* -------------------------------------------------------------------
 コンストラクタ
------------------------------------------------------------------- */
	/**
	 * シンプルテーブルを作成する
	 */
	public SimpleTable() {
		setModel(simpleModel);

		// スクローラの指定
		scroller = new TableScroller();
		addComponentListener(scroller);
	}

/* -------------------------------------------------------------------
 setModelメソッドオーバーライド
------------------------------------------------------------------- */
	/**
	 * setModelメソッドをオーバーライドして自データモデルもセットします。
	 *
	 * @param model		データモデル
	 */
	public void setModel(SimpleTableModel dataModel){
		simpleModel = dataModel;

		super.setModel(dataModel);
	}
/* -------------------------------------------------------------------
 推奨サイズ
------------------------------------------------------------------- */
	/** 推奨サイズ幅 */
	private int PreferredViewportSizeWidth = -1;
	/**
	 * 推奨サイズ幅設定
	 *
	 * @param	width	推奨サイズ幅
	 */
	public void setPreferredViewportSizeWidth(int width) {
		PreferredViewportSizeWidth = width;
	}
	/**
	 * 推奨サイズ幅取得
	 *
	 * @return	推奨サイズ幅
	 */
	public int getPreferredViewportSizeWidth() {
		return PreferredViewportSizeWidth;
	}
	/** 推奨サイズ高さ(行数) */
	private int PreferredViewportSizeHeight = -1;
	/**
	 * 推奨サイズ高さ(行数)設定
	 *
	 * @param	row	推奨サイズ高さ(行数)
	 */
	public void setPreferredViewportSizeHeight(int row) {
		PreferredViewportSizeHeight = row;
	}
	/**
	 * 推奨サイズ高さ(行数)取得
	 *
	 * @return	推奨サイズ高さ(行数)
	 */
	public int getPreferredViewportSizeHeight() {
		return PreferredViewportSizeHeight;
	}
	/**
	 * このテーブルのビューポートの望ましいサイズを返します。
	 * 推奨表示行数を設定した場合、その行数のみ表示可能なビューポートサイズを計算します。
	 *
	 * @return	推奨表示行数
	 */
	public Dimension getPreferredScrollableViewportSize() {
		Dimension size = super.getPreferredScrollableViewportSize();
		if (PreferredViewportSizeWidth != -1) {
			size.width = PreferredViewportSizeWidth;
		}
		if (PreferredViewportSizeHeight != -1) {
			size.height = getRowHeight() * PreferredViewportSizeHeight;
		}
		return size;
	}
/* -------------------------------------------------------------------
 カラム名指定
------------------------------------------------------------------- */
	/**
	 * カラム名指定
	 *
	 * @param	columnName	カラム名
	 */
	public void setColumnNames(String[] columnName) {
		simpleModel.setColumnNames(columnName);
	}
/* -------------------------------------------------------------------
 データ追加
------------------------------------------------------------------- */
	/**
	 * データ追加
	 *
	 * @param	data	データ配列
	 */
	public void addRow(Object[] data) {
		simpleModel.addRow(data);
	}
/* -------------------------------------------------------------------
 データ変更
------------------------------------------------------------------- */
	/**
	 * セルのデータ設定
	 *
	 * @param	row		行
	 * @param	col		列
	 * @param	data	データ
	 */
	public void setCellValue(int row, int col, Object data) {
		simpleModel.setCellValue(row, col, data);
	}
/* -------------------------------------------------------------------
 データ表示開始カラムの指定
------------------------------------------------------------------- */
	/**
	 * データ表示開始カラム指定
	 *
	 * @param	c	データ表示開始カラム
	 */
	public void setStartColumn(int c) {
		simpleModel.setStartColumn(c);
	}
/* -------------------------------------------------------------------
 データクリア
------------------------------------------------------------------- */
	/**
	 * データクリア.
	 * 全ての行情報をクリアする。
	 */
	public void clear() {
		simpleModel.clear();
	}
/* -------------------------------------------------------------------
 データ取得
------------------------------------------------------------------- */
	/**
	 * データ取得.
	 * データ表示開始カラム値を無視して直接データを取得する。
	 *
	 * @param	row		行
	 * @param	column	列
	 */
	public Object getData(int row, int column) {
		return simpleModel.getData(row, column);
	}
/* -------------------------------------------------------------------
 カラムの推奨幅指定
------------------------------------------------------------------- */
	/**
	 * カラムの推奨幅指定.
	 *
	 * @param	widths	カラム幅配列
	 */
	public void setPreferredColumnWidth(int[] widths) {
		TableColumnModel tcm = getColumnModel();
		for(int i = 0; i < widths.length && i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setPreferredWidth(widths[i]);
		}
	}
/* -------------------------------------------------------------------
 行の取得
------------------------------------------------------------------- */
	/**
	 * 行の取得
	 *
	 * @param	row		行番号
	 * @return			行データ
	 */
	public Object[] getRow(int row) {
		return simpleModel.getRow(row);
	}
/* -------------------------------------------------------------------
 行の削除
------------------------------------------------------------------- */
	/**
	 * 行の削除
	 *
	 * @param row		行番号
	 */
	public void removeRow(int row){
		simpleModel.removeRow(row);
	}
/* -------------------------------------------------------------------
 行の削除
------------------------------------------------------------------- */
	/**
	 * 行の削除
	 *
	 * @param row		行番号
	 */
	public void removeRow(int[] row){
		simpleModel.removeRow(row);
	}
/* -------------------------------------------------------------------
 列の順序の変更
------------------------------------------------------------------- */
	/**
	 * <p>ユーザが列ヘッダをドラッグして列の順序を
	 *    変えられるかどうかを設定します。 </p>
	 *
	 * @param flg テーブルビューが順序を変更できる場合は true。
	 *            そうでない場合は、false
	 */
	public void setReorderingAllowed( boolean flg )
	{
		JTableHeader th = getTableHeader();
		th.setReorderingAllowed( flg );
	}

/* -------------------------------------------------------------------
 列の順序の変更
------------------------------------------------------------------- */
	/**
	 * <p>指定したレコードが表示される位置までスクロールします</p>
	 *
	 * @param row	行
	 */
	public void selectedRow(int row) {
		scroller.setScrollNow(row);
	}


/* -------------------------------------------------------------------
 テーブルスクローラー
------------------------------------------------------------------- */
	class TableScroller extends ComponentAdapter {
		protected boolean isScroll = false;

		// スクロール
		public void setScrollNow(int row) {
			int cellTop = SimpleTable.this.getCellRect(row, 0, true).y;

			JScrollPane jsp = (JScrollPane)SwingUtilities.getAncestorOfClass(
				JScrollPane.class, SimpleTable.this);
			JViewport jvp = jsp.getViewport();
			int portHeight = jvp.getSize().height;
			int position = cellTop - (portHeight - SimpleTable.this.getRowHeight() - SimpleTable.this.getRowMargin());

			if (position >= 0) {
				jvp.setViewPosition(new Point(0, position));
			} else {
				jvp.setViewPosition(new Point(0, 0));
			}
		}

		// スクロール設定
		public void setScroll() {
			isScroll = true;
		}
		public void componentResized(ComponentEvent event) {
			if (isScroll) {
				int lastRow = SimpleTable.this.getModel().getRowCount() - 1;
				int cellTop = SimpleTable.this.getCellRect(lastRow, 0, true).y;
				JScrollPane jsp = (JScrollPane)SwingUtilities.getAncestorOfClass(
					JScrollPane.class, SimpleTable.this);
				JViewport jvp = jsp.getViewport();
				int portHeight = jvp.getSize().height;
				int position = cellTop - (portHeight - SimpleTable.this.getRowHeight() - SimpleTable.this.getRowMargin());
				if (position >= 0) {
					jvp.setViewPosition(new Point(0, position));
				}
				isScroll = false;
			}
		}
	}

}
