package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPaymentPage {
	WebDriver driver;
	public By bankPay = By.cssSelector("p[class*='payment'] a[class*='bank']");

	public CheckOutPaymentPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getBankPay() {
		return Utility.Utils.waitForElementPresence(driver, bankPay, 8);
	}

}
