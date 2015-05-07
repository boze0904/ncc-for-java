/**
 * �f�t�H���g�̃t���[����������������t���[���ł��B<BR>
 * �e��ʂ��w�肵�A���[�_�� �A�����[�_���ǂ�����Ή��ł��܂��B
 *
 */
package jp.co.netsol.ncc.components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DefaultFrame extends BasicFrame implements Returnable{
/* -------------------------------------------------------------------
 �ϐ�
------------------------------------------------------------------- */
	/** �e�I�u�W�F�N�g */
	protected Returnable rt;
/* -------------------------------------------------------------------
 �R���X�g���N�^
------------------------------------------------------------------- */
	/**
	 * �A�����[�_���^�C�v�̉�ʂ𐶐����܂��B�e�I�u�W�F�N�g���w�肵�Ă��Ȃ����߁A
	 * �e�I�u�W�F�N�g�͖�������܂��B
	 *
	 */
	public DefaultFrame(){
		this(null);
	}
	/**
	 * �e�I�u�W�F�N�g���w�肵�āA�A�����[�_���^�C�v�̉�ʂ𐶐����܂��B
	 *
	 * @param rt		�e�I�u�W�F�N�g
	 */
	public DefaultFrame(Returnable rt){
		this(rt, false);
	}
	/**
	 * �e�I�u�W�F�N�g���w�肵�āA���[�_���^�C�v�A�������̓A�����[�_���^�C�v�̉�ʂ𐶐����܂��B
	 *
	 * @param rt		�e�I�u�W�F�N�g
	 * @param type		true - ���[�_��  false - �A�����[�_��
	 */
	public DefaultFrame(Returnable rt, boolean type){
		super();
		this.rt = rt;
		if(type){
			if(rt != null){
				rt.lostControl();
			}
		}
		windowClose();
	}
/* -------------------------------------------------------------------
 �E�C���h�E�N���[�Y���̏���
------------------------------------------------------------------- */
	/**
	 * �N���[�Y�����ł��B<BR>
	 * Window��[X]�i����{�^���j�̏������������܂��B<BR>
	 * �e�I�u�W�F�N�g�ɐ�����ڂ��܂��B
	 *
	 */
	private void windowClose(){
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				close();
			}
		});
	}
/* -------------------------------------------------------------------
 �N���[�Y����
------------------------------------------------------------------- */
	/**
	 * �N���[�Y�����ł��B<BR>
	 * �e�I�u�W�F�N�g�����݂���ΌĂяo���܂��B
	 *
	 */
	public void close(){
		lostControl();
		dispose();
		if(rt != null){
			rt.gainControl();
		}
	}
/* -------------------------------------------------------------------
 ����擾
------------------------------------------------------------------- */
	/**
	 * ����擾���܂��B
	 *
	 */
	public void gainControl(){
//		setVisible(true);
		show();
	}
/* -------------------------------------------------------------------
 ����ڍs
------------------------------------------------------------------- */
	/**
	 * ����ڍs���܂��B
	 *
	 */
	public void lostControl(){
		setVisible(false);
	}
}
