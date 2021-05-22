package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	// Objects
	public By addAddress = By.xpath("//a[@title='Add an address']");
	WebDriver driver;

	public MyAddressesPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getAddAddress() {
		return Utility.Utils.waitToBeClickable(driver, addAddress, 10);
	}

}
