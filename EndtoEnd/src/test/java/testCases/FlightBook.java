package testCases;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import GUIBase.Base;
import GUIUtils.Data_Supplier;
import GUIUtils.Misc;
import MercuryTours.Pages.FlightPage;
import MercuryTours.Pages.HomePage;
//Author - Diwakar
public class FlightBook extends Base{

	@Test(dataProvider="Data",dataProviderClass = Data_Supplier.class)
	public void BookFlight(Map<Object,Object> map) throws InterruptedException, IOException
	{
		ThreadLocal <ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
		reportMessage=report.createTest("Flight book Started");
		extentTest.set(reportMessage);
		
		HomePage HP=new HomePage(driver);
		FlightPage FP=new FlightPage(driver);
		String PassengerNo=(String) map.get("PassengerNo");
		String ToCity=(String) map.get("To_City");
		
		ExtentTest homeNode=extentTest.get().createNode("Home Page");
		
		HP.getFlightPage().click();
		homeNode.log(Status.INFO, "Flight Page is clicked");
		//Assert.assertTrue (false);
		
		FP.getRoundTrip().click();
		FP.selectPassengers(PassengerNo);
		ExtentTest FPNode=extentTest.get().createNode("Flight Page");
		FPNode.log(Status.INFO,"No of passenger selected as"+PassengerNo);
		FPNode.info("Filled the Data on Flight Finder Page", MediaEntityBuilder.createScreenCaptureFromPath(Misc.captureScreenShot(driver)).build());
		
		FP.selectToCity(ToCity);
		
	}
	
	
}

