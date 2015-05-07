/**
 * ���b�Z�[�W�_�C�A���O��\�����܂��B<BR>
 * ������ JOptionPane �N���X���g���܂��B
 *
 */
package jp.co.netsol.ncc.components;

import java.awt.*;
import javax.swing.*;

public class MessageDialog{
/* -----------------------------------------------------------------
 �萔
----------------------------------------------------------------- */
	/** �\�����Ȃ��G���[ */
	public static final String ExceptionMessage = "�\�����Ȃ��G���[���������܂���";
	/** */
	private static final String	WARNING_TITLE = "�x��";
/* -----------------------------------------------------------------
 ���b�Z�[�W�_�C�A���O�n
----------------------------------------------------------------- */
	/**
	 * ��O�����������ꍇ�̃_�C�A���O�ł��B
	 *
	 */
	public static void ExceptionDialog(){
		ExceptionDialog(ExceptionMessage);
	}
	/**
	 * ��O�����������ꍇ�̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 */
	public static void ExceptionDialog(Component comp){
		ExceptionDialog(comp, ExceptionMessage);
	}
	/**
	 * ��O�����������ꍇ�̃_�C�A���O�ł��B
	 *
	 * @param message		���b�Z�[�W
	 */
	public static void ExceptionDialog(String message){
		ExceptionDialog(null, message);
	}
	/**
	 * ��O�����������ꍇ�̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
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
 �C���t�H���[�V�����n
----------------------------------------------------------------- */
	/**
	 * �x���A�C���t�H���[�V�����̃_�C�A���O�ł��B
	 *
	 * @param message		���b�Z�[�W
	 */
	public static void InfomationDialog(){
		InfomationDialog("");
	}
	/**
	 * �x���A�C���t�H���[�V�����̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 */
	public static void InfomationDialog(Component comp){
		InfomationDialog(comp, "");
	}
	/**
	 * �x���A�C���t�H���[�V�����̃_�C�A���O�ł��B
	 *
	 * @param message		���b�Z�[�W
	 */
	public static void InfomationDialog(String message){
		InfomationDialog(null, message);
	}
	/**
	 * �x���A�C���t�H���[�V�����̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
	 */
	public static void InfomationDialog(Component comp, String message){
		InfomationDialog(null, message, "");
	}
	/**
	 * �x���A�C���t�H���[�V�����̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
	 * @param title			�^�C�g��
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
	 * �x���̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
	 */
	public static void WarningDialog(Component comp, String message){
		WarningDialog( comp, message, WARNING_TITLE);
	}
	/**
	 * �x���̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
	 * @param title			�^�C�g��
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
	 * �m�F�̃_�C�A���O�ł��B
	 *
	 * @param comp			�e�R���|�[�l���g
	 * @param message		���b�Z�[�W
	 * @param title			�^�C�g��
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
