/**
 * �ȈՃe�[�u�����f��.
 * �s�f�[�^�z��ɂ������āA�\���J�n�ʒu���w�肷�邱�Ƃŕ\�����̂ق��ɃL�[�Ȃǂ̊Ǘ�����
 * �ێ��ł���B
 * 
 * @version $Revision: 1.2 $ $Date: 2003/03/10 08:29:01 $
 */
package jp.co.netsol.ncc.components.table;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class SimpleTableModel extends AbstractTableModel {
/* -------------------------------------------------------------------
 �t�B�[���h
------------------------------------------------------------------- */
	/** �J������ */
	protected Vector columnName = new Vector();
	/** �f�[�^ */
	protected Vector data = new Vector();
	/** �f�[�^�\���J�n�J���� */
	protected int startColumn;

/* -------------------------------------------------------------------
 �f�[�^�\���J�n�J�����w��
------------------------------------------------------------------- */
	/**
	 * �f�[�^�\���J�n�J�����w��
	 *
	 * @param	c	�f�[�^�\���J�n�J����
	 */
	public void setStartColumn(int c) {
		startColumn = c;
	}
/* -------------------------------------------------------------------
 �J�������ݒ�
------------------------------------------------------------------- */
	/**
	 * �J�������ݒ�
	 *
	 * @param	columnName	�J������
	 */
	public void setColumnNames(String[] columnName) {
		this.columnName.clear();
		for(int i = 0; i < columnName.length; i++) {
			this.columnName.add(columnName[i]);
		}
		fireTableStructureChanged();
	}
	/**
	 * �J�������w��
	 *
	 * @param	columnName	�J������
	 */
	public void setColumnNames(Vector columnName) {
		this.columnName = columnName;
		fireTableStructureChanged();
	}
/* -------------------------------------------------------------------
 �f�[�^�ݒ�
------------------------------------------------------------------- */
	/**
	 * �f�[�^�ݒ�
	 *
	 * @param	data	�f�[�^
	 */
	public void setData(Object[][] data) {
		clear();
		for(int i = 0; i < data.length; i++) {
			this.data.add(data[i]);
		}
		fireTableDataChanged();
	}
	/**
	 * �f�[�^�ǉ�
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Object[] data) {
		this.data.add(data);

		fireTableDataChanged();
	}
	/**
	 * �f�[�^�ǉ�
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Vector data) {
		if(data.size() > 0) {
			Object[] o = data.toArray();
			addRow(o);
		}
	}
	/**
	 * �Z���̃f�[�^�ݒ�
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
					fireTableDataChanged();
				}
			}
		}
	}
/* -------------------------------------------------------------------
 �s���擾
------------------------------------------------------------------- */
	/**
	 * �s���擾
	 *
	 * @return	�s��
	 */
	public int getRowCount() {
		return data.size();
	}
/* -------------------------------------------------------------------
 �J�������擾
------------------------------------------------------------------- */
	/**
	 * �J�������擾
	 *
	 * @return	�J������
	 */
	public int getColumnCount() {
		return columnName.size();
	}
/* -------------------------------------------------------------------
 �J�������擾
------------------------------------------------------------------- */
	/**
	 * �J�������擾
	 *
	 * @param	column	�J�����ԍ�
	 * @return			�J������
	 */
	public String getColumnName(int column) {
		return columnName.get(column).toString();
	}
/* -------------------------------------------------------------------
 �Z�����擾
------------------------------------------------------------------- */
	/**
	 * �Z�����擾.
	 * �w�肵���s�Ɨ�ɂ���Z���̒l��Ԃ�
	 *
	 * @param	row		�s
	 * @param	column	��
	 * @return			�I�u�W�F�N�g
	 */
	public Object getValueAt(int row, int column) {
		return getData(row, column + startColumn);
	}
/* -------------------------------------------------------------------
 �f�[�^�N���A
------------------------------------------------------------------- */
	/**
	 * �f�[�^�N���A.
	 * �S�Ă̍s�����N���A����B
	 */
	public void clear() {
		data.clear();
		fireTableDataChanged();
	}
/* -------------------------------------------------------------------
 �f�[�^�擾
------------------------------------------------------------------- */
	/**
	 * �f�[�^�擾.
	 * �f�[�^�\���J�n�J�����l�𖳎����Ē��ڃf�[�^���擾����B
	 *
	 * @param	row		�s
	 * @param	column	��
	 * @return			�I�u�W�F�N�g
	 */
	public Object getData(int row, int column) {
		if(row < data.size()) {
			Object[] o = (Object[])data.get(row);
			if(column < o.length) {
				return o[column];
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
/* -------------------------------------------------------------------
 �s�̎擾
------------------------------------------------------------------- */
	/**
	 * �s�̎擾
	 *
	 * @param	row		�s�ԍ�
	 * @return			�s�f�[�^
	 */
	public Object[] getRow(int row) {
		if(row < data.size()) {
			return (Object[])data.get(row);
		} else {
			return null;
		}
	}
/* -------------------------------------------------------------------
 �s�̐ݒ�
------------------------------------------------------------------- */
	/**
	 * �s�̐ݒ�
	 *
	 * @param	row		�s�ԍ�
	 * @param	value	�s�f�[�^
	 */
	public void setRow(int row, Object[] value) {
		if(row < data.size()) {
			data.setElementAt(value, row);
		}
		fireTableDataChanged();
	}
/* -------------------------------------------------------------------
 �s�̍폜
------------------------------------------------------------------- */
	/**
	 * �s�̍폜
	 *
	 * @param row		�s�ԍ�
	 */
	public void removeRow(int row){
		Object[] obj = getRow(row);
		if(obj == null){
			return;
		}
		data.remove(row);
		fireTableDataChanged();
	}
	/**
	 * �s�̍폜
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
		fireTableDataChanged();
	}

}
