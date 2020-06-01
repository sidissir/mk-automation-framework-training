package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("I am on Home Page")
	public void i_am_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");
		System.out.println(driver.getTitle());
	}

	@When("I click on Sign In Link")
	public void i_click_on_Sign_In_Link() {
		WebElement signInEle;

		signInEle = driver.findElement(By.linkText("Sign in"));
		System.out.println("Sign In Link found");

		signInEle.click();
	}

	@Then("I should be taken to Log In page")
	public void i_should_be_taken_to_Log_In_page() {
		String expectedTitle = "Login - My Store";
		String actualTitle = driver.getTitle();
		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "Expected and Actual titles are not matching.");
		driver.quit();
	}

	@When("I enter keyword {string} and click search button")
	public void i_enter_keyword_and_click_search_button(String searchKeyword) {
		WebElement searchBoxEle;

		searchBoxEle = driver.findElement(By.name("search_query"));
		System.out.println("Search box element is found");

		searchBoxEle.sendKeys(searchKeyword);

		WebElement doSearchEle;

		doSearchEle = driver.findElement(By.name("submit_search"));
		System.out.println("Search button element is found");
		doSearchEle.click();
	}

	@Then("I should be shown relevant results")
	public void i_should_be_shown_relevant_results() {
		WebElement searchResultsCountEle;

		searchResultsCountEle = driver.findElement(By.className("heading-counter"));
		String actualResultsStr = searchResultsCountEle.getText();
		String expectedTesultsSubStr = "results have been found";
		boolean actualBooleanValue = actualResultsStr.contains(expectedTesultsSubStr);
		System.out.println("Actual Results Str" + actualResultsStr);
		System.out.println("Expected Results Sub Str" + expectedTesultsSubStr);
		Assert.assertTrue(actualBooleanValue,"Results are not found");
		driver.quit();
	}

}
