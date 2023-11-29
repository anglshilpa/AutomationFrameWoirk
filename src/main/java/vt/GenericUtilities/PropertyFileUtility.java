package vt.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	
	/**
	 * its method which is gonna read data from propertyFile
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
      FileInputStream fin=new FileInputStream(IPathConstant.propertyFilePath);
		Properties properties=new Properties();
		properties.load(fin);
		String value = properties.getProperty(key);
		return value;
	}

	/**
	 * this method will read Url
	 * @throws Throwable
	 */
	public String getBaseUrl() throws Throwable
	{
		 String URL=readDataFromPropertyFile("url");
		 return URL;
	}
	/**
	 * this method will read browser
	 * @throws Throwable
	 */
	public String getBrowser() throws Throwable
	{
		return readDataFromPropertyFile("browser");
		 
	}
	/**
	 * this method will read Username 
	 * @throws Throwable
	 */
	public String getUserName() throws Throwable
	{
		 return  readDataFromPropertyFile("username");
	}
	public String getPassward() throws Throwable
	{
		return readDataFromPropertyFile("passward");
		  
	}
	
	
	/**
	 * this method will read Url,browser,Username n Passward click on Loginbutton
	 * @throws Throwable
	 */
	public void getPerformBasicOperations() throws Throwable
	{
		getBrowser();
		getBaseUrl();
		
		
	}


}
