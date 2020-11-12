package testCases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import GUIBase.Base;
import GUIUtils.Data_Supplier;
import GUIUtils.Misc;
import MercuryTours.Pages.HomePage;
import MercuryTours.Pages.RegistrationPage;

public class UsrRegistration extends Base {

	@Test(dataProvider="Data",dataProviderClass = Data_Supplier.class)
	public void RegisterUser(Map<Object,Object> map) throws InterruptedException, IOException
	{
	
		ThreadLocal <ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
		reportMessage=report.createTest("User Registration Started");
		extentTest.set(reportMessage);
		
		ExtentTest homeNode=extentTest.get().createNode("Home Page");
		ExtentTest rgNode=extentTest.get().createNode("Registration Page");
		
		HomePage HP=new HomePage(driver);
		RegistrationPage RP=new RegistrationPage(driver);
		String Fname=(String) map.get("FirstName");
		String Lname=(String) map.get("LastName");
		String Phone=(String) map.get("Phone");
		String Email=(String) map.get("Email");
		
		HP.getRegisterLink().click();
		homeNode.log(Status.INFO, "Registration Link is clicked");
		
		RP.getFirstName().sendKeys(Fname);
		rgNode.log(Status.INFO, "First Name is entered as "+Fname);
		RP.getLastName().sendKeys(Lname);
		rgNode.log(Status.INFO, "Last Name is entered as "+Lname);
		RP.getPhone().sendKeys(Phone);
		RP.getEmail().sendKeys(Email);
		rgNode.info("Registration Page", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
	}
	
	
	
}
