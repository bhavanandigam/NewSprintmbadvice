package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;
import com.utilityClasses.WebDriverUtility;

import elementRepoistry.ExploreLocalityPage;
import elementRepoistry.HomePomPage;
import elementRepoistry.LocalitiesPage;
import elementRepoistry.ProjectDetailsPage;
import elementRepoistry.RatesAndTrendsDetailPage;
import elementRepoistry.SeeAllProjectsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MbAdvice {
	WebDriver driver = DriverFactory.getDriver();
	HomePomPage homePage = new HomePomPage(driver) ;
	LocalitiesPage localitiespage ;
	ExploreLocalityPage explorelocalitypage ;
	SeeAllProjectsPage seeallprojectpage ;
	ProjectDetailsPage projectdetails ;
	RatesAndTrendsDetailPage ratesandtrendspage ;
	WebDriverUtility webDriver = new WebDriverUtility();
	FileUtility fileutility = new FileUtility();
	
	@Given("the browser is launched and URL is navigated")
	public void the_browser_is_launched_and_url_is_navigated() throws Exception {
		Assert.assertEquals(driver.getCurrentUrl(), fileutility.getDataFromPropertiesFiles("url"));
		Reporter.log("User navigated to magicbricks url");
	}

//	@Given("user is logged in")
//	public void user_is_logged_in() {
//	    
//	}

	@Given("the user hovers on the MB Advice option")
	public void the_user_hovers_on_the_mb_advice_option() {
//		webDriver.waitForElementPresent(driver, homePage.getGetMBAdviceLink());
		webDriver.mouseHover(driver, homePage.getGetMBAdviceLink());
		Reporter.log("User is hovering on mbadvicelink",true);
	}

	@Given("the user should be able to see sub-options in the MB Advice")
	public void the_user_should_be_able_to_see_sub_options_in_the_mb_advice() {
//		Assert.assertTrue(homePage.getLocalitiesandProjects().isDisplayed());
		Reporter.log("User is able to see the sub-options",true);
	}

	@When("the user clicks on localities in bangalore")
	public void the_user_clicks_on_localities_in_bangalore() throws Exception {
		Thread.sleep(3000);
		localitiespage = homePage.clickOnLocalitiesInBanglore(driver);
		webDriver.switchToTabOnTitle(driver, fileutility.getDataFromPropertiesFiles("TopLocalitiestab"));
		Reporter.log("User is clicking on localities in Bangalore",true);
	}

	@When("the user should be able to click on ranking to sort localities")
	public void the_user_should_be_able_to_click_on_ranking_to_sort_localities() {
		webDriver.actionClick(driver, localitiespage.getRank());
		Reporter.log("User clicked on ranking in filters",true);
	}

	@Then("the localities sorted by ranking are displayed")
	public void the_localities_sorted_by_ranking_are_displayed() {
		Assert.assertTrue(localitiespage.getRank().isDisplayed());
		Reporter.log("User is able to see all the localities after applying ranking filter",true);
	}

	@When("the user should be able to click on rating to sort localities")
	public void the_user_should_be_able_to_click_on_rating_to_sort_localities() {
		
		webDriver.actionClick(driver, localitiespage.getRating());
		Reporter.log("User clicked on rating in filters",true);

	}

	@Then("the localities sorted by rating are displayed")
	public void the_localities_sorted_by_rating_are_displayed() {
		Assert.assertTrue(localitiespage.getRating().isDisplayed());
		Reporter.log("User is able to see all the localities after applying rating filter",true);
	}
	
		//Scenairo outline
	
	@When("user should be able to click on the explorelocality")
	public void user_should_be_able_to_click_on_the_explorelocality() throws Exception {
				
		webDriver.switchToTabOnTitle(driver, fileutility.getDataFromPropertiesFiles("TopLocalitiestab"));
		webDriver.scrollToElement(driver, localitiespage.getExploreLocalityButton());	
		Thread.sleep(3000);
		explorelocalitypage =localitiespage.clickOnExplorLocality(driver);
	    Reporter.log("User clicked on explore locality button");
	  
	}

	@When("user is navigate to the locality page")
	public void user_is_navigate_to_the_locality_page() {
//		Assert.assertTrue(explorelocalitypage.getPriceTrends().isDisplayed());
		Reporter.log("User is able to see the locality page");
	}

	@Then("click on the Price and Trends option")
	public void click_on_the_price_and_trends_option() {
		webDriver.actionClick(driver, explorelocalitypage.getPriceTrends());
		Reporter.log("User is clicking on price trends tab in explorelocality page ",true);
	}

	@Then("click on the {int} in the for sale section")
	public void click_on_the_in_the_for_sale_section(Integer int1) throws Exception {
		String option = fileutility.getDataFromExcel("Price Trends for sale", int1-1, 0);
		switch (option) {

		case "apartment":
			webDriver.actionClick(driver, explorelocalitypage.getApartments());
			Thread.sleep(2000);
			Reporter.log("Clicked on apartment");

			break;
			
		case "floor":
			webDriver.actionClick(driver, explorelocalitypage.getFloor());
			Thread.sleep(2000);
			Reporter.log("Clicked on floor");
			break;
			
		case "house":
			webDriver.actionClick(driver, explorelocalitypage.getGetHouse());
			Thread.sleep(2000);
			Reporter.log("Clicked on house");

			break;
		case "plot":
			webDriver.actionClick(driver, explorelocalitypage.getPlot());
			Thread.sleep(2000);
			Reporter.log("Clicked on plot");
			break;

		}
	}
	
	@Then("clicks on the read more option and sees the read more data")
	public void clicks_on_the_read_more_option_and_sees_the_read_more_data() {
		webDriver.actionClick(driver, localitiespage.getReadmore());
		Reporter.log("User is able to click on readmore link ");
	}

	@When("the user clicks on the see all projects button")
	public void the_user_clicks_on_the_see_all_projects_button() {
		seeallprojectpage = localitiespage.clickOnSeeAllProjects(driver);
		Reporter.log("User is able to click on see all projects link ");
	}

	@When("the user clicks on a project")
	public void the_user_clicks_on_a_project() {
		projectdetails = seeallprojectpage.clickOnPhaseI(driver);
		Reporter.log("User is clicking on a project called phase I");
	}

	@When("clicks on the Amenities link and returns to the project details page")
	public void clicks_on_the_amenities_link_and_returns_to_the_project_details_page() {
		webDriver.actionClick(driver, projectdetails.getViewAmenities());
		Reporter.log("User clicked on amenties");
		webDriver.actionClick(driver, projectdetails.getBackAmenities());
		Reporter.log("user clicked on back button to back from amineties");
	}

	@Then("clicks on Specifications")
	public void clicks_on_specifications() {
		webDriver.actionClick(driver, projectdetails.getViewSpecifications());
		Reporter.log("user clicked on view specification");
	}

	@When("the user clicks on explore locality button")
	public void the_user_clicks_on_explore_locality_button() {
		explorelocalitypage = localitiespage.clickOnExplorLocality(driver);
	}

	@When("the user clicks on explore rates and trends in detail")
	public void the_user_clicks_on_explore_rates_and_trends_in_detail() {
		webDriver.scrollToElement(driver, explorelocalitypage.getRatesAndTrends());
		ratesandtrendspage = explorelocalitypage.clickOnRatesAndTrends(driver);
		Reporter.log("User is clicking on explore rates and trends ");
	}
	
}
