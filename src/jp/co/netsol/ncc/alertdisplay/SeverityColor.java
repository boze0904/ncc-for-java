/**
 * Severity�F��\�����܂��B
 *
 */
package jp.co.netsol.ncc.alertdisplay;

import jp.co.netsol.ncc.components.table.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SeverityColor{

/* -----------------------------------------------------------------------------
 SeverityColor�萔
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
 �ϐ�
----------------------------------------------------------------------------- */
	/** Severity */
	private int severity;
	/** �\���� */
	private Object name;

	/** �I���t���O */
	private boolean select;

/* -----------------------------------------------------------------------------
 �R���X�g���N�^
----------------------------------------------------------------------------- */
	/**
	 * �\������n���܂��BSeverity�����߂��ɕ\�����܂��B<BR>
	 * �f�t�H���g�͔w�i���A�e�L�X�g�F���ł��B
	 *
	 * @param name			�\����
	 */
	public SeverityColor(Object name){
		this(-1, name);
	}

	/**
	 * Severity�ƕ\������n���܂�
	 *
	 * @param severity		Severity
	 * @param name			�\����
	 */
	public SeverityColor(int severity, Object name){
		this.severity = severity;
		this.name = name;
	}

/* -----------------------------------------------------------------------------
 ���\�b�h
----------------------------------------------------------------------------- */
	/**
	 * Severity�F��Ԃ��܂��B
	 *
	 * @return		Severity�F
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
	 * �e�L�X�g�F��Ԃ��܂��B
	 *
	 * @return		�e�L�X�g�F
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
	 * toString���\�b�h���I�[�o�[���C�h���ĕ\�����܂��B
	 *
	 * @return			�\��
	 */
	public String toString(){
		return name.toString();
	}


	/**
	 * severity���擾���܂��B
	 *
	 * @return			Severity
	 */
	public int getSeverity(){
		return severity;
	}


	/**
	 * �I������Ă��邩�ǂ�����Ԃ��܂��B
	 *
	 * @return		true - �I������Ă���  false - �I������Ă��Ȃ�
	 */
	public boolean isSelected(){
		return select;
	}

	/**
	 * �I�����ǂ�����ݒ肵�܂��B
	 *
	 * @param select		�I��
	 */
	public void select(boolean select){
		this.select = select;
	}
}
