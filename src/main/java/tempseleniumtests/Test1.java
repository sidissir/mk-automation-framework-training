package tempseleniumtests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	// Open Home page
	// click on 'sign in' link
	// Verify that user is taken to sign in page

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");

		WebElement signInEle;

		signInEle = driver.findElement(By.linkText("Sign in"));
		System.out.println("Sign In Link found");
		
		signInEle.click();
		System.out.println(driver.getTitle());

	}

}
