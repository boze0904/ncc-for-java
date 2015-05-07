/**
 * オペレーションボタンを実装したパネルです.
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
 メイン
-------------------------------------------------------- */
	public static void main(String[] args){
		BasicFrame frame = new BasicFrame();
		frame.setTitle("オペレーションパネル");
		JPanel panel = frame.getMainPanel();
		panel.setLayout(new BorderLayout());
		String[] name = {"登録", "リセット", "閉じる"};
		panel.add(new OperationPanel(OperationPanelable.THREE_TYPE, name), BorderLayout.SOUTH);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
/* --------------------------------------------------------
 変数
-------------------------------------------------------- */
	/** オペレーション構成タイプ */
	private int type;
	/** ボタンコンポーネントの名前 */
	private String[] names;
/* --------------------------------------------------------
 コンポーネント
-------------------------------------------------------- */
	/** ボタンコンポーネントが格納されているオブジェクト */
	private Vector v = new Vector();
/* --------------------------------------------------------
 コンストラクタ
-------------------------------------------------------- */
	/**
	 * OperationPanelableで定義されてある構成タイプを指定し
	 * OperationPanelを生成します。
	 *
	 */
	public OperationPanel(int type){
		this(type, null);
	}
	/**
	 * OperationPanelableで定義されてある構成タイプを指定し<BR>
	 * かつ、ボタンコンポーネントに定義する名前を設定します。
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
 コンポーネント初期化
-------------------------------------------------------- */
	/**
	 * コンポーネントの初期化、及びレイアウトを設定します.
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
 SINGLE_TYPE構築
-------------------------------------------------------- */
	/**
	 * SINGLE_TYPE の構築をします。
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
 TWO_TYPE構築
-------------------------------------------------------- */
	/**
	 * TWO_TYPE の構築をします。
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
 THREE_TYPE構築
-------------------------------------------------------- */
	/**
	 * THREE_TYPE の構築をします。
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
 FOUR_TYPE構築
-------------------------------------------------------- */
	/**
	 * FOUR_TYPE の構築をします。
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
 ボタンコンポーネント取得メソッド
-------------------------------------------------------- */
	/**
	 * ボタンコンポーネントを取得します。<BR>
	 * 構成タイプにあわせてコンポーネントの配列を返します。
	 *
	 * @return ボタンコンポーネント
	 */
	public Object getButton(){
		JButton[] btn = new JButton[v.size()];
		for(int i = 0; i < btn.length; i++){
			btn[i] = (JButton)v.get(i);
		}
		return btn;
	}
}
