package GUIUtils;
//Author - Diwakar
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class configDataProvider {
	
	public static WebDriver driver;
	private static Properties prop=new Properties();
	private static FileInputStream fis;

	
	public configDataProvider() throws IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//environment.properties");
		prop.load(fis);
	}
	
	public static String getBrowserName()
	{
		return prop.getProperty("browser");	
	}
	public static String getURL()
	{
		return prop.getProperty("AppURL");	
	}
}


