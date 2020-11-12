package MercuryTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
		
	@FindBy (xpath="//input[@name='firstName']")
	private WebElement FistName;
	
	@FindBy (xpath=" //input[@name='lastName']")
	private WebElement LastName;
	
	@FindBy (xpath=" //input[@name='phone']")
	private WebElement Phone;
	
	@FindBy (xpath=" //input[@name='userName']")
	private WebElement Email;
	
	public RegistrationPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getFirstName()
	{
		return FistName;
	}
	
	public WebElement getLastName()
	{
		return LastName;
	}
	
	public WebElement getPhone()
	{
		return Phone;
	}
	public WebElement getEmail()
	{
		return Email;
	}
}

