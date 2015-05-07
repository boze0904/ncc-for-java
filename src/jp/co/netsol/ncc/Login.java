/**
 * NetExpert�փ��O�C����ʂł��B
 *
 */
package jp.co.netsol.ncc;

import jp.co.netsol.ncc.alertdisplay.*;
import jp.co.netsol.ncc.components.*;
import jp.co.netsol.ncc.util.*;
import jp.co.netsol.ncc.resource.*;

import NxCorba.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends DefaultFrame{

	// �t�H���g��ݒ�
	static{
		UI.setDefaultFont();
	}

	/** ���\�[�X�擾�p�N���X�� */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** �^�C�g�� */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "Login");

	/** ���j���[�o�[ */
	protected JMenuBar jMenuBar = new JMenuBar();
	/** File���j���[ */
	protected JMenu jMenuFile = new JMenu();
	/** �I�� */
	private JMenuItem jMenuFileExit = new JMenuItem();

	/** ���O�C���� ���x�� */
	protected JLabel userLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "UserLabel", "User"));
	/** ���O�C���� �e�L�X�g */
	protected JTextField userTxt = new JTextField();
	/** �p�X���[�h ���x�� */
	protected JLabel passwordLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "PasswordLabel", "Password"));
	/** �p�X���[�h �e�L�X�g */
	protected JPasswordField passwordTxt = new JPasswordField();

	/** �I������ */
	protected Object[] lang = {"English", "Japanese"};
	/** �I�����ꃉ�x�� */
	protected JLabel langLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "LangLabel", "Language"));
	/** ����I���R���{�{�b�N�X */
	protected JComboBox langCombo = new JComboBox(lang);

	/** �I�y���[�V�����p�l���{�^�����O */
	protected String[] btnNames = {NameResource.getLabelName(CLASS_NAME + "LoginButton", "Login"),
									NameResource.getLabelName(CLASS_NAME + "ExitButton", "Exit")};
	/** �I�y���[�V�����p�l�� */
	protected OperationPanel oparationPnl = new OperationPanel(OperationPanelable.TWO_TYPE, btnNames);


	/** NxCAAccessor */
	protected NxCAAccessor access;


	// ���C��
	public static void main(String[] args){
		new Login();
	}

	/**
	 * �R���X�g���N�^
	 *
	 */
	public Login(){

		// ���x�����\�[�X�ݒ�
/*
		try{
			NameResource.load("japanese_label.properties");
		}catch(Exception e){}
*/
		// NetExpert�ʐM����
		initNetExpert();

		// ���j���[�̏�����
		initMenu();

		// �R���|�[�l���g�̔z�u�y�я�����
		initComponents();

		// �C�x���g�ݒ�
		setEvent();

		// ��ʕ\��
		setVisible(true);
	}

	/**
	 * NxCAAccessor�I�u�W�F�N�g��n���āALogin���\�z���܂��B
	 *
	 * @param access		NxCAAccessor
	 */
	public Login(NxCAAccessor access){
		this.access = access;


		// ���x�����\�[�X�ݒ�
		try{
			NameResource.load("default_label.properties");
		}catch(Exception e){}

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
		jMenuFileExit.setText(NameResource.getLabelName(CLASS_NAME + "MenuExit", "Exit(X)"));
		jMenuFileExit.setMnemonic( KeyEvent.VK_X );
		jMenuFileExit.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		jMenuFile.add( jMenuFileExit );
		jMenuBar.add( jMenuFile );

		// ���j���[�o�[��ݒ�
		setJMenuBar(jMenuBar);
	}


	/**
	 * �R���|�[�l���g�������y�сA�z�u�����܂��B
	 *
	 */
	protected void initComponents(){
		// �^�C�g���ݒ�
		setTitle(title);

		userTxt.setPreferredSize(new Dimension(200, 20));
		passwordTxt.setPreferredSize(new Dimension(200, 20));
		langCombo.setPreferredSize(new Dimension(200, 20));

		// �p�l��
		JPanel loginPnl = new JPanel();
		loginPnl.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		loginPnl.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		loginPnl.add(userLbl, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		loginPnl.add(userTxt, gbc);

		gbc.gridwidth = 1;
		loginPnl.add(passwordLbl, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		loginPnl.add(passwordTxt, gbc);

		gbc.gridwidth = 1;
		loginPnl.add(langLbl, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		loginPnl.add(langCombo, gbc);


		// ���C���p�l��
		JPanel panel = getMainPanel();
		panel.setLayout(new BorderLayout(0, 10));		// �����͂P�O�Ԋu

		panel.add(loginPnl, BorderLayout.CENTER);

		// �I�y���[�V�����p�l�� add
		panel.add(oparationPnl, BorderLayout.SOUTH);

		pack();

		centerScreen();

	}


	/**
	 * �C�x���g��ݒ肵�܂��B
	 *
	 */
	protected void setEvent(){
		// �E�B���h�E�̃N���[�Y����
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(access != null){
					try{
						access.disconnect();
					}catch(NxException ex){}
				}
			}
		});


		// ����I���C�x���g
		langCombo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processLang();
			}
		});


		// �I�y���[�V�����{�^���C�x���g�ݒ�
		JButton[] o = (JButton[])oparationPnl.getButton();
		JButton loginBtn = o[0];
		JButton closeBtn = o[1];

		// �u���O�C���v�{�^���C�x���g
		loginBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processLogin();
			}
		});

		// �u����v�{�^���C�x���g
		closeBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(access != null){
					try{
						access.disconnect();
					}catch(NxException ex){}
				}
				close();
			}
		});

	}


	/**
	 * processLang���`���܂��B
	 *
	 */
	private void processLang(){
		// �R���{�{�b�N�X�C���f�b�N�X���擾
		int index = langCombo.getSelectedIndex();

		if(index == 0){
			// ���x�����\�[�X�ݒ�
			try{
				NameResource.load("default_label.properties");
			}catch(Exception e){}
		}
		else
		if(index == 1){
			// ���x�����\�[�X�ݒ�
			try{
				NameResource.load("japanese_label.properties");
			}catch(Exception e){}
		}
		else{
			// ���x�����\�[�X�ݒ�
			try{
				NameResource.load("default_label.properties");
			}catch(Exception e){}
		}


		userLbl.setText(NameResource.getLabelName(CLASS_NAME + "UserLabel", "User"));
		passwordLbl.setText(NameResource.getLabelName(CLASS_NAME + "PasswordLabel", "Password"));
		langLbl.setText(NameResource.getLabelName(CLASS_NAME + "LangLabel", "Language"));

		JButton[] o = (JButton[])oparationPnl.getButton();
		JButton loginBtn = o[0];
		JButton closeBtn = o[1];
		loginBtn.setText(NameResource.getLabelName(CLASS_NAME + "LoginButton", "Login"));
		closeBtn.setText(NameResource.getLabelName(CLASS_NAME + "ExitButton", "Exit"));

		jMenuFile.setText(NameResource.getLabelName(CLASS_NAME + "MenuFile", "File(F)"));
		jMenuFileExit.setText(NameResource.getLabelName(CLASS_NAME + "MenuExit", "Exit(X)"));

		pack();
		paintAll(getGraphics());


	}

	/**
	 * processLogin���`���܂��B
	 *
	 */
	private void processLogin(){
		String l = null;
		String p = null;
		// �e�L�X�g�`�F�b�N
		try{
			l = userTxt.getText();
			p = new String(passwordTxt.getPassword());
		}catch(Exception e){
			e.printStackTrace();
			return;
		}

		// �`�F�b�N
		if(l == null || l.length() == 0){
			return;
		}
		if(p == null || p.length() == 0){
			return;
		}

		final String login = l;
		final String password = p;
		final WaitDialog wait = new WaitDialog(this);
		wait.setMessage(NameResource.getLabelName(CLASS_NAME + "ProcessLogin", "Login....."));
		wait.setProcess(new Runnable(){
			public void run(){
				processLogin(wait, login, password);
			}
		});
		wait.show();

	}

	/**
	 * processLogin���`���܂��B
	 *
	 * @param wait		WaitDialog
	 * @param login		���[�U��
	 * @param password	�p�X���[�h
	 */
	private void processLogin(WaitDialog wait, String login, String password){
		// NetExpert�փ��O�C��
		try{
			access.connect(login, password);
		}catch(Exception e){
			wait.setVisible(false);
			MessageDialog.ExceptionDialog(this, NameResource.getLabelName(CLASS_NAME + "LoginFail", "Login failed"));
			return;
		}

		wait.setVisible(false);
		NccMenu menu = new NccMenu(Login.this, access);
		menu.setVisible(true);
		lostControl();
	}


	/**
	 * NetExpert�ƒʐM���������܂��B
	 *
	 */
	protected void initNetExpert(){
		File file = new File("NxCorba.properties");
		try {
			access = new NxCAAccessor(file);
		} catch ( NxException ne ) {
			ne.printStackTrace();
		}
	}
}
