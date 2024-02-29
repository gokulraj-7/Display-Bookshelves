package testCase;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.Bookshelves;
import pageObject.Display_Bookshelves;
import pageObject.Gift_Cards;
import pageObject.Living;
import testBase.DriverBase;
import utilities.ExcelUtils;
import utilities.ReadUtils;

@Listeners(extentReportManager.ExtentReportManager.class)

public class TC_Display_Bookshelves extends DriverBase {

	public static String path;

	@Test(priority = 1, groups = { "regression" })
	public void search_Bookshelves() throws IOException {

		Bookshelves BS = new Bookshelves(driver);

		logger.info("Opened the URL and in the home page");
		path = DriverBase.screenShot("Home Page", driver);
		BS.input_box();
		BS.search_input();
		logger.info("Finding search box and searching bookshelves");
		BS.close_add_popUp();

	}

	@Test(priority = 2, groups = { "regression" })
	public void select_filters() throws InterruptedException, IOException {

		Display_Bookshelves DB = new Display_Bookshelves(driver);
		Thread.sleep(3000);
		path = DriverBase.screenShot("Bookshelves Page", driver);

		logger.info("Selecting category as kids bookshelves");
		WebElement category = DB.choose_Category();

		Actions action = new Actions(driver);
		action.moveToElement(category).build().perform();

		WebElement Kids_type = DB.choose_kids_bookshelves();
		Kids_type.click();
		Thread.sleep(2000);

		logger.info("Setting the price range as below 15000");
		WebElement Pricer_slider = DB.price_slide();
		action.moveToElement(Pricer_slider).build().perform();

		WebElement high_slider = DB.max_slide();
		action.dragAndDropBy(high_slider, -211, 0).build().perform();

		logger.info("Click on Exclude out of stock");
		DB.out_of_stock();

		logger.info("Click high to low filter");
		WebElement recommended = DB.recommended();
		action.moveToElement(recommended).build().perform();

		DB.high_to_low();

	}

	List<String> NameList = new ArrayList<>();
	List<String> PriceList = new ArrayList<>();

	@Test(priority = 3, groups = { "regression" })
	public void display_data() throws IOException {

		Display_Bookshelves DB = new Display_Bookshelves(driver);

		logger.info("Capturing the name and price of first three products");
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
		logger.info("Storing the values in excel");
		ExcelUtils excel = new ExcelUtils();
		excel.writeData("Product Data", NameList, 0, 0);
		excel.writeData("Product Data", PriceList, 0, 1);
	}

	List<String> Living_list = new ArrayList<>();

	@Test(priority = 4, groups = { "regression" })
	public void menu_items() throws InterruptedException, IOException {

		Living live = new Living(driver);

		Thread.sleep(4000);

		logger.info("Scroll to top of the current page");
		live.scroll_to_top();

		logger.info("Click on the website logo");
		live.click_logo();

		logger.info("Hover on living header to capture the sub-headings");
		WebElement Living_Header = live.Living_Nav();
		Actions action = new Actions(driver);

		action.moveToElement(Living_Header).build().perform();
		Thread.sleep(2000);
		path = DriverBase.screenShot("Living Elements", driver);

		System.out.println("-----LIVING HEADER--------");
		List<WebElement> Living = live.Living_Ele();
		Thread.sleep(4000);
		for (WebElement ele : Living) {
			String Value = ele.getText();
			System.out.println(Value);
			Living_list.add(Value);
		}
		logger.info("Capturing the sub-headings and storing it in the excel");
		ExcelUtils excel = new ExcelUtils();
		excel.writeData("Living Sub Heading", Living_list, 0, 0);
	}

	@Test(priority = 5, groups = { "smoke" })
	public void gift_card() throws IOException {

		Gift_Cards GC = new Gift_Cards(driver);

		logger.info("Click on Gift Cards");
		GC.gift();

		path = DriverBase.screenShot("Gift Card Page", driver);

		logger.info("Scroll down to select birthday");
		GC.scroll();
		GC.Birthday();
		GC.choose_btn();

		logger.info("Select the price and date");
		WebElement Price_Btn = GC.price();
		Price_Btn.click();
		GC.Month();

		WebElement Next_Btn = GC.next();
		Next_Btn.click();
	}

	@Test(priority = 6, groups = { "smoke" })
	public void fill_address() throws InterruptedException, IOException {
		Gift_Cards GC = new Gift_Cards(driver);

		String[] data = ReadUtils.FileData();
		logger.info("Filling the data in To and From form");
		GC.name_to().sendKeys(data[0]);
		GC.mail_to().sendKeys(data[1]);
		GC.mobile_to().sendKeys(data[2]);

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

		logger.info("Giving the valid from mail id");
		GC.mail_from().clear();
		GC.mail_from().sendKeys("raj@gmail.com");

		logger.info("Submitting the form");
		GC.submit();
		Thread.sleep(3000);
		path = DriverBase.screenShot("Final Data", driver);

	}

}