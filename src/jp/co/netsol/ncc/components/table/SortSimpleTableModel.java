/**
 * �\�[�g�\�ȃe�[�u�����f���ł��B
 *
 */
package jp.co.netsol.ncc.components.table;

import java.util.*;

public class SortSimpleTableModel extends SimpleTableModel{
/* -------------------------------------------------------------------
 �t�B�[���h
------------------------------------------------------------------- */
	/** �\�[�g�t���O */
	protected boolean sort;
	/** Comparator */
	protected Comparator comparator;

/* -------------------------------------------------------------------
 �f�[�^�ݒ�
------------------------------------------------------------------- */
	/**
	 * �f�[�^�ݒ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	data	�f�[�^
	 */
	public void setData(Object[][] data) {
		clear();
		for(int i = 0; i < data.length; i++) {
			this.data.add(data[i]);
		}
		// �\�[�g
		sort();
	}

	/**
	 * �f�[�^�ǉ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Object[] data) {
		this.data.add(data);
		// �\�[�g
		sort();
	}

	/**
	 * �f�[�^�ǉ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Vector data) {
		if(data.size() > 0) {
			Object[] o = data.toArray();
			addRow(o);
		}
	}

/* -------------------------------------------------------------------
 �f�[�^�ύX
------------------------------------------------------------------- */
	/**
	 * �Z���̃f�[�^�ݒ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	row		�s
	 * @param	col		��
	 * @param	obj		�f�[�^
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
		// �\�[�g
		sort();
	}

/* -------------------------------------------------------------------
 �s�̍폜
------------------------------------------------------------------- */
	/**
	 * �s�̍폜<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param row		�s�ԍ�
	 */
	public void removeRow(int row){
		Object[] obj = getRow(row);
		if(obj == null){
			return;
		}
		data.remove(row);
		// �\�[�g
		sort();
	}
	/**
	 * �s�̍폜<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param row		�s�ԍ�
	 */
	public void removeRow(int[] row){
		Collection c = new Vector();
		for(int i = 0; i < row.length; i++){
			Object[] obj = getRow(row[i]);
			c.add(obj);
		}
		data.removeAll(c);
		// �\�[�g
		sort();
	}

/* -------------------------------------------------------------------
 �\�[�g����
------------------------------------------------------------------- */
	/**
	 * �\�[�g���������܂��B
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
