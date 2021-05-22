package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutSummaryPage {
	WebDriver driver;
	public By proceedCheckOut = By.xpath("//div[@id='HOOK_SHOPPING_CART']/parent::div/p[2]/a");

	public CheckOutSummaryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getProceedCheckOutBtn() {
		return Utility.Utils.waitToBeClickable(driver, proceedCheckOut, 5);
	}

}
