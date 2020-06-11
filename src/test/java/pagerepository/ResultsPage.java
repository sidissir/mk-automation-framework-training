package pagerepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

	
	public ResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className = "heading-counter")
	WebElement seearchResultsCountElement;
	
	@FindBy(className = "product-container")
	List<WebElement> allSummerDresseResultElements;
	
	
	
	public String getSearchResultsText() {
		String resultsText = seearchResultsCountElement.getText();
		System.out.println("Results String : " + resultsText);
		return resultsText;
	}
	
	
}
