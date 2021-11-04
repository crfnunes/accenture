package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsurantPage extends PageObject {

	public InsurantPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "firstname") 
	private WebElement firstnameInput;
	
	@FindBy(id = "lastname") 
	private WebElement lastnameInput;
	
	@FindBy(id = "birthdate") 
	private WebElement birthdateInput;

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[4]/p/label") 
	private List<WebElement> genderOptions;	
		
	@FindBy(id = "country") 
	private WebElement countrySelect;
	
	@FindBy(id = "zipcode") 
	private WebElement zipcodeInput;
	
	@FindBy(id = "occupation") 
	private WebElement occupationSelect; 

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/form/div/section[2]/div[10]/p/label") 
	private List<WebElement> hobbiesOptions;
	
	@FindBy(id = "nextenterproductdata") 
	private WebElement nextButton; 

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/nav/ul/li[2]/a/span") 
	private WebElement counterLabel; 	

	public InsurantPage setfirstnameInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(firstnameInput));
		firstnameInput.sendKeys(text);
		return this;
	}
	
	public InsurantPage setlastnameInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(lastnameInput));
		lastnameInput.sendKeys(text);
		return this;
	} 
	
	public InsurantPage setbirthdateInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(birthdateInput));
		birthdateInput.sendKeys(text);
		return this;
	} 
	
	public InsurantPage setgenderOptions(int index) {
		if (!genderOptions.isEmpty()) {
			genderOptions.get(index).click();
		}
		
		return this;
	} 
	
	public InsurantPage setcountrySelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(countrySelect));
		super.SelectItem(countrySelect, index);
		
		return this;
	}

	public InsurantPage setzipcodeInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(zipcodeInput));
		zipcodeInput.sendKeys(text);
		return this;
	}
	
	public InsurantPage setoccupationSelect(int index) {
		wait.until(ExpectedConditions.visibilityOf(occupationSelect));
		super.SelectItem(occupationSelect, index);
		
		return this;
	}
	
	public InsurantPage sethobbiesOptions(int index) {
		if (!hobbiesOptions.isEmpty()) {
			hobbiesOptions.get(index).click();
		}
		
		return this;
	} 
	
	public InsurantPage nextButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
		return this;
	} 
	
	public String getCounterLabel() {
		wait.until(ExpectedConditions.visibilityOf(counterLabel));
		return counterLabel.getText();
	}

}
