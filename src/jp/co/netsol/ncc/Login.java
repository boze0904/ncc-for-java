/**
 * NetExpertへログイン画面です。
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

	// フォントを設定
	static{
		UI.setDefaultFont();
	}

	/** リソース取得用クラス名 */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** タイトル */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "Login");

	/** メニューバー */
	protected JMenuBar jMenuBar = new JMenuBar();
	/** Fileメニュー */
	protected JMenu jMenuFile = new JMenu();
	/** 終了 */
	private JMenuItem jMenuFileExit = new JMenuItem();

	/** ログイン名 ラベル */
	protected JLabel userLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "UserLabel", "User"));
	/** ログイン名 テキスト */
	protected JTextField userTxt = new JTextField();
	/** パスワード ラベル */
	protected JLabel passwordLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "PasswordLabel", "Password"));
	/** パスワード テキスト */
	protected JPasswordField passwordTxt = new JPasswordField();

	/** 選択言語 */
	protected Object[] lang = {"English", "Japanese"};
	/** 選択言語ラベル */
	protected JLabel langLbl = new JLabel(NameResource.getLabelName(CLASS_NAME + "LangLabel", "Language"));
	/** 言語選択コンボボックス */
	protected JComboBox langCombo = new JComboBox(lang);

	/** オペレーションパネルボタン名前 */
	protected String[] btnNames = {NameResource.getLabelName(CLASS_NAME + "LoginButton", "Login"),
									NameResource.getLabelName(CLASS_NAME + "ExitButton", "Exit")};
	/** オペレーションパネル */
	protected OperationPanel oparationPnl = new OperationPanel(OperationPanelable.TWO_TYPE, btnNames);


	/** NxCAAccessor */
	protected NxCAAccessor access;


	// メイン
	public static void main(String[] args){
		new Login();
	}

	/**
	 * コンストラクタ
	 *
	 */
	public Login(){

		// ラベルリソース設定
/*
		try{
			NameResource.load("japanese_label.properties");
		}catch(Exception e){}
*/
		// NetExpert通信準備
		initNetExpert();

		// メニューの初期化
		initMenu();

		// コンポーネントの配置及び初期化
		initComponents();

		// イベント設定
		setEvent();

		// 画面表示
		setVisible(true);
	}

	/**
	 * NxCAAccessorオブジェクトを渡して、Loginを構築します。
	 *
	 * @param access		NxCAAccessor
	 */
	public Login(NxCAAccessor access){
		this.access = access;


		// ラベルリソース設定
		try{
			NameResource.load("default_label.properties");
		}catch(Exception e){}

		// メニューの初期化
		initMenu();

		// コンポーネントの配置及び初期化
		initComponents();

		// イベント設定
		setEvent();
	}


	/**
	 * メニューを初期化します。
	 *
	 */
	protected void initMenu(){
		// ファイルメニュー
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

		// メニューバーを設定
		setJMenuBar(jMenuBar);
	}


	/**
	 * コンポーネント初期化及び、配置をします。
	 *
	 */
	protected void initComponents(){
		// タイトル設定
		setTitle(title);

		userTxt.setPreferredSize(new Dimension(200, 20));
		passwordTxt.setPreferredSize(new Dimension(200, 20));
		langCombo.setPreferredSize(new Dimension(200, 20));

		// パネル
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


		// メインパネル
		JPanel panel = getMainPanel();
		panel.setLayout(new BorderLayout(0, 10));		// 高さは１０間隔

		panel.add(loginPnl, BorderLayout.CENTER);

		// オペレーションパネル add
		panel.add(oparationPnl, BorderLayout.SOUTH);

		pack();

		centerScreen();

	}


	/**
	 * イベントを設定します。
	 *
	 */
	protected void setEvent(){
		// ウィンドウのクローズ処理
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				if(access != null){
					try{
						access.disconnect();
					}catch(NxException ex){}
				}
			}
		});


		// 言語選択イベント
		langCombo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processLang();
			}
		});


		// オペレーションボタンイベント設定
		JButton[] o = (JButton[])oparationPnl.getButton();
		JButton loginBtn = o[0];
		JButton closeBtn = o[1];

		// 「ログイン」ボタンイベント
		loginBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processLogin();
			}
		});

		// 「閉じる」ボタンイベント
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
	 * processLangを定義します。
	 *
	 */
	private void processLang(){
		// コンボボックスインデックスを取得
		int index = langCombo.getSelectedIndex();

		if(index == 0){
			// ラベルリソース設定
			try{
				NameResource.load("default_label.properties");
			}catch(Exception e){}
		}
		else
		if(index == 1){
			// ラベルリソース設定
			try{
				NameResource.load("japanese_label.properties");
			}catch(Exception e){}
		}
		else{
			// ラベルリソース設定
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
	 * processLoginを定義します。
	 *
	 */
	private void processLogin(){
		String l = null;
		String p = null;
		// テキストチェック
		try{
			l = userTxt.getText();
			p = new String(passwordTxt.getPassword());
		}catch(Exception e){
			e.printStackTrace();
			return;
		}

		// チェック
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
	 * processLoginを定義します。
	 *
	 * @param wait		WaitDialog
	 * @param login		ユーザ名
	 * @param password	パスワード
	 */
	private void processLogin(WaitDialog wait, String login, String password){
		// NetExpertへログイン
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
	 * NetExpertと通信準備をします。
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
