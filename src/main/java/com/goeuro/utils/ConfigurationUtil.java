package com.goeuro.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.goeuro.main.GoEuroTestMain;

/**
 * 
 * @author mosman
 *
 */
public class ConfigurationUtil {

	private final static Logger logger = Logger.getLogger(ConfigurationUtil.class);
	private static final Properties wsProps = new Properties();
	private static String LOG_FILE_PATH="log4j.file";	
	private static String LOG_FILE_LEVEL="log4j.file.level";
	private static String LOG_OUT_LEVEL = "log4j.stdout.level";
	private static String LOG4J_PROPERTIES_FILE_NAME="log4j.properties";
	private static String WS_CONFIGURATION_FILE_NAME="wsClientConfiguration.properties";
	
	private ConfigurationUtil() {
		InputStream ins = null;
		try {
			ins = ConfigurationUtil.class.getClassLoader().getResourceAsStream(WS_CONFIGURATION_FILE_NAME);
			wsProps.load(ins);

		} catch (IOException e) {
			logger.error(" Exception while reading wsClientConfiguration", e);
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
				}
			}
		}

	}

	public static ConfigurationUtil getInstance() {
		return new ConfigurationUtil();
	}

	public String getWsProperty(String key) {
		return wsProps.getProperty(key);
	}
	
	public void loadLog4jConfigurations(){
		System.setProperty(LOG_FILE_PATH, ConfigurationUtil.getInstance().getWsProperty(LOG_FILE_PATH));
		System.setProperty(LOG_FILE_LEVEL, ConfigurationUtil.getInstance().getWsProperty(LOG_FILE_LEVEL));
		System.setProperty(LOG_OUT_LEVEL, ConfigurationUtil.getInstance().getWsProperty(LOG_OUT_LEVEL));
		PropertyConfigurator.configure(GoEuroTestMain.class.getClassLoader().getResourceAsStream(LOG4J_PROPERTIES_FILE_NAME));
	}

}