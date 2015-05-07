/**
 * ���̎擾.
 * ���̏����擾���܂��B
 * 
 * @version $Revision: 1.1 $ $Date: 2002/10/09 03:03:18 $
 */
package jp.co.netsol.ncc.resource;

import java.io.*;
import java.net.*;
import java.util.*;


public class NameResource {
/* -------------------------------------------------------------------
 �v���p�e�B
------------------------------------------------------------------- */
	/** �v���p�e�B */
	private static Properties prop;
/* -------------------------------------------------------------------
 ������
------------------------------------------------------------------- */
	/**
	 * �t�@�C�������w�肵�ď���������
	 *
	 * @param	filename	�t�@�C����
	 */
	public static void load(String filename) throws FileNotFoundException, IOException {
		File file = new File(filename);
		load(file);
	}
	/**
	 * �t�@�C�����w�肵�ď���������
	 *
	 * @param	file	�t�@�C��
	 */
	public static void load(File file) throws FileNotFoundException, IOException {
		try {
			load(file.toURL());
		} catch(MalformedURLException e) {
			e.printStackTrace();
			throw new FileNotFoundException(e.getMessage());
		}
	}
	/**
	 * URL���w�肵�ď���������
	 *
	 * @param	url	URL
	 */
	public static void load(URL url) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		prop = new Properties();
		prop.load(bis);
		bis.close();
	}
	
/* -------------------------------------------------------------------
 ���̎擾
------------------------------------------------------------------- */
	/**
	 * ���x�������擾���܂��B
	 *
	 * @param key		key
	 * @param def		�f�t�H���g��
	 * return			���x���Bkey��null�̏ꍇ��A���������Ă��Ȃ��ꍇ�̓f�t�H���g��Ԃ��B
	 */
	public static String getLabelName(String key, String def) {
		if(key == null) {
			return def;
		}
		try {
			String label = getLabelName(key);
			if(label.length() == 0) {
				label = def;
			}
			return label;
		} catch(Exception e) {
			return def;
		}
	}
	/**
	 * ���x�������擾���܂��B
	 *
	 * @param key		key
	 * @return			���x����
	 * @throws			Exception
	 */
	public static String getLabelName(String key) throws Exception {
		if(prop == null) {
			throw new Exception("����������Ă��܂���");
		} else {
			return prop.getProperty(key);
		}
	}

}
