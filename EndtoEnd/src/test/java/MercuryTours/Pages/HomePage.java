package MercuryTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
		WebDriver driver;
		@FindBy(xpath="//a[contains(text(),'REGISTER')]")
		private WebElement RegisterLink;
		
		@FindBy(xpath="//a[contains(text(),'Flights')]")
		private WebElement FlightLink;
		
		public HomePage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);	
		}
			
		public WebElement getRegisterLink()
		{
			return RegisterLink;
		}
		
		public WebElement getFlightPage()
		{
			return FlightLink;
		}
	}

