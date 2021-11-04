package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendQuotePage extends PageObject {

	public SendQuotePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email") 
	private WebElement emailInput;
	
	@FindBy(id = "username") 
	private WebElement usernameInput;
	
	@FindBy(id = "password") 
	private WebElement passwordInput;
	
	@FindBy(id = "confirmpassword") 
	private WebElement confirmpasswordInput;	
	
	@FindBy(id = "sendemail") 
	private WebElement sendButton; 

	@FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/nav/ul/li[5]/a/span") 
	private WebElement counterLabel; 

	@FindBy(xpath = "/html/body/div[4]/h2") 
	private WebElement messageLabel; 

	@FindBy(id = "LoadingPDF") 
	private List<WebElement> loadingLabel;	
	
	public SendQuotePage setemailInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		emailInput.sendKeys(text);
		return this;
	}

	public SendQuotePage setusernameInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
		usernameInput.sendKeys(text);
		return this;
	}

	public SendQuotePage setpasswordInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.sendKeys(text);
		return this;
	}

	public SendQuotePage setconfirmpasswordInput(String text) {
		wait.until(ExpectedConditions.visibilityOf(confirmpasswordInput));
		confirmpasswordInput.sendKeys(text);
		return this;
	}
	
	public SendQuotePage sendButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(sendButton));
		sendButton.click();
		return this;
	} 
	
	public String getCounterLabel() {
		wait.until(ExpectedConditions.visibilityOf(counterLabel));
		return counterLabel.getText();
	}
	
	public String getMessageLabel() {
		wait.until(ExpectedConditions.visibilityOf(messageLabel));
		return messageLabel.getText();
	}
	
	public boolean hasLoading() {
		return !loadingLabel.isEmpty();
	}
}
