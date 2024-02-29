package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber_utils.Cucumber_excel_utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Bookshelves;
import pageObject.Display_Bookshelves;
import pageObject.Gift_Cards;
import pageObject.Living;
import utilities.ReadUtils;

public class Steps {

	public static WebDriver driver = Hooks.getDriver();
	String br;

	Display_Bookshelves DB = new Display_Bookshelves(driver);
	Bookshelves BS = new Bookshelves(driver);
	Living live = new Living(driver);
	Gift_Cards GC = new Gift_Cards(driver);
	Cucumber_excel_utils wrire = new Cucumber_excel_utils();

	List<String> NameList = new ArrayList<>();
	List<String> PriceList = new ArrayList<>();

	List<String> Living_list = new ArrayList<>();

	/*
	 * @Given("Selecting the browser we want") public void
	 * Selecting_the_browser_we_want() { br = "chrome"; if (br.equals("chrome")) {
	 * driver = new ChromeDriver(); } else if (br.equals("edge")) { driver = new
	 * EdgeDriver(); } }
	 */

	/*
	 * @Given("Opening the browser") public void Opening_the_browser() {
	 * driver.get("https://www.urbanladder.com/");
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * driver.manage().window().maximize();
	 */


	@Given("Locate searchbox and search bookshelves")
	public void locate_searchbox_and_search_bookshelves() {

		BS.input_box();
		BS.search_input();
	}

	@Then("close the add pop-up")
	public void close_the_add_pop_up() {

		BS.close_add_popUp();
	}

	@Then("Select the category as Kids")
	public void select_the_category_as_kids() throws InterruptedException {

		WebElement category = DB.choose_Category();

		Actions action = new Actions(driver);
		action.moveToElement(category).build().perform();

		WebElement Kids_type = DB.choose_kids_bookshelves();
		Kids_type.click();

		Thread.sleep(2000);
	}

	@Then("Set the price range")
	public void set_the_price_range() {

		WebElement Pricer_slider = DB.price_slide();

		Actions action = new Actions(driver);
		action.moveToElement(Pricer_slider).build().perform();

		WebElement high_slider = DB.max_slide();
		action.dragAndDropBy(high_slider, -211, 0).build().perform();
		
		DB.out_of_stock();

	}

	@Then("Select high to low")
	public void select_high_to_low() {

		WebElement recommended = DB.recommended();

		Actions action = new Actions(driver);
		action.moveToElement(recommended).build().perform();

		DB.high_to_low();

	}

	@Then("Retrive the first three product data")
	public void retrive_the_first_three_product_data() {

		List<WebElement> Name_Data = DB.Name();
		List<WebElement> Price_Data = DB.Price();
		System.out.println("------PRODUCT DETAILS--------");
		for (int i = 0; i < 3; i++) {
			String Bookshelve_name = Name_Data.get(i).getText();
			String Bookshelve_Price = Price_Data.get(i).getText();
			System.out.println(Bookshelve_name + " - " + Bookshelve_Price);

			NameList.add(Bookshelve_name);
			PriceList.add(Bookshelve_Price);
		}

	}

	@Then("Print the values in excel")
	public void print_the_vales_in_excel() throws IOException {

		wrire.writeData("Product Data", NameList, 0, 0);
		wrire.writeData("Product Data", PriceList, 0, 1);

	}

	@Then("Scroll to top")
	public void scroll_to_top() throws InterruptedException {

		Thread.sleep(4000);
		live.scroll_to_top();

	}

	@Then("Click the logo btn")
	public void click_the_logo_btn() {

		live.click_logo();

	}

	@Then("Hover on living header")
	public void hover_on_living_header() {

		WebElement Living_Header = live.Living_Nav();

		Actions action = new Actions(driver);
		action.moveToElement(Living_Header).build().perform();

	}

	@Then("Retrive the sub headers in living header")
	public void retrive_the_sub_headers_in_living_header() throws InterruptedException {

		List<WebElement> Living = live.Living_Ele();
		Thread.sleep(4000);
		System.out.println("------LIVING HEADER--------");
		for (WebElement ele : Living) {
			String Value = ele.getText();
			System.out.println(Value);
			Living_list.add(Value);
		}

	}

	@Then("Print the data in excel")
	public void print_the_data_in_excel() throws IOException {

		wrire.writeData("Living Sub Heading", Living_list, 0, 0);

	}

	@Then("Click on gift card")
	public void click_on_gift_card() {

		GC.gift();

	}

	@Then("Scroll and click birthday")
	public void scroll_and_click_birthday() {

		GC.scroll();
		GC.Birthday();

	}

	@Then("Select the amount and date")
	public void select_the_amount_and_date() {

		GC.choose_btn();

		WebElement Price_Btn = GC.price();
		Price_Btn.click();
		GC.Month();

	}

	@Then("Click ok btn")
	public void click_ok_btn() {

		WebElement Next_Btn = GC.next();
		Next_Btn.click();

	}

	@Then("Fill the to data")
	public void fill_the_to_data() throws IOException {

		String[] data = ReadUtils.FileData();

		GC.name_to().sendKeys(data[0]);
		GC.mail_to().sendKeys(data[1]);
		GC.mobile_to().sendKeys(data[2]);

	}

	@Then("Fill the from data")
	public void fill_the_from_data() throws InterruptedException, IOException {

		String[] data = ReadUtils.FileData();

		GC.name_from().sendKeys(data[3]);

		GC.mail_from().sendKeys(data[4]);
		System.out.println("------ERROR MESSAGE--------");
		String msg = driver.findElement(By.xpath("//*[@id='ip_4081352456']")).getAttribute("validationMessage");
		System.out.println(msg);

		GC.mobile_from().sendKeys(data[5]);
		GC.address_from().sendKeys(data[6]);
		GC.pincde_from().sendKeys(data[7]);

		GC.submit();
		Thread.sleep(3000);

		GC.mail_from().clear();
		GC.mail_from().sendKeys("raj@gmail.com");

		GC.submit();
		Thread.sleep(4000);

	}

}
