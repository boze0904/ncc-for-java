/**
 * デフォルトのフレーム処理を実装するフレームです。<BR>
 * 親画面を指定し、モーダル アンモーダルどちらも対応できます。
 *
 */
package jp.co.netsol.ncc.components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DefaultFrame extends BasicFrame implements Returnable{
/* -------------------------------------------------------------------
 変数
------------------------------------------------------------------- */
	/** 親オブジェクト */
	protected Returnable rt;
/* -------------------------------------------------------------------
 コンストラクタ
------------------------------------------------------------------- */
	/**
	 * アンモーダルタイプの画面を生成します。親オブジェクトを指定していないため、
	 * 親オブジェクトは無視されます。
	 *
	 */
	public DefaultFrame(){
		this(null);
	}
	/**
	 * 親オブジェクトを指定して、アンモーダルタイプの画面を生成します。
	 *
	 * @param rt		親オブジェクト
	 */
	public DefaultFrame(Returnable rt){
		this(rt, false);
	}
	/**
	 * 親オブジェクトを指定して、モーダルタイプ、もしくはアンモーダルタイプの画面を生成します。
	 *
	 * @param rt		親オブジェクト
	 * @param type		true - モーダル  false - アンモーダル
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
 ウインドウクローズ時の処理
------------------------------------------------------------------- */
	/**
	 * クローズ処理です。<BR>
	 * Windowの[X]（閉じるボタン）の処理を実装します。<BR>
	 * 親オブジェクトに制御を移します。
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
 クローズ処理
------------------------------------------------------------------- */
	/**
	 * クローズ処理です。<BR>
	 * 親オブジェクトが存在すれば呼び出します。
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
 制御取得
------------------------------------------------------------------- */
	/**
	 * 制御取得します。
	 *
	 */
	public void gainControl(){
//		setVisible(true);
		show();
	}
/* -------------------------------------------------------------------
 制御移行
------------------------------------------------------------------- */
	/**
	 * 制御移行します。
	 *
	 */
	public void lostControl(){
		setVisible(false);
	}
}
