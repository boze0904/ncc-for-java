/**
 * �A���[�g�f�B�X�v���C�p�e�[�u�����f���ł��B
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class AlertDisplayTableModel extends SortSimpleTableModel implements AlertDisplayConstants{

/* -----------------------------------------------------------------------------
 �t�B�[���h
----------------------------------------------------------------------------- */
	/** AlertDisplayTable */
	protected AlertDisplayTable table;

/* -----------------------------------------------------------------------------
 �R���X�g���N�^
----------------------------------------------------------------------------- */
	/**
	 * AlertDisplayTableModel���\�z���܂��B
	 *
	 * @param table		AlertDisplayTable
	 */
	public AlertDisplayTableModel(AlertDisplayTable table){
		super();

		this.table = table;
	}


	/**
	 * �I���s����������Ă��܂��̂� fireTableDataChanged���I�[�o�[���C�h���܂��B
	 *
	 */
/*
	public void fireTableDataChanged(){

		// �I���s�̎擾
		int[] index = table.getSelectedRows();

System.out.println("----- getSelectedRows -----");
		// AlertId�擾
		Vector v = new Vector();
		for(int i = 0; i < index.length; i++){
			Object obj = getData(index[i], COLUMN_ALERT_ID);
System.out.println("index[" + i + "]=" + index[i]);
			v.add(obj.toString());
		}

		super.fireTableDataChanged();

		// �I���s��߂�
		for(int i = 0; i < table.getRowCount(); i++){
			// �I���s���Ȃ��ꍇ�͏I��
			if(v.isEmpty()){
				break;
			}

			// �e�[�u����COLUMN_ALERT_ID�̒l���擾
			Object obj = table.getData(i, COLUMN_ALERT_ID);
			// fireTableDataChanged���\�b�h���Ă΂��O�̑I���A���[�gID�Ɣ�r����
			for(int j = 0; j < v.size(); j++){
				Object id = v.get(j);
				if(id.toString().equals(obj.toString())){
					// �s��I������
					table.setRowSelectionInterval(i, i);
System.out.println("setRowSelectionInterval : AlertId =  " + id.toString() + " : row = " + i);
					// �I�����ꂽAlertId�����X�g����폜
					v.remove(id);
					break;
				}
			}
		}
	}
*/
}
