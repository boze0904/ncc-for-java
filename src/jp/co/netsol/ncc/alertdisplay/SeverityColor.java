/**
 * Severity色を表現します。
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SeverityColor{

/* -----------------------------------------------------------------------------
 SeverityColor定数
----------------------------------------------------------------------------- */
	/** Normal */
	public static final int Normal = 1;
	/** Normal Color */
	public static final Color NormalColor = Color.GREEN;

	/** Indeterminate */
    public static final int Indeterminate = 2;
	/** IndeterminateColor */
    public static final Color IndeterminateColor = Color.ORANGE;

	/** Warning */
    public static final int Warning = 3;
	/** WarningColor */
    public static final Color WarningColor = Color.BLUE;

	/** Minor */
    public static final int Minor = 4;
	/** MinorColor */
    public static final Color MinorColor = Color.YELLOW;

	/** Major */
    public static final int Major = 5;
	/** MajorColor */
    public static final Color MajorColor = Color.ORANGE;

	/** Critical */
    public static final int Critical = 6;
	/** CriticalColor */
    public static final Color CriticalColor = Color.RED;

/* -----------------------------------------------------------------------------
 変数
----------------------------------------------------------------------------- */
	/** Severity */
	private int severity;
	/** 表示名 */
	private Object name;

	/** 選択フラグ */
	private boolean select;

/* -----------------------------------------------------------------------------
 コンストラクタ
----------------------------------------------------------------------------- */
	/**
	 * 表示名を渡します。Severityを決めずに表示します。<BR>
	 * デフォルトは背景白、テキスト色黒です。
	 *
	 * @param name			表示名
	 */
	public SeverityColor(Object name){
		this(-1, name);
	}

	/**
	 * Severityと表示名を渡します
	 *
	 * @param severity		Severity
	 * @param name			表示名
	 */
	public SeverityColor(int severity, Object name){
		this.severity = severity;
		this.name = name;
	}

/* -----------------------------------------------------------------------------
 メソッド
----------------------------------------------------------------------------- */
	/**
	 * Severity色を返します。
	 *
	 * @return		Severity色
	 */
	public Color getSeverityColor(){

		switch(severity){
			case Normal:
				return NormalColor;
			case Indeterminate:
				return IndeterminateColor;
			case Warning:
				return WarningColor;
			case Minor:
				return MinorColor;
			case Major:
				return MajorColor;
			case Critical:
				return CriticalColor;
			default:
				return Color.WHITE;
		}
	}

	/**
	 * テキスト色を返します。
	 *
	 * @return		テキスト色
	 */
	public Color getTextColor(){

		switch(severity){
			case Warning:
				return Color.WHITE;
			case Critical:
				return Color.WHITE;
			default:
				return Color.BLACK;
		}
	}

	/**
	 * toStringメソッドをオーバーライドして表示します。
	 *
	 * @return			表示
	 */
	public String toString(){
		return name.toString();
	}


	/**
	 * severityを取得します。
	 *
	 * @return			Severity
	 */
	public int getSeverity(){
		return severity;
	}


	/**
	 * 選択されているかどうかを返します。
	 *
	 * @return		true - 選択されている  false - 選択されていない
	 */
	public boolean isSelected(){
		return select;
	}

	/**
	 * 選択かどうかを設定します。
	 *
	 * @param select		選択
	 */
	public void select(boolean select){
		this.select = select;
	}
}
