package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehiclePage extends PageObject {

	public VehiclePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "make") 
	private WebElement makeSelect;

	@FindBy(id = "model") 
	private WebElement modelSelect;

	@FindBy(id = "cylindercapacity") 
	private WebElement cylindercapacityInput;

	@FindBy(id = "engineperformance") 
	private WebElement engineperformanceInput;

	@FindBy(id = "dateofmanufacture") 
	private WebElement dateofmanufactureInput;	

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/form/div/section[1]/div[7]/p/label") 
	private List<WebElement> righthanddriveOptions;	

	@FindBy(id = "numberofseats") 
	private WebElement numberofseatsSelect;

	@FindBy(id = "numberofseatsmotorcycle") 
	private WebElement numberofseatsmotorcycleSelect;

	@FindBy(id = "fuel") 
	private WebElement fuelSelect;
	
	@FindBy(id = "payload") 
	private WebElement payloadInput;
	
	@FindBy(id = "totalweight") 
	private WebElement totalweightInput;
	
	@FindBy(id = "listprice") 
	private WebElement listpriceInput; 
	
	@FindBy(id = "licenseplatenumber") 
	private WebElement licenseplatenumberInput; 

	@FindBy(id = "annualmileage") 
	private WebElement annualmileageInput; 
	
	@FindBy(id = "nextenterinsurantdata") 
	private WebElement nextButton; 

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/nav/ul/li[1]/a/span") 
	private WebElement counterLabel; 	
	
	public VehiclePage setMake(int index) {
		wait.until(ExpectedConditions.visibilityOf(makeSelect));
		super.SelectItem(makeSelect, index);
		
		return this;
	}
	
	public VehiclePage setModel(int index) {
		wait.until(ExpectedConditions.visibilityOf(modelSelect));
		super.SelectItem(modelSelect, index);
		
		return this;
	}
	
	public VehiclePage setCylindercapacityInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(cylindercapacityInput));
		cylindercapacityInput.sendKeys(text);
		return this;
	}
	
	public VehiclePage setEngineperformanceInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(engineperformanceInput));
		engineperformanceInput.sendKeys(text);
		return this;
	}
	
	public VehiclePage setDateofmanufactureInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(dateofmanufactureInput));
		dateofmanufactureInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage setRighthanddriveRadio(int index) {
		if (!righthanddriveOptions.isEmpty()) {
			righthanddriveOptions.get(index).click();
		}
		
		return this;
	} 
	
	public VehiclePage setNumberOfSeats(int index) {
		wait.until(ExpectedConditions.visibilityOf(numberofseatsSelect));
		super.SelectItem(numberofseatsSelect, index);
		
		return this;
	}
	
	public VehiclePage setNumberofseatsmotorcycle(int index) {
		wait.until(ExpectedConditions.visibilityOf(numberofseatsmotorcycleSelect));
		super.SelectItem(numberofseatsmotorcycleSelect, index);
		
		return this;
	}
	
	public VehiclePage setFuel(int index) {
		wait.until(ExpectedConditions.visibilityOf(fuelSelect));
		super.SelectItem(fuelSelect, index);
		
		return this;
	}
	
	public VehiclePage setPayloadInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(payloadInput));
		payloadInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage settotalweightInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(totalweightInput));
		totalweightInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage setlistpriceInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(listpriceInput));
		listpriceInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage setlicenseplatenumberInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(licenseplatenumberInput));
		licenseplatenumberInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage setannualmileageInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(annualmileageInput));
		annualmileageInput.sendKeys(text);
		return this;
	} 
	
	public VehiclePage nextButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(nextButton));
		nextButton.click();
		return this;
	} 
	
	public String getCounterLabel() {
		wait.until(ExpectedConditions.visibilityOf(counterLabel));
		return counterLabel.getText();
	}
}
