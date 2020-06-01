package tempseleniumtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	// Open Home page
	// Search using search box
	// Verify that search results are displayed

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");

		System.out.println(driver.getTitle());

		WebElement searchBoxEle;

		searchBoxEle = driver.findElement(By.name("search_query"));
		System.out.println("Search box element is found");

		searchBoxEle.sendKeys("Summer Dresses");

		WebElement doSearchEle;

		doSearchEle = driver.findElement(By.name("submit_search"));
		System.out.println("Search button element is found");
		doSearchEle.click();

		WebElement searchResultsCountEle;

		searchResultsCountEle = driver.findElement(By.className("heading-counter"));
		System.out.println("Search results are found");
		System.out.println(searchResultsCountEle.getText());

	}

}
