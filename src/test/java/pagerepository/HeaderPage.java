package pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

	// This page contains locators for all the elements present in header page
	// and also the actions that we perform on those elements
	Actions actions;

	public HeaderPage(WebDriver driver) {
		// Initialize HeaderPage with driver instance
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(linkText = "Sign in")
	WebElement signInElement;
	// WebElement signInElement = driver.findElement(By.linkText("Sign In"))

	@FindBy(name = "search_query")
	WebElement searchBoxElement;
	// WebElement searchBoxElement = driver.findElement(By.name("search_query"));

	@FindBy(name = "submit_search")
	WebElement searchButtonElement;
	// WebElement searchButtonElement =
	// driver.findElement(By.name("submit_search"));

	WebElement cartElement;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
	WebElement mainCategoryWomenElement;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[2]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]\"")
	WebElement mainCategoryDressesElement;

	// WebElement mainCategoryTshirtsElement;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")
	WebElement subCategoryCasualElement;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[2]/a")
	WebElement subCategoryEveningElement;

	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a")
	WebElement subCategorySummerElement;

	public void clickSignInLink() {
		System.out.println("Clicking SigIn Link");
		signInElement.click();
	}

	public void enterSearchTermInSearchBox(String searchKeyword) {
		System.out.println("Enetering keyword into search box");
		//logger.info("Enetering keyword into search box")
		searchBoxElement.sendKeys(searchKeyword);
	}

	public void submitSearch() {
		System.out.println("Clicking search button");
		searchButtonElement.click();
	}

	public void hoverOnMainCategory(String topMenuCategoryName) {
		WebElement topMenuCategoryElement = null;
		if (topMenuCategoryName.equalsIgnoreCase("Dresses")) {
			topMenuCategoryElement = mainCategoryDressesElement;
		} else if (topMenuCategoryName.equalsIgnoreCase("Women")) {
			topMenuCategoryElement = mainCategoryWomenElement;
		}
		actions.moveToElement(topMenuCategoryElement).build().perform();
	}

}
