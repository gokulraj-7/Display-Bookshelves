package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Bookshelves extends BasePage {

	public Bookshelves(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"authentication_popup\"]/div/div/div[2]/a[1]")
	WebElement Add_Pop_up; 
	
	@FindBy(xpath="//*[@id=\"search\"]") 
	WebElement input_box;
	
	@FindBy(xpath="//*[@id=\"search_button\"]/span")
	WebElement Search_icon;

	// Action methods

	public void close_add_popUp() {
		Add_Pop_up.click();
	} 
	
	
	public void input_box() {
		input_box.sendKeys("Bookshelves");
	}

	public void search_input() {
		Search_icon.click();
	}

}
