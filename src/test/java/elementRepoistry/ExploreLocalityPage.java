package elementRepoistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityClasses.WebDriverUtility;

public class ExploreLocalityPage  extends LocalitiesPage{
	

	public ExploreLocalityPage(WebDriver driver) {
		super(driver);
	}


	
	@FindBy(xpath="//a[contains(text(),'Price Trends')]")
	private WebElement priceTrends;
	
	
	@FindBy(xpath="//div[@id='resi']/label[1]")
	private WebElement apartments;

	@FindBy(xpath = "//label[contains(text(),'Residential House')]")
	private WebElement house;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div[2]/div[7]/div/div[6]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/label[2]")
	private WebElement floor;
	
	@FindBy(xpath="//input[@value='10000']")
	private WebElement plot;
	

	public WebElement getPriceTrends() {
		return priceTrends;
	}
	
	public WebElement getApartments() {
		return apartments;
	}
	
	
	public WebElement getGetHouse() {
		return house;
	}
	
	public WebElement getFloor() {
		return floor;
	}

	public WebElement getPlot() {
		return plot;
	}
	
	public WebElement getRatesAndTrends() {
		return ratesAndTrends;
	}


	@FindBy(linkText = "Explore Rates & Trends in detail")
	private WebElement ratesAndTrends;
	
	
	public RatesAndTrendsDetailPage clickOnRatesAndTrends(WebDriver driver){
		utility.javascriptClick(driver, ratesAndTrends );
		return new RatesAndTrendsDetailPage(driver);
			
	}
}
