package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);	
		this.driver.manage().window().maximize();	
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		wait = new WebDriverWait(this.driver, 45);
	}

	public void SelectItem(WebElement element, int index) {
		Select selectObject = new Select(element);
		selectObject.selectByIndex(index);		
	}
	
	public void Wait(int timeMs) {
		try {
			Thread.sleep(timeMs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}