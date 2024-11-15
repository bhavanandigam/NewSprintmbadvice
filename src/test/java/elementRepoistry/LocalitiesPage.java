package elementRepoistry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityClasses.WebDriverUtility;

public class LocalitiesPage extends HomePomPage {

	public LocalitiesPage(WebDriver driver) {
		super(driver);
	}

	

	@FindBy(linkText = "Explore Locality")
	private WebElement exploreLocalityButton;

	@FindBy(xpath="//div[@id='rankingSort']")
	private WebElement rank;

	@FindBy(xpath="//div[@id='ratingSort']")
	private WebElement rating;

	@FindBy(linkText = "Rajajinagar, Bangalore")
	private WebElement rankSorting;

	@FindBy(linkText = "Chinnapa Garden, Bangalore") 
	private WebElement ratingSorting;
	
	public WebElement getRankSorting() {
		return rankSorting;
	}

	public WebElement getRatingSorting() {
		return ratingSorting;
	}

	@FindBy(linkText = "Read More")
	private WebElement readmore;

	@FindBy(xpath = "//a[text()='Read Less']")
	private WebElement readless;

	@FindBy(xpath = "//a[@href='https://www.magicbricks.com/new-projects-Whitefield-in-Bangalore' and @class='loc-card__all-project' and contains(text(), 'See all Projects')]")
	private WebElement seeAllProjects;

	public WebElement getExploreLocalityButton() {
		return exploreLocalityButton;
	}

	public WebElement getRank() {
		return rank;
	}
	

	public WebElement getRating() {
		return rating;
	}
	

	public WebElement getReadmore() {
		return readmore;
	}
	
	
	public WebElement getReadless() {
		return readless;
	}
	
	
	public WebElement getSeeAllProjects() {
		return seeAllProjects;
	}
	
	public ExploreLocalityPage clickOnExplorLocality(WebDriver driver){
		utility.javascriptClick(driver, exploreLocalityButton);
		return new ExploreLocalityPage(driver);
			
	}
	
	public SeeAllProjectsPage clickOnSeeAllProjects(WebDriver driver) {
		utility.javascriptClick(driver, seeAllProjects);
		return new SeeAllProjectsPage(driver);
		
	}


}
