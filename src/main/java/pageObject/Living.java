package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Living extends BasePage{

	public Living(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"header\"]/div[1]/div/section[1]/a/figure")
	WebElement logo_btn;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/span")
	WebElement Living;
	
	@FindBy(xpath="//*[@id=\"topnav_wrapper\"]/ul/li[3]/div/div/ul/li[3]/ul/li/a/span")
	List<WebElement> Living_seating_Elements;
	
	
	//Action methods
	
	public void scroll_to_top() {
		Actions actions = new Actions(driver);
		actions.sendKeys(org.openqa.selenium.Keys.HOME).perform();
	}
	
	public void click_logo() {
		logo_btn.click();
	}
	
	public WebElement Living_Nav() {
		return Living;
	}
	
	public List<WebElement> Living_Ele() {
		return Living_seating_Elements;
	}
}
