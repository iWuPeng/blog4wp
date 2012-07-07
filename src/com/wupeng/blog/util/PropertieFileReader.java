package com.wupeng.blog.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author 吴鹏
 * 读取配置文件信息
 */
public class PropertieFileReader 
{
	
	private static Properties config = new Properties(); //单例

	// 类加载时通过类加载器读取类路径下的配置文件
	static {
		try 
		{
			InputStream in = PropertieFileReader.class.getClassLoader()
							.getResourceAsStream("config.properties");// 通过类加载器获得类路径下该属性文件的一个输入流
			config.load(in);// 从输入流中读取属性列表
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getString(String key) {
		return config.getProperty(key);
	}
	public static String getLogConfigString(String key) {
		try {
			InputStream in =PropertieFileReader.class.getClassLoader()
			.getResourceAsStream("AccessStatConfig.properties");
			config.load(in);// 从输入流中读取属性列表
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config.getProperty(key);
	}
	
	public static String getString(String key, String defaultValue) {
		return config.getProperty(key, defaultValue);
	}

	public static Properties getInstance() {
		return config;
	}

	public static void main(String[] args) {
		System.out.println(PropertieFileReader.getString("uploadDataPort"));
	}
}
