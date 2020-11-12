package GUIBase;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import GUIUtils.BrowserFactory;
import GUIUtils.Misc;
import GUIUtils.configDataProvider;
//Author - Diwakar
public class Base {

	public  WebDriver driver;
	public static configDataProvider config;
	public static ExtentReports report=new ExtentReports(); 
	public static ExtentHtmlReporter extent;
	public static ExtentTest reportMessage;
	
	@BeforeSuite
	public void setupSuite() throws IOException
	{
			config=new configDataProvider();
			extent = new  ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/Mercury_"+ Misc.getCurrentDateTime() +".html"));
			report.attachReporter(extent);

	}		
	
	@AfterSuite
	public void publishReport()
	{
		report.flush();
	}
	
	@BeforeMethod
	public  void initilizeDriver()  throws IOException
	{
		
		driver=BrowserFactory.StartApp(driver, configDataProvider.getBrowserName(),configDataProvider.getURL());
	
	}
	@AfterMethod
	public void quitDriver(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			try {
				reportMessage.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't save the screenshot " + e.getMessage());
			} 
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			try {
				reportMessage.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't save the screenshot " + e.getMessage());
			} 
		}

		
		driver.quit();
	
	}

	
	
	
}