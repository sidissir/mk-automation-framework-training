package stepdefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagerepository.HeaderPage;
import pagerepository.ResultsPage;
import utils.PropertiesUtil;

public class Steps {
	WebDriver driver;
	Actions actions;
	PropertiesUtil propertiesUtil;
	HeaderPage headerPage;
	ResultsPage resultsPage;
	
	Logger logger = Logger.getLogger(Steps.class.getName());

	@Before
	public void setUp() {

		//System.out.println("===I am before hook. I get executed before every scenario==============");
		logger.info("===I am before hook. I get executed before every scenario==============");

		propertiesUtil = new PropertiesUtil();
		// calling readPropertiesFromFile from PropertiesUtil class which loads all
		// properties from properties file into System properties
		propertiesUtil.readPropertiesFromFile();
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");
		 */
		System.setProperty("webdriver.chrome.driver", System.getProperty("chrome_driver"));

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		headerPage = new HeaderPage(driver);
		resultsPage = new ResultsPage(driver);
	}

	@Given("I am on Home Page")
	public void i_am_on_Home_Page() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");
		 * 
		 * driver = new ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 * 
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 */
		// driver.get("http://automationpractice.com/");
		driver.get(System.getProperty("home_page_url"));
		//System.out.println("Page Title Is : " + driver.getTitle());
		logger.info("Page Title Is : " + driver.getTitle());
	}

	/*
	 * @Given("I am on xyz Page") public void i_am_on_xyz_Page() {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");
	 * 
	 * driver = new ChromeDriver();
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * 
	 * driver.get("http://automationpractice.com/xyzpageurl");
	 * System.out.println(driver.getTitle()); }
	 */

	@When("I click on Sign In Link")
	public void i_click_on_Sign_In_Link() {
		//WebElement signInEle;

		/*
		 * signInEle = driver.findElement(By.linkText("Authenticate"));
		 * signInEle.click();
		 */
		
		headerPage.clickSignInLink();

		

	}

	@Then("I should be taken to Log In page")
	public void i_should_be_taken_to_Log_In_page() {
		String expectedTitle = System.getProperty("expected_home_page_title");
		String actualTitle = driver.getTitle();
		//System.out.println("Expected Title : " + expectedTitle);
		logger.info("\"Expected Title : \" + expectedTitle");
		
		//System.out.println("Actual Title : " + actualTitle);
		logger.info("Actual Title : " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Expected and Actual titles are not matching.");
		// driver.quit();
	}

	@When("I enter keyword {string} and click search button")
	public void i_enter_keyword_and_click_search_button(String searchKeyword) {
		/*
		 * WebElement searchBoxEle;
		 * 
		 * searchBoxEle = driver.findElement(By.name("search_query"));
		 * System.out.println("Search box element is found");
		 * 
		 * searchBoxEle.sendKeys(searchKeyword);
		 */
		headerPage.enterSearchTermInSearchBox(searchKeyword);

		/*
		 * WebElement doSearchEle;
		 * 
		 * doSearchEle = driver.findElement(By.name("submit_search"));
		 * System.out.println("Search button element is found"); doSearchEle.click();
		 */
		headerPage.submitSearch();
	}

	@Then("I should be shown relevant results")
	public void i_should_be_shown_relevant_results() {
//		WebElement searchResultsCountEle;
//
//		searchResultsCountEle = driver.findElement(By.className("heading-counter"));
//		String actualResultsStr = searchResultsCountEle.getText();
		
		String actualResultsStr = resultsPage.getSearchResultsText();
		// String expectedTesultsSubStr = "results have been found";
		String expectedTesultsSubStr = System.getProperty("expected_results_str");
		boolean actualBooleanValue = actualResultsStr.contains(expectedTesultsSubStr);
		//System.out.println("Actual Results Str : " + actualResultsStr);
		//System.out.println("Expected Results Sub Str : " + expectedTesultsSubStr);
		logger.info("Actual Results Str : " + actualResultsStr);
		logger.info("Expected Results Sub Str : " + expectedTesultsSubStr);
		Assert.assertTrue(actualBooleanValue, "Results are not found");
		// driver.quit();
	}

	@When("I move to {string} in top category menu")
	public void i_move_to_in_top_category_menu(String topMenuCategoryName) {
		System.out.println("Main Category : " + topMenuCategoryName);
		logger.info("Main Category : " + topMenuCategoryName);

		headerPage.hoverOnMainCategory(topMenuCategoryName);
	}

	@When("I choose {string} in sub menu")
	public void i_choose_in_sub_menu(String subCategoryName) {

		System.out.println("Sub Category Name : " + subCategoryName);

		WebElement subCategoryElement = null;

		if (subCategoryName.equalsIgnoreCase("SUMMER DRESSES")) {
			subCategoryElement = driver
					.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a"));
		} else if (subCategoryName.equalsIgnoreCase("EVENING DRESSES")) {
			subCategoryElement = driver
					.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[2]/a"));
		} else if (subCategoryName.equalsIgnoreCase("CASUAL DRESSES")) {
			subCategoryElement = driver
					.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a"));
		}

		subCategoryElement.click();

	}

	@When("I add first item to the cart")
	public void i_add_first_item_to_the_cart() {
		List<WebElement> allSummerDresseResultElements = driver.findElements(By.className("product-container"));
		System.out.println("Total Summer dresses : " + allSummerDresseResultElements.size());

		WebElement firstSummerDressElement = allSummerDresseResultElements.get(0);

		actions.moveToElement(firstSummerDressElement).build().perform();

		WebElement addToCartButtonElement = firstSummerDressElement
				.findElement(By.cssSelector("a[title*='Add to cart']"));
		addToCartButtonElement.click();

		WebElement continueShoppingButtonElement = driver
				.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
		continueShoppingButtonElement.click();
	}

	@Then("Cart should have added item")
	public void cart_should_have_added_item() {
		WebElement viewCartButtonElement = driver
				.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		// WebElement viewCartButtonElement =
		// driver.findElement(By.className("ajax_cart_quantity unvisible"));

		System.out.println(viewCartButtonElement.getText());
		// String expectedCartSubStringText = "1 Product";
		String expectedCartSubStringText = System.getProperty("expected_cart_sub_string_text");

		String actualCartStringText = viewCartButtonElement.getText();
		Boolean actualResult = actualCartStringText.contains(expectedCartSubStringText);
		Boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, "Cart has incorrect number of elements.");
		// driver.quit();
	}

	@After
	public void tidyUp() {
		//System.out.println("===I am after hook. I get executed after every scenario==============");
		logger.info("===I am after hook. I get executed after every scenario==============");
		driver.quit();
	}

}
