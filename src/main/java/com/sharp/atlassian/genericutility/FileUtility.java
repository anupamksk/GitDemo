package com.sharp.atlassian.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * FileUtility can be used to read the common data from the properties file by supplying key 
 * @author Anupam K.
 *
 */

public class FileUtility {
	
	/**
	 * This method will get the common data from the properties file in string form
	 * @param key
	 * @return String
	 * @throws IOException
	 * @author Anupam K.
	 */
	public String readCommondata(String key ) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trellocommondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);	
		String value = pobj.getProperty(key);
		return value;
	}
	
}
