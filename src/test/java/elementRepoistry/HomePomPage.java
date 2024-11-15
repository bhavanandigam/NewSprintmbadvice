package elementRepoistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilPackage.DriverFactory;
import com.utilityClasses.WebDriverUtility;

public class HomePomPage {

	WebDriver driver;

	public HomePomPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	WebDriverUtility utility = new WebDriverUtility();

	@FindBy(xpath="//a[text()='MB Advice']/span[text()='NEW']")
	private WebElement getMBAdviceLink;

	@FindBy(linkText = "Localities in Bangalore")
	private WebElement localitiesInBanglore;

	@FindBy(xpath = "//div[text()='Localities & Projects']")
	private WebElement LocalitiesandProjects;

	public WebElement getGetMBAdviceLink() {
		return getMBAdviceLink;
	}

	public WebElement getLocalitiesInBanglore() {
		return localitiesInBanglore;
	}

	public WebElement getLocalitiesandProjects() {
		return LocalitiesandProjects;
	}

	public LocalitiesPage clickOnLocalitiesInBanglore(WebDriver driver) {
		utility.javascriptClick(driver, localitiesInBanglore );
		return new LocalitiesPage(driver);

	}

}
