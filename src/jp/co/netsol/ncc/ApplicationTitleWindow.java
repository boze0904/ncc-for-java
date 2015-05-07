/**
 * �N�����̃g�b�v��ʂł�<p>
 *
 *
 */
package jp.co.netsol.ncc;

import jp.co.netsol.ncc.components.*;

import NxCorba.*;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.io.*;

public class ApplicationTitleWindow extends JFrame{

	public static void main(String[] args){
		new ApplicationTitleWindow();
	}


	/** ��ʂ̕� */
	private int width;
	/** ��ʂ̍��� */
	private int height;


	/**
	 * �R���X�g���N�^
	 *
	 *
	 */
	public ApplicationTitleWindow(){
		super();
		setUndecorated(true);

		setSize(640, 500);
		centerScreen();
		setVisible(true);
		setResizable(false);

		// NetExpert�ʐM����
		initNetExpert();
	}

	/**
	 * �O���t�B�b�N�X��`�悵�܂��B
	 *
	 * @param g		Graphics
	 */
	public void paint(Graphics g){
		// Graphics2D �擾
		Graphics2D g2 = (Graphics2D)g;

		// ��ʂ̕��A�������擾
		width = getWidth();
		height = getHeight();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		g2.setColor(Color.RED);

		/* ---------- NetExpert ---------- */
		Shape sha = createShape(g2, "NetExpert", 0);

		g2.draw(sha);

		/* ---------- Command ---------- */
		sha = createShape(g2, "Command", 100);
		g2.draw(sha);

		/* ---------- Center ---------- */
		sha = createShape(g2, "Center", 200);
		g2.draw(sha);

		/* ---------- for Java ---------- */
		sha = createJavaShape(g2, "for Java", 300);
		g2.setColor(Color.BLACK);
		g2.draw(sha);
		g2.fill(sha);

	}

	/**
	 * �������쐬���ĕԂ��܂��B
	 *
	 * @param g2		Graphics2D
	 * @param s			������
	 * @param _plus		�z�u����
	 * @return			Shape
	 */
	private Shape createShape(Graphics2D g2, String s, int _plus){

		// �t�H���g����
		FontRenderContext frc = g2.getFontRenderContext();
		Font font1 = new Font("Serif", Font.ITALIC, width/6);

		AttributedString as = new AttributedString(s);
		as.addAttribute(TextAttribute.FONT, font1);

		AttributedCharacterIterator aci = as.getIterator();

		TextLayout layout = new TextLayout(aci, frc);

		float sw = (float)layout.getBounds().getWidth();
		float sh = (float)layout.getBounds().getHeight();

		return layout.getOutline(AffineTransform.getTranslateInstance(width/2 - sw/2, height/4 + sh/2 + _plus));
	}

	/**
	 * �������쐬���ĕԂ��܂��B
	 *
	 * @param g2		Graphics2D
	 * @param s			������
	 * @param _plus		�z�u����
	 * @return			Shape
	 */
	private Shape createJavaShape(Graphics2D g2, String s, int _plus){

		// �t�H���g����
		FontRenderContext frc = g2.getFontRenderContext();
		Font font1 = new Font("Serif", Font.ITALIC, width/10);

		AttributedString as = new AttributedString(s);
		as.addAttribute(TextAttribute.FONT, font1);

		AttributedCharacterIterator aci = as.getIterator();

		TextLayout layout = new TextLayout(aci, frc);

		float sw = (float)layout.getBounds().getWidth();
		float sh = (float)layout.getBounds().getHeight();

		return layout.getOutline(AffineTransform.getTranslateInstance(width/2 + 150 - sw/2, height/4 + sh/2 + _plus));
	}

/* -------------------------------------------------------------------
 ��ʂ̒�����
------------------------------------------------------------------- */
	/**
	 * ��ʂ̒�����
	 */
	private void centerScreen() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(d.getWidth() - this.getWidth())/2,
					(int)(d.getHeight() - this.getHeight())/2);
	}


	/**
	 * NetExpert�ʐM�̏��������s���܂�
	 *
	 */
	protected void initNetExpert(){

		NxCAAccessor access = null;
		File file = new File("NxCorba.properties");
		try {
			access = new NxCAAccessor(file);
		} catch ( Exception e ) {
			e.printStackTrace();
			setVisible(false);
			MessageDialog.ExceptionDialog("NetExpert�Ƃ̒ʐM�Ɏ��s���܂���");
			System.exit(-1);
		}

		// Login��ʐ���
		Login login = new Login(access);

		try{
			Thread.sleep(1000);
		}catch(Exception e){}
		// �{��ʕ���
		setVisible(false);
		dispose();
		// Login��ʕ\��
		login.setVisible(true);
	}

}
