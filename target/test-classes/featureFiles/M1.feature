Feature: User is performing actions on mbadvieclink

Background:
		Given the browser is launched and URL is navigated
#		And user is logged in
		And the user hovers on the MB Advice option
    And the user should be able to see sub-options in the MB Advice
    When the user clicks on localities in bangalore

Scenario:
				And the user should be able to click on ranking to sort localities
				Then the localities sorted by ranking are displayed
 
    		
Scenario:
   			And the user should be able to click on rating to sort localities
				Then the localities sorted by rating are displayed
    	

Scenario Outline:	 Navigate to Price and Trends and choose options for sale

Given the browser is launched and URL is navigated
#And user is logged in
And the user hovers on the MB Advice option
And the user should be able to see sub-options in the MB Advice
When the user clicks on localities in bangalore
And user should be able to click on the explorelocality 
And user is navigate to the locality page
Then click on the Price and Trends option
Then click on the <radiobutton> in the for sale section

Examples:
	
	|	radiobutton	|
	|	1						|
	|	2						|
	|	3						|
	|	4						| 
	
					
Scenario: View Read More data
Given the browser is launched and URL is navigated
#And user is logged in
And the user hovers on the MB Advice option
And the user should be able to see sub-options in the MB Advice
When the user clicks on localities in bangalore
Then clicks on the read more option and sees the read more data


Scenario: Navigate to Projects and view details
Given the browser is launched and URL is navigated
#And user is logged in
And the user hovers on the MB Advice option
And the user should be able to see sub-options in the MB Advice
When the user clicks on localities in bangalore
And the user clicks on the see all projects button
And the user clicks on a project
And clicks on the Amenities link and returns to the project details page
Then clicks on Specifications

Scenario: Navigate to Explore Rates and Trends in detail
Given the browser is launched and URL is navigated
#And user is logged in
And the user hovers on the MB Advice option
And the user should be able to see sub-options in the MB Advice
When the user clicks on localities in bangalore
And the user clicks on explore locality button
And the user clicks on explore rates and trends in detail
					