package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage {
	// Objects
	public By orderHisDiv = By.cssSelector("div#center_column");
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getOrderHistoryDiv() {
		return Utility.Utils.waitToBeClickable(driver, orderHisDiv, 10);
	}
}
