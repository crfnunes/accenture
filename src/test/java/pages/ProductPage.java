package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends PageObject {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "startdate") 
	private WebElement startdateInput;	
	
	@FindBy(id = "insurancesum") 
	private WebElement insurancesumSelect;
	
	@FindBy(id = "meritrating") 
	private WebElement meritratingSelect;
	
	@FindBy(id = "damageinsurance") 
	private WebElement damageinsuranceSelect;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/form/div/section[3]/div[5]/p/label") 
	private List<WebElement> optProductsOptions;	
	
	@FindBy(id = "courtesycar") 
	private WebElement courtesycarSelect;
	
	@FindBy(id = "nextselectpriceoption") 
	private WebElement nextButton; 

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/nav/ul/li[3]/a/span") 
	private WebElement counterLabel; 	

	public ProductPage setstartdateInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(startdateInput));
		startdateInput.sendKeys(text);
		return this;
	}
	
	public ProductPage setinsurancesumSelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(insurancesumSelect));
		super.SelectItem(insurancesumSelect, index);
		
		return this;
	}
	
	public ProductPage setmeritratingSelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(meritratingSelect));
		super.SelectItem(meritratingSelect, index);
		
		return this;
	}
	
	public ProductPage setdamageinsuranceSelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(damageinsuranceSelect));
		super.SelectItem(damageinsuranceSelect, index);
		
		return this;
	}
	
	public ProductPage sethobbiesOptions(int index) {
		if (!optProductsOptions.isEmpty()) {
			optProductsOptions.get(index).click();
		}
		
		return this;
	} 
	
	public ProductPage setcourtesycarSelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(courtesycarSelect));
		super.SelectItem(courtesycarSelect, index);
		
		return this;
	}
	
	public ProductPage nextButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
		return this;
	} 
	
	public String getCounterLabel() {
		wait.until(ExpectedConditions.visibilityOf(counterLabel));
		return counterLabel.getText();
	}
}