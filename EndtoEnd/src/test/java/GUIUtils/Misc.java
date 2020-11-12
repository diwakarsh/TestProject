package GUIUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
//Author - Diwakar

public class Misc {

	public static String captureScreenShot (WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/Pic_" + getCurrentDateTime() + ".png"; 
		try {
			
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Capture the Screenshots. " + e.getMessage());
		} 
		
		return screenshotPath; 
		 
	}

	public static String getCurrentDateTime()
	{
		//Format formatter = new SimpleDateFormat("YYYYMMdd_HHmmssSSS");
		//Date date = new Date(System.currentTimeMillis());
		//return formatter.format(date);

		SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date currentDate = new Date ();
		return customFormat.format(currentDate);
	}
}

