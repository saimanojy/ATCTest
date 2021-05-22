package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutAddressPage {
	WebDriver driver;
	public By ChekOutbtn = By.xpath("//p[@class='cart_navigation clearfix']/button/span");

	public CheckOutAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProceedCheckOutBtn() {
		return Utility.Utils.waitForElementPresence(driver, ChekOutbtn, 10);
	}

}
