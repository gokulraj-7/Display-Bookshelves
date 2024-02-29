package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Gift_Cards extends BasePage {

	public Gift_Cards(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"header\"]/section/div/ul[2]/li[3]/a")
	WebElement Gift_Card_Btn;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[1]/h2")
	WebElement scroll;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]")
	WebElement hover;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/div/button")
	WebElement Choose_this_btn;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[2]")
	WebElement Price_Btn;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[4]/select[1]")
	WebElement Month_Btn;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	WebElement Next_Btn;

	@FindBy(xpath = "//*[@id=\"ip_4036288348\"]")
	WebElement To_Name;

	@FindBy(xpath = "//*[@id=\"ip_137656023\"]")
	WebElement To_Mail;

	@FindBy(xpath = "//*[@id=\"ip_3177473671\"]")
	WebElement To_Mobile;

	@FindBy(xpath = "//*[@id=\"ip_1082986083\"]")
	WebElement From_Name;

	@FindBy(xpath = "//*[@id=\"ip_4081352456\"]")
	WebElement From_Mail;

	@FindBy(xpath = "//*[@id=\"ip_2121573464\"]")
	WebElement From_Mobile;

	@FindBy(xpath = "//*[@id=\"ip_2194351474\"]")
	WebElement From_Address;

	@FindBy(xpath = "//*[@id=\"ip_567727260\"]")
	WebElement From_Pincode;
	
	@FindBy(xpath="//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")
	WebElement Submit_btn;

	// Action Methods

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public void gift() {
		Gift_Card_Btn.click();
	}

	public void scroll() {
		js.executeScript("arguments[0]. scrollIntoView(true);", scroll);
	}

	public void Birthday() {
		hover.click();
	}

	public void choose_btn() {
		Choose_this_btn.click();
	}

	public WebElement price() {
		return Price_Btn;
	}

	public void Month() {
		Select op = new Select(Month_Btn);
		op.selectByIndex(2);
	}

	public WebElement next() {
		return Next_Btn;
	}

	public WebElement name_to() {
		return To_Name;
	}

	public WebElement mail_to() {
		return To_Mail;
	}
	
	public WebElement mobile_to() {
		return To_Mobile;
	}

	public WebElement name_from() {
		return From_Name;
	}
	
	public WebElement mail_from() {
		return From_Mail;
	}
	
	public WebElement mobile_from() {
		return From_Mobile;
	}
	
	public WebElement address_from() {
		return From_Address;
	}
	
	public WebElement pincde_from() {
		return From_Pincode;
	}
	
	public void submit() {
		Submit_btn.click();
	}
}
