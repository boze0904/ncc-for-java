/**
 * Color��`��ł��� �Z�������_���[�ł��B
 *
 * @version $Revision: 1.1 $ $Date: 2003/03/06 10:41:21 $
 */
package jp.co.netsol.ncc.alertdisplay;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class SeverityTableCellRenderer extends DefaultTableCellRenderer{

/* -----------------------------------------------------------------------------
 setValue �I�[�o�[���C�h
----------------------------------------------------------------------------- */
	/**
	 * �`�悳���Z���� String �I�u�W�F�N�g�� value �ɐݒ肵�܂��B
	 *
	 * @param value - ���̃Z���̕�����̒l�B�l�� null �̏ꍇ�́A�e�L�X�g�l����̕�����ɂ���
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

		// value��SeverityColor�ł͂Ȃ���Ή������Ȃ�
		if(value instanceof SeverityColor){

			// �I������Ă�����̂͐F��ς���
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
