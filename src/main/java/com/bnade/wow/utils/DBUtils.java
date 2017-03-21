package com.bnade.wow.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DBUtils {
	
	private static String configFile = "jdbc.properties";
	private static DataSource dataSource;

	public static DataSource getDataSource() {
		if (dataSource == null) {
			try {
				dataSource = DruidDataSourceFactory.createDataSource(loadPropertyFile(configFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSource;
	}

	private static Properties loadPropertyFile(String fileName) {
		Properties p = null;
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream(fileName);
		try {
			if (is == null) {
				is = new FileInputStream(fileName);
			}
			if (is != null) {
				p = new Properties();
				p.load(is);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: " + fileName);
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + fileName);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return p;
	}
}
