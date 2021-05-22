package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	// Objects
	WebDriver driver;
	public By signInBtn = By.xpath("//a[contains(text(),'Sign in')]");

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getSingInBtn() {
		return Utility.Utils.waitToBeClickable(driver, signInBtn, 15);
	}

}
