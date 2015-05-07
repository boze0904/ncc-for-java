/**
 * �I�y���[�V�����{�^�������������p�l���ł�.
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2003/02/26 05:38:53 $
 */
package jp.co.netsol.ncc.components;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class OperationPanel extends JPanel implements OperationPanelable{
/* --------------------------------------------------------
 ���C��
-------------------------------------------------------- */
	public static void main(String[] args){
		BasicFrame frame = new BasicFrame();
		frame.setTitle("�I�y���[�V�����p�l��");
		JPanel panel = frame.getMainPanel();
		panel.setLayout(new BorderLayout());
		String[] name = {"�o�^", "���Z�b�g", "����"};
		panel.add(new OperationPanel(OperationPanelable.THREE_TYPE, name), BorderLayout.SOUTH);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
/* --------------------------------------------------------
 �ϐ�
-------------------------------------------------------- */
	/** �I�y���[�V�����\���^�C�v */
	private int type;
	/** �{�^���R���|�[�l���g�̖��O */
	private String[] names;
/* --------------------------------------------------------
 �R���|�[�l���g
-------------------------------------------------------- */
	/** �{�^���R���|�[�l���g���i�[����Ă���I�u�W�F�N�g */
	private Vector v = new Vector();
/* --------------------------------------------------------
 �R���X�g���N�^
-------------------------------------------------------- */
	/**
	 * OperationPanelable�Œ�`����Ă���\���^�C�v���w�肵
	 * OperationPanel�𐶐����܂��B
	 *
	 */
	public OperationPanel(int type){
		this(type, null);
	}
	/**
	 * OperationPanelable�Œ�`����Ă���\���^�C�v���w�肵<BR>
	 * ���A�{�^���R���|�[�l���g�ɒ�`���閼�O��ݒ肵�܂��B
	 *
	 */
	public OperationPanel(int type, String[] names){
		this.type = type;
		if(names == null){
			this.names = new String[0];
		}else{
			this.names = names;
		}
		init();
	}
/* --------------------------------------------------------
 �R���|�[�l���g������
-------------------------------------------------------- */
	/**
	 * �R���|�[�l���g�̏������A�y�у��C�A�E�g��ݒ肵�܂�.
	 *
	 */
	protected void init(){
		JButton[] btn = new JButton[type];
		for(int i = 0; i < type; i++){
			String name = null;
			if(names[i] == null || names[i].length() == 0){
				name = "";
			}else{
				name = names[i];
			}
			btn[i] = new JButton(name);
			btn[i].setPreferredSize(new Dimension(85, 30));
		}

		switch(type){
			case SINGLE_TYPE:
				setSingleType(btn);
				break;
			case TWO_TYPE:
				setTwoType(btn);
				break;
			case THREE_TYPE:
				setThreeType(btn);
				break;
			case FOUR_TYPE:
				setFourType(btn);
				break;
			default:
				break;
		}
	}
/* --------------------------------------------------------
 SINGLE_TYPE�\�z
-------------------------------------------------------- */
	/**
	 * SINGLE_TYPE �̍\�z�����܂��B
	 *
	 */
	private void setSingleType(JButton[] btn){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(btn[0]);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.EAST);

		v.add(btn[0]);
	}
/* --------------------------------------------------------
 TWO_TYPE�\�z
-------------------------------------------------------- */
	/**
	 * TWO_TYPE �̍\�z�����܂��B
	 *
	 */
	private void setTwoType(JButton[] btn){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
		panel.add(btn[0]);
		panel.add(btn[1]);
		setLayout(new BorderLayout());
		add(panel, BorderLayout.EAST);

		v.add(btn[0]);
		v.add(btn[1]);
	}
/* --------------------------------------------------------
 THREE_TYPE�\�z
-------------------------------------------------------- */
	/**
	 * THREE_TYPE �̍\�z�����܂��B
	 *
	 */
	private void setThreeType(JButton[] btn){
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p1.add(btn[0]);
		p1.add(btn[1]);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
		p2.add(btn[2]);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);

		v.add(btn[0]);
		v.add(btn[1]);
		v.add(btn[2]);
	}
/* --------------------------------------------------------
 FOUR_TYPE�\�z
-------------------------------------------------------- */
	/**
	 * FOUR_TYPE �̍\�z�����܂��B
	 *
	 */
	private void setFourType(JButton[] btn){
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		p1.add(btn[0]);
		p1.add(btn[1]);
		p1.add(btn[2]);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
		p2.add(btn[3]);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);

		v.add(btn[0]);
		v.add(btn[1]);
		v.add(btn[2]);
		v.add(btn[3]);
	}
/* --------------------------------------------------------
 �{�^���R���|�[�l���g�擾���\�b�h
-------------------------------------------------------- */
	/**
	 * �{�^���R���|�[�l���g���擾���܂��B<BR>
	 * �\���^�C�v�ɂ��킹�ăR���|�[�l���g�̔z���Ԃ��܂��B
	 *
	 * @return �{�^���R���|�[�l���g
	 */
	public Object getButton(){
		JButton[] btn = new JButton[v.size()];
		for(int i = 0; i < btn.length; i++){
			btn[i] = (JButton)v.get(i);
		}
		return btn;
	}
}
