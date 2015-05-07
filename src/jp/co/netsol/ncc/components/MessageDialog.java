/**
 * メッセージダイアログを表示します。<BR>
 * 実装は JOptionPane クラスを使います。
 *
 */
package jp.co.netsol.ncc.components;

import java.awt.*;
import javax.swing.*;

public class MessageDialog{
/* -----------------------------------------------------------------
 定数
----------------------------------------------------------------- */
	/** 予期しないエラー */
	public static final String ExceptionMessage = "予期しないエラーが発生しました";
	/** */
	private static final String	WARNING_TITLE = "警告";
/* -----------------------------------------------------------------
 メッセージダイアログ系
----------------------------------------------------------------- */
	/**
	 * 例外が発生した場合のダイアログです。
	 *
	 */
	public static void ExceptionDialog(){
		ExceptionDialog(ExceptionMessage);
	}
	/**
	 * 例外が発生した場合のダイアログです。
	 *
	 * @param comp			親コンポーネント
	 */
	public static void ExceptionDialog(Component comp){
		ExceptionDialog(comp, ExceptionMessage);
	}
	/**
	 * 例外が発生した場合のダイアログです。
	 *
	 * @param message		メッセージ
	 */
	public static void ExceptionDialog(String message){
		ExceptionDialog(null, message);
	}
	/**
	 * 例外が発生した場合のダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 */
	public static void ExceptionDialog(Component comp, String message){
		JOptionPane.showMessageDialog(
			comp,
			message,
			"",
			JOptionPane.ERROR_MESSAGE
		);
	}
/* -----------------------------------------------------------------
 インフォメーション系
----------------------------------------------------------------- */
	/**
	 * 警告、インフォメーションのダイアログです。
	 *
	 * @param message		メッセージ
	 */
	public static void InfomationDialog(){
		InfomationDialog("");
	}
	/**
	 * 警告、インフォメーションのダイアログです。
	 *
	 * @param comp			親コンポーネント
	 */
	public static void InfomationDialog(Component comp){
		InfomationDialog(comp, "");
	}
	/**
	 * 警告、インフォメーションのダイアログです。
	 *
	 * @param message		メッセージ
	 */
	public static void InfomationDialog(String message){
		InfomationDialog(null, message);
	}
	/**
	 * 警告、インフォメーションのダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 */
	public static void InfomationDialog(Component comp, String message){
		InfomationDialog(null, message, "");
	}
	/**
	 * 警告、インフォメーションのダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 * @param title			タイトル
	 */
	public static void InfomationDialog(Component comp, String message, String title ){
		JOptionPane.showMessageDialog(
			comp,
			message,
			title,
			JOptionPane.INFORMATION_MESSAGE
		);
	}
	/**
	 * 警告のダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 */
	public static void WarningDialog(Component comp, String message){
		WarningDialog( comp, message, WARNING_TITLE);
	}
	/**
	 * 警告のダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 * @param title			タイトル
	 */
	public static void WarningDialog(Component comp, String message, String title){
		JOptionPane.showMessageDialog(
			comp,
			message,
			title,
			JOptionPane.WARNING_MESSAGE
		);
	}
	/**
	 * 確認のダイアログです。
	 *
	 * @param comp			親コンポーネント
	 * @param message		メッセージ
	 * @param title			タイトル
	 */
	public static int ConfirmDialog(Component comp, String message, String title){
		return JOptionPane.showOptionDialog(
			comp,
			message,
			title,
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null, null, null
		);
	}
}
