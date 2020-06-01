package tempseleniumtests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Test3 {
	
	// Open Home page
	// Mouse over on Dress main menu
	// Click on Summer Dresses Sub Menu
	// Add first item to cart
	// Verify that cart has 1 item

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/conf/browserdrivers/chrome_83/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/");

		System.out.println(driver.getTitle());
		WebElement dressesMenuElement = driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(dressesMenuElement).build().perform();

		WebElement summerDressesElement = driver
				.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a"));
		summerDressesElement.click();

		List<WebElement> allSummerDresseResultElements = driver.findElements(By.className("product-container"));
		System.out.println("Total Summer dresses : " + allSummerDresseResultElements.size());

		WebElement firstSummerDressElement = allSummerDresseResultElements.get(0);
		
		actions.moveToElement(firstSummerDressElement).build().perform();
		
		WebElement addToCartButtonElement = firstSummerDressElement.findElement(By.cssSelector("a[title*='Add to cart']"));
		addToCartButtonElement.click();
		
		
		WebElement continueShoppingButtonElement = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
		continueShoppingButtonElement.click();
		
		
		WebElement viewCartButtonElement = driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a"));
		//WebElement viewCartButtonElement = driver.findElement(By.className("ajax_cart_quantity unvisible"));

		System.out.println(viewCartButtonElement.getText());
	}

}
