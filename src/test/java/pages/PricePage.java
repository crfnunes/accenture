package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricePage extends PageObject {

	public PricePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/form/div/section[4]/section/div[1]/table/tfoot/tr/th[2]/label/span") 
	private List<WebElement> priceOptions;
	
	@FindBy(id = "nextsendquote") 
	private WebElement nextButton; 

	@FindBy(xpath = "//html/body/div[1]/div/div[1]/div/div/nav/ul/li[4]/a/span") 
	private WebElement counterLabel; 
	
	public PricePage setpriceOptions(int index) {
		if (!priceOptions.isEmpty()) {
			priceOptions.get(index).click();
		}
		
		return this;
	} 
	
	public PricePage nextButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
		return this;
	} 
	
	public String getCounterLabel() {
		wait.until(ExpectedConditions.visibilityOf(counterLabel));
		return counterLabel.getText();
	}
}
