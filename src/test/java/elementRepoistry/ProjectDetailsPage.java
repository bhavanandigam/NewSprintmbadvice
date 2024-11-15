package elementRepoistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityClasses.WebDriverUtility;

public class ProjectDetailsPage  extends SeeAllProjectsPage{
	
	public ProjectDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class='pdp__amenspecfic']/span[text()='View Amenities (']")
	private WebElement viewAmenities;

	@FindBy(xpath="//div[@class='slidepopup allAmenties open-state']/div/div[@class='popup__header__back']")
	private WebElement backAmenities;

	@FindBy(xpath="//div[@class='pdp__amenspecfic']/span[text()='View Specifications']")
	private WebElement viewSpecifications;
	
	public WebElement getViewAmenities() {
		return viewAmenities;
	}
	

	public WebElement getBackAmenities() {
		return backAmenities;
	}
	
	public WebElement getViewSpecifications() {
		return viewSpecifications;
	}
	
}
