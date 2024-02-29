package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Display_Bookshelves extends BasePage{

	public Display_Bookshelves(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[1]")
	WebElement Category;
	
	@FindBy(xpath="//*[@id=\"filters_primary_category_Kids_Bookshelves\"]")
	WebElement Kids_Bookshelves;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]")
	WebElement Price_slider;
	
	@FindBy(xpath="//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div")
	WebElement high_slider;
	
	@FindBy(xpath="//*[@id=\"filters_availability_In_Stock_Only\"]")
	WebElement out_of_stock;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
	WebElement Recommended;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")
	WebElement High_to_low;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[3]/ul/li/div/div[5]/a/div[1]/span")
	List<WebElement> BookShelves_names;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[3]/ul/li/div/div[5]/a/div[2]/span")
	List<WebElement> BookShelves_price;

	
	//Action methods
	
	public WebElement choose_Category() {
		return Category;
	}
	
	public WebElement choose_kids_bookshelves() {
		return Kids_Bookshelves;
	}
	
	public WebElement price_slide() {
		return Price_slider;
	}
	
	public WebElement max_slide() {
		return high_slider;
	}
	
	public void out_of_stock() {
		out_of_stock.click();
	}
	
	public WebElement recommended() {
		return Recommended;
	}
	
	public void high_to_low() {
		High_to_low.click();
	}
	
	
	public List<WebElement> Name() {
		return BookShelves_names;
	}
	
	public List<WebElement> Price() {
		return BookShelves_price;
	}
}
