package com.onbuy.genericutilities;


import java.io.FileInputStream;
import java.util.Properties;
/**
 * used to read the data from external resources like Property file and excel file
 * @author lenovo
 *
 */
public class FileUtilities {
	
		/**
		 * used to get the filepaths from the  /config/filepath.properties  FILE
		 * @param key
		 * @return value
		 * @throws Throwable
		 */
		public String getFilePathFromPropertiesFile(String key) throws Throwable {
			FileInputStream fis = new FileInputStream("./config/filepath.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
		}
		
		/**
		 * used to get the key : value from the any properties based on file Path parameter 
		 * @param filePath
		 * @param key
		 * @return value
		 * @throws Throwable
		 */
		public String getDataFromProperties(String filePath, String key) throws Throwable {
			FileInputStream fis = new FileInputStream(filePath);
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
		}

	}


