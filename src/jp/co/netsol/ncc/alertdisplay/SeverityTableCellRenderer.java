/**
 * Colorを描画できる セルレンダラーです。
 *
 * @version $Revision: 1.1 $ $Date: 2003/03/06 10:41:21 $
 */
package jp.co.netsol.ncc.alertdisplay;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class SeverityTableCellRenderer extends DefaultTableCellRenderer{

/* -----------------------------------------------------------------------------
 setValue オーバーライド
----------------------------------------------------------------------------- */
	/**
	 * 描画されるセルの String オブジェクトを value に設定します。
	 *
	 * @param value - このセルの文字列の値。値が null の場合は、テキスト値を空の文字列にする
	 */
	public void setValue(Object value){
		if(value instanceof SeverityColor){
			SeverityColor s = (SeverityColor)value;
			setBackground(s.getSeverityColor());
			setForeground(s.getTextColor());
            setText(s.toString());
		}else{
			super.setValue(value);
		}
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
													boolean isSelected, boolean hasFocus, int row, int column){

		// valueがSeverityColorではなければ何もしない
		if(value instanceof SeverityColor){

			// 選択されているものは色を変える
			if(isSelected){
				value = new SeverityColor(value.toString()){
					public Color getSeverityColor(){
						return Color.BLACK;
					}
					public Color getTextColor(){
						return Color.WHITE;
					}
				};
			}
		}

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


	}
}
