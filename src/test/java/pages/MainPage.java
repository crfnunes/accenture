package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends PageObject {

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@class=\"idealsteps-step-active\"]/a") 
	private WebElement activeTab;
	
	@FindBy(id = "selectedinsurance") 
	private WebElement loadInsurance;
	
	public void Access() {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
	}

	public void Close() {
		driver.quit();
	}
	
	public String getLoadInsurance() {
		wait.until(ExpectedConditions.visibilityOf(loadInsurance));		
		return loadInsurance.getText();
	}
	
	public String getActivePageName() {
		super.Wait(1000);		
		wait.until(ExpectedConditions.visibilityOf(activeTab));	
		return activeTab.getAttribute("name");
	}
}
