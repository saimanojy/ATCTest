package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutBankWirePage {
	WebDriver driver;
	public By confirmOrder = By.xpath("//p[@class='cart_navigation clearfix']/button/span");

	public CheckOutBankWirePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getConfirmOrder() {
		return Utility.Utils.waitForElementPresence(driver, confirmOrder, 7);
	}
}
