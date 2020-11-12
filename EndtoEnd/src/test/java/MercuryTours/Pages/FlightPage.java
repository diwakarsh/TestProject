package MercuryTours.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
// Author - Diwakar
public class FlightPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	private WebElement FlightOpt;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	private WebElement RoundTrip;
	
	@FindBy(xpath="//input[@value='oneway']")
	private WebElement OneWay;
	
	@FindBy(xpath="//select[@name='passCount']")
	private WebElement Passengers;
	
	@FindBy(xpath="//select[@name='fromMonth']")
	private WebElement TripMonth;
	
	@FindBy(xpath="//select[@name='fromDay']")
	private WebElement TripDay;
	
	@FindBy(xpath="//select[@name='toPort']")
	private WebElement ToCity;
	
	public FlightPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public WebElement getFlightOpt()
	{
		return FlightOpt;
	}

	public WebElement getRoundTrip()
	{
		return RoundTrip;
	}
	
	public WebElement getOneWay()
	{
		return OneWay;
	}
	
	public void selectPassengers (String strPassengers)
    {
		Select dropPassengers = new Select(this.Passengers); 
		dropPassengers.selectByValue(strPassengers);
	//	dropPassengers.selectByVisibleText(strPassengers);
    }
	
	public void selectToCity (String ToCity)
    {
		Select to_city = new Select(this.ToCity); 
		to_city.selectByValue(ToCity);
		//to_city.selectByVisibleText(ToCity);
    }

	public WebElement getTripMonth()
	{
		return TripMonth;
	}
	
	public WebElement getTripDay()
	{
		return TripDay;
	}
	
	public WebElement getToCity()
	{
		return ToCity;
	}
}
