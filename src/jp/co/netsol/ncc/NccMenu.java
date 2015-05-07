/**
 * ���j���[��ʂł��B
 *
 */
package jp.co.netsol.ncc;

import jp.co.netsol.ncc.alertdisplay.*;
import jp.co.netsol.ncc.components.*;
import jp.co.netsol.ncc.resource.*;
import jp.co.netsol.ncc.util.*;

import NxCorba.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class NccMenu extends DefaultFrame{

	/** ���\�[�X�擾�p�N���X�� */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** �^�C�g�� */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "Menu");

	/** ���j���[�o�[ */
	protected JMenuBar jMenuBar = new JMenuBar();
	/** File���j���[ */
	protected JMenu jMenuFile = new JMenu();
	/** �I�� */
	private JMenuItem jMenuFileClose = new JMenuItem();

	/** AlertDisplay�{�^�� */
	protected JButton alertBtn = new JButton(NameResource.getLabelName(CLASS_NAME + "AlertDisplayButton", "AlertDisplay"));
	/** Event�{�^�� */
	protected JButton eventBtn = new JButton(NameResource.getLabelName(CLASS_NAME + "EventButton", "Event"));

	/** NxCAAccessor */
	protected NxCAAccessor access;


	/**
	 * �e�I�u�W�F�N�g���w�肵�āANccMenu���\�z���܂��B
	 *
	 * @param rt		Returnable
	 * @param access	NxCAAccessor
	 */
	public NccMenu(Returnable rt, NxCAAccessor access){
		super(rt);

		this.access = access;

		// ���j���[�̏�����
		initMenu();

		// �R���|�[�l���g�̔z�u�y�я�����
		initComponents();

		// �C�x���g�ݒ�
		setEvent();

	}

	/**
	 * ���j���[�����������܂��B
	 *
	 */
	protected void initMenu(){
		// �t�@�C�����j���[
		jMenuFile.setText(NameResource.getLabelName(CLASS_NAME + "MenuFile", "File(F)"));
		jMenuFile.setMnemonic( KeyEvent.VK_F );
		jMenuFileClose.setText(NameResource.getLabelName(CLASS_NAME + "MenuExit", "Close(X)"));
		jMenuFileClose.setMnemonic( KeyEvent.VK_X );
		jMenuFileClose.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		jMenuFile.add( jMenuFileClose );
		jMenuBar.add( jMenuFile );

		// ���j���[�o�[��ݒ�
		setJMenuBar(jMenuBar);
	}

	/**
	 * �R���|�[�l���g�������y�сA�z�u�����܂��B
	 *
	 */
	protected void initComponents(){
		setTitle(title);

		JPanel panel = getMainPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// �f�t�H���g�ݒ�
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;


		// AlertDisplay�{�^���ݒ�
		alertBtn.setPreferredSize(new Dimension(200, 30));
		panel.add(alertBtn, gbc);

		gbc.insets = new Insets(0, 10, 10, 10);

		// Event�{�^���ݒ�
		gbc.weighty = 1.0;
		eventBtn.setPreferredSize(new Dimension(200, 30));
		eventBtn.setEnabled(false);
		panel.add(eventBtn, gbc);

		pack();

		centerScreen();

	}


	/**
	 * �C�x���g��ݒ肵�܂��B
	 *
	 */
	protected void setEvent(){

		// �uAlertDisplay�v�{�^���C�x���g
		alertBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processAlertDisplay();
			}
		});

		// �uEvent�v�{�^���C�x���g
		eventBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});

	}


	/**
	 * AlertDisplay��ʂ��\�z���܂��B
	 *
	 */
	private void processAlertDisplay(){
		AlertDisplay alert = new AlertDisplay(this, access);
		alert.setVisible(true);
		// �A���[�g�擾
		alert.openAlert();
	}

}
