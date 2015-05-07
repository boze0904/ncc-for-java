/**
 * 処理を実行中に処理中メッセージを表示するダイアログです。<BR>
 * デフォルトは処理が完了するまで画面が閉ないためモーダルです。
 * モーダルを解除するには親クラスの wait.setModal(false)を呼び出して下さい。<BR>
 * デフォルトのメッセージは「しばらくお待ち下さい」です。
 * メッセージを変更する場合、setMessage(String message) を呼び出し、任意のメッセージを指定して下さい。
 * 処理を指定しないと開いてすぐに閉じてしまいます。<BR>
 * <P>
 *
 * 
 * 下記に使用方法を示します。
 *     WaitDialog wait = new WaitDialog(this);<BR>
 *     wait.setProcess(new Runnable(){ <BR>
 *        public void run(){<BR>
 *            // 処理<BR>
 *            ........<BR>
 *            // 処理が終了したら wait.setVisible(false) を呼びます<BR>
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
 定数
------------------------------------------------------------------- */
	/** デフォルトメッセージ */
	public static final String defaultMessage = "しばらくお待ち下さい";
/* -------------------------------------------------------------------
 フィールド
------------------------------------------------------------------- */
	/** 処理スレッド */
	protected Thread process;

	/** 処理フラグ */
	protected boolean status = true;
/* -------------------------------------------------------------------
 コンポーネント定義
------------------------------------------------------------------- */
	/** 処理中メッセージ */
	protected JLabel message = new JLabel();
/* -------------------------------------------------------------------
 コンストラクタ定義
------------------------------------------------------------------- */
	/**
	 * 親画面を指定して作成します。
	 *
	 * @param frame		親画面
	 */
	public WaitDialog(JFrame frame) {
		super(frame);
		initComponents();
	}
	/**
	 * 親画面を指定して作成します。
	 *
	 * @param dialog	親画面
	 */
	public WaitDialog(JDialog dialog) {
		super(dialog);
		initComponents();
	}
/* -------------------------------------------------------------------
 コンポーネントの初期化
------------------------------------------------------------------- */
	/**
	 * コンポーネントの初期化
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
 画面の中央寄せ
------------------------------------------------------------------- */
	/**
	 * 画面の中央寄せをします。
	 *
	 */
	private void centerScreen() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(d.getWidth() - this.getWidth())/2,
					(int)(d.getHeight() - this.getHeight())/2);
	}
/* -------------------------------------------------------------------
 処理の割り当て
------------------------------------------------------------------- */
	/**
	 * 実行する処理を設定します。
	 *
	 * @param process 処理
	 */
	public void setProcess(Runnable process) {
		this.process = new Thread(process);
	}
/* -------------------------------------------------------------------
 処理中メッセージの設定
------------------------------------------------------------------- */
	/**
	 * 処理中メッセージの設定
	 *
	 * @param	message		メッセージ
	 */
	public void setMessage(String message) {
		this.message.setText(message);
	}
/* -------------------------------------------------------------------
 画面表示・処理開始
------------------------------------------------------------------- */
	/**
	 * 画面表示・処理開始
	 *
	 */
	public void show() {

		Thread t = new Thread(this);
		t.start();

		super.show();
	}

/* -------------------------------------------------------------------
 処理フラグ
------------------------------------------------------------------- */
	/**
	 * 処理の状態を返します。
	 *
	 * @return			true - 処理中  false - 未処理
	 */
	public boolean isStatus(){
		return status;
	}

	/**
	 * 処理フラグを設定します。
	 *
	 * @param status		デフォルトはtrue
	 */
	public void setStatus(boolean status){
		this.status = status;
	}

/* -------------------------------------------------------------------
 処理実行
------------------------------------------------------------------- */
	/**
	 * 処理実行
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
