/**
 * �\�[�g�\�ȃe�[�u���ł��B
 *
 */
package jp.co.netsol.ncc.components.table;

import java.util.*;

public class SortSimpleTable extends SimpleTable{
/* -------------------------------------------------------------------
 �t�B�[���h
------------------------------------------------------------------- */
	/** �e�[�u�����f�� */
	protected SortSimpleTableModel sortModel = new SortSimpleTableModel();

/* -------------------------------------------------------------------
 �R���X�g���N�^
------------------------------------------------------------------- */
	/**
	 * �V���v���e�[�u�����쐬����
	 */
	public SortSimpleTable() {
		super();

		setModel(sortModel);
	}

/* -------------------------------------------------------------------
 setModel���\�b�h�I�[�o�[���C�h
------------------------------------------------------------------- */
	/**
	 * setModel���\�b�h���I�[�o�[���C�h���Ď��f�[�^���f�����Z�b�g���܂��B
	 *
	 * @param model		�f�[�^���f��
	 */
	public void setModel(SortSimpleTableModel dataModel){
		sortModel = dataModel;

		super.setModel(dataModel);
	}

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
		sortModel.setData(data);
	}

	/**
	 * �f�[�^�ǉ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Object[] data) {
		sortModel.addRow(data);
	}

	/**
	 * �f�[�^�ǉ�<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param	data	�f�[�^
	 */
	public void addRow(Vector data) {
		sortModel.addRow(data);
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
		sortModel.setCellValue(row, col, obj);
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
		sortModel.removeRow(row);
	}
	/**
	 * �s�̍폜<p>
	 * �p�t�H�[�}���X�ׁ̈A�I�[�o�[���C�h����܂��B
	 *
	 * @param row		�s�ԍ�
	 */
	public void removeRow(int[] row){
		sortModel.removeRow(row);
	}

/* -------------------------------------------------------------------
 �\�[�g
------------------------------------------------------------------- */
	/**
	 * �\�[�g���Ă��邩�ǂ�����Ԃ��܂��B
	 *
	 * @return			true - �\�[�g��  false - �\�[�g�s��
	 */
	public boolean isSort(){
		return sortModel.sort;
	}

	/**
	 * �\�[�g���邩�ǂ����̐ݒ�����܂��B
	 *
	 * @param sort			true - �\�[�g��  false - �\�[�g�s��
	 */
	public void setSort(boolean sort){
		sortModel.sort = sort;
	}

	/**
	 * �\�[�g�A���S���Y��(Comparator)���Z�b�g���܂��B
	 *
	 * @param comparator		Comparator
	 */
	public void setComparator(Comparator comparator){
		sortModel.comparator = comparator;
	}

	/**
	 * �\�[�g�A���S���Y��(Comparator)��Ԃ��܂��B
	 *
	 * @return 				Comparator
	 */
	public Comparator getComparator(){
		return sortModel.comparator;
	}

	/**
	 * �\�[�g���������܂��B
	 *
	 */
	public void sort(){
		sortModel.sort();
	}

}
