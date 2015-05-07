/**
 * ���������s���ɏ��������b�Z�[�W��\������_�C�A���O�ł��B<BR>
 * �f�t�H���g�͏�������������܂ŉ�ʂ��Ȃ����߃��[�_���ł��B
 * ���[�_������������ɂ͐e�N���X�� wait.setModal(false)���Ăяo���ĉ������B<BR>
 * �f�t�H���g�̃��b�Z�[�W�́u���΂炭���҂��������v�ł��B
 * ���b�Z�[�W��ύX����ꍇ�AsetMessage(String message) ���Ăяo���A�C�ӂ̃��b�Z�[�W���w�肵�ĉ������B
 * �������w�肵�Ȃ��ƊJ���Ă����ɕ��Ă��܂��܂��B<BR>
 * <P>
 *
 * 
 * ���L�Ɏg�p���@�������܂��B
 *     WaitDialog wait = new WaitDialog(this);<BR>
 *     wait.setProcess(new Runnable(){ <BR>
 *        public void run(){<BR>
 *            // ����<BR>
 *            ........<BR>
 *            // �������I�������� wait.setVisible(false) ���Ăт܂�<BR>
 *            wait.setVisible(false);
 *        }<BR>
 *     });<BR>
 *     wait.show();<BR>
 * 
 * @version $Revision: 1.1.1.1 $ $Date: 2003/02/26 05:38:53 $
 */
package jp.co.netsol.ncc.components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WaitDialog extends JDialog implements Runnable {
/* -------------------------------------------------------------------
 �萔
------------------------------------------------------------------- */
	/** �f�t�H���g���b�Z�[�W */
	public static final String defaultMessage = "���΂炭���҂�������";
/* -------------------------------------------------------------------
 �t�B�[���h
------------------------------------------------------------------- */
	/** �����X���b�h */
	protected Thread process;

	/** �����t���O */
	protected boolean status = true;
/* -------------------------------------------------------------------
 �R���|�[�l���g��`
------------------------------------------------------------------- */
	/** ���������b�Z�[�W */
	protected JLabel message = new JLabel();
/* -------------------------------------------------------------------
 �R���X�g���N�^��`
------------------------------------------------------------------- */
	/**
	 * �e��ʂ��w�肵�č쐬���܂��B
	 *
	 * @param frame		�e���
	 */
	public WaitDialog(JFrame frame) {
		super(frame);
		initComponents();
	}
	/**
	 * �e��ʂ��w�肵�č쐬���܂��B
	 *
	 * @param dialog	�e���
	 */
	public WaitDialog(JDialog dialog) {
		super(dialog);
		initComponents();
	}
/* -------------------------------------------------------------------
 �R���|�[�l���g�̏�����
------------------------------------------------------------------- */
	/**
	 * �R���|�[�l���g�̏�����
	 */
	private void initComponents() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		message.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(message);

		this.message.setText(defaultMessage);

		setModal(true);

		setSize(320, 120);
		setResizable(false);
		centerScreen();
	}
	
/* -------------------------------------------------------------------
 ��ʂ̒�����
------------------------------------------------------------------- */
	/**
	 * ��ʂ̒����񂹂����܂��B
	 *
	 */
	private void centerScreen() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(d.getWidth() - this.getWidth())/2,
					(int)(d.getHeight() - this.getHeight())/2);
	}
/* -------------------------------------------------------------------
 �����̊��蓖��
------------------------------------------------------------------- */
	/**
	 * ���s���鏈����ݒ肵�܂��B
	 *
	 * @param process ����
	 */
	public void setProcess(Runnable process) {
		this.process = new Thread(process);
	}
/* -------------------------------------------------------------------
 ���������b�Z�[�W�̐ݒ�
------------------------------------------------------------------- */
	/**
	 * ���������b�Z�[�W�̐ݒ�
	 *
	 * @param	message		���b�Z�[�W
	 */
	public void setMessage(String message) {
		this.message.setText(message);
	}
/* -------------------------------------------------------------------
 ��ʕ\���E�����J�n
------------------------------------------------------------------- */
	/**
	 * ��ʕ\���E�����J�n
	 *
	 */
	public void show() {

		Thread t = new Thread(this);
		t.start();

		super.show();
	}

/* -------------------------------------------------------------------
 �����t���O
------------------------------------------------------------------- */
	/**
	 * �����̏�Ԃ�Ԃ��܂��B
	 *
	 * @return			true - ������  false - ������
	 */
	public boolean isStatus(){
		return status;
	}

	/**
	 * �����t���O��ݒ肵�܂��B
	 *
	 * @param status		�f�t�H���g��true
	 */
	public void setStatus(boolean status){
		this.status = status;
	}

/* -------------------------------------------------------------------
 �������s
------------------------------------------------------------------- */
	/**
	 * �������s
	 *
	 */
	public void run() {
		Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
		Cursor oldCursor = getCursor();
		setCursor(cursor);
		
		if(process != null) {
			process.start();
			while(!isShowing()) {
				Thread.yield();
			}
			paintAll(getGraphics());
			try {
				process.join();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		status = false;
		setCursor(oldCursor);
		dispose();
	}
}
