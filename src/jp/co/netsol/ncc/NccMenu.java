/**
 * メニュー画面です。
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

	/** リソース取得用クラス名 */
	private String CLASS_NAME = this.getClass().getName() + ".";

	/** タイトル */
	protected String title = NameResource.getLabelName(CLASS_NAME + "Title", "Menu");

	/** メニューバー */
	protected JMenuBar jMenuBar = new JMenuBar();
	/** Fileメニュー */
	protected JMenu jMenuFile = new JMenu();
	/** 終了 */
	private JMenuItem jMenuFileClose = new JMenuItem();

	/** AlertDisplayボタン */
	protected JButton alertBtn = new JButton(NameResource.getLabelName(CLASS_NAME + "AlertDisplayButton", "AlertDisplay"));
	/** Eventボタン */
	protected JButton eventBtn = new JButton(NameResource.getLabelName(CLASS_NAME + "EventButton", "Event"));

	/** NxCAAccessor */
	protected NxCAAccessor access;


	/**
	 * 親オブジェクトを指定して、NccMenuを構築します。
	 *
	 * @param rt		Returnable
	 * @param access	NxCAAccessor
	 */
	public NccMenu(Returnable rt, NxCAAccessor access){
		super(rt);

		this.access = access;

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
		jMenuFileClose.setText(NameResource.getLabelName(CLASS_NAME + "MenuExit", "Close(X)"));
		jMenuFileClose.setMnemonic( KeyEvent.VK_X );
		jMenuFileClose.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		jMenuFile.add( jMenuFileClose );
		jMenuBar.add( jMenuFile );

		// メニューバーを設定
		setJMenuBar(jMenuBar);
	}

	/**
	 * コンポーネント初期化及び、配置をします。
	 *
	 */
	protected void initComponents(){
		setTitle(title);

		JPanel panel = getMainPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// デフォルト設定
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;


		// AlertDisplayボタン設定
		alertBtn.setPreferredSize(new Dimension(200, 30));
		panel.add(alertBtn, gbc);

		gbc.insets = new Insets(0, 10, 10, 10);

		// Eventボタン設定
		gbc.weighty = 1.0;
		eventBtn.setPreferredSize(new Dimension(200, 30));
		eventBtn.setEnabled(false);
		panel.add(eventBtn, gbc);

		pack();

		centerScreen();

	}


	/**
	 * イベントを設定します。
	 *
	 */
	protected void setEvent(){

		// 「AlertDisplay」ボタンイベント
		alertBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				processAlertDisplay();
			}
		});

		// 「Event」ボタンイベント
		eventBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});

	}


	/**
	 * AlertDisplay画面を構築します。
	 *
	 */
	private void processAlertDisplay(){
		AlertDisplay alert = new AlertDisplay(this, access);
		alert.setVisible(true);
		// アラート取得
		alert.openAlert();
	}

}
