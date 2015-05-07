/**
 * 名称取得.
 * 名称情報を取得します。
 * 
 * @version $Revision: 1.1 $ $Date: 2002/10/09 03:03:18 $
 */
package jp.co.netsol.ncc.resource;

import java.io.*;
import java.net.*;
import java.util.*;


public class NameResource {
/* -------------------------------------------------------------------
 プロパティ
------------------------------------------------------------------- */
	/** プロパティ */
	private static Properties prop;
/* -------------------------------------------------------------------
 初期化
------------------------------------------------------------------- */
	/**
	 * ファイル名を指定して初期化する
	 *
	 * @param	filename	ファイル名
	 */
	public static void load(String filename) throws FileNotFoundException, IOException {
		File file = new File(filename);
		load(file);
	}
	/**
	 * ファイルを指定して初期化する
	 *
	 * @param	file	ファイル
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
	 * URLを指定して初期化する
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
 名称取得
------------------------------------------------------------------- */
	/**
	 * ラベル名を取得します。
	 *
	 * @param key		key
	 * @param def		デフォルト名
	 * return			ラベル。keyがnullの場合や、初期化していない場合はデフォルトを返す。
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
	 * ラベル名を取得します。
	 *
	 * @param key		key
	 * @return			ラベル名
	 * @throws			Exception
	 */
	public static String getLabelName(String key) throws Exception {
		if(prop == null) {
			throw new Exception("初期化されていません");
		} else {
			return prop.getProperty(key);
		}
	}

}
