package elementRepoistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityClasses.WebDriverUtility;

public class SeeAllProjectsPage extends LocalitiesPage {
	
	
	public SeeAllProjectsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@href='https://www.magicbricks.com/new-projects-Whitefield-in-Bangalore' and @class='loc-card__all-project' and contains(text(), 'See all Projects')]")
	private WebElement seeAllProjects;
	
	@FindBy(xpath = "//a[text()='Sarang By Sumadhura Phase I']")
	private WebElement phase;
	
	
	public WebElement getSeeAllProjects() {
		return seeAllProjects;
	}

	public WebElement getPhase() {
		return phase;
	}

	public ProjectDetailsPage clickOnPhaseI(WebDriver driver) {
		utility.javascriptClick(driver, phase);
		return new ProjectDetailsPage(driver);
		
	}


}
