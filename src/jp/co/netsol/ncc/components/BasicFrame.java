/**
 * JFrame���p�����āA�ȒP�ȃt���[�������������R���|�[�l���g�ł�.
 *
 *
 * @version $Revision: 1.1.1.1 $ $Date: 2003/02/26 05:38:52 $
 */
package jp.co.netsol.ncc.components;

import javax.swing.*;
import java.awt.*;

public class BasicFrame extends JFrame{
/* -------------------------------------------------------------------
 �R���|�[�l���g
------------------------------------------------------------------- */
	/** ���C���p�l�� */
	protected JPanel mainPanel = new JPanel();
/* -------------------------------------------------------------------
 �R���X�g���N�^
------------------------------------------------------------------- */
	/**
	 * BasicFrame �𐶐����܂�.
	 *
	 */
	public BasicFrame(){
		init();
	}
/* -------------------------------------------------------------------
 ��ʐ���
------------------------------------------------------------------- */
	protected void init(){
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		getContentPane().setLayout(gbl);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(8, 16, 8, 16);
		gbc.weightx = 1.0f;
		gbc.weighty = 1.0f;
		getContentPane().add(mainPanel, gbc);
	}
/* -------------------------------------------------------------------
 ��ʂ̒�����
------------------------------------------------------------------- */
	/**
	 * ��ʂ̒�����
	 */
	public void centerScreen() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(d.getWidth() - this.getWidth())/2,
					(int)(d.getHeight() - this.getHeight())/2);
	}
/* -------------------------------------------------------------------
 ���C���p�l���̎擾
------------------------------------------------------------------- */
	/**
	 * ���C���p�l���̎擾.
	 *
	 * @return	���C���p�l��
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}
}
