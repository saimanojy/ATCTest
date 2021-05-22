package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutShippingPage {
	WebDriver driver;
	public By termsCheckBox = By.xpath("//input[@id='cgv']");
	public By ChekOutbtn = By.xpath("//p[@class='cart_navigation clearfix']/button/span");

	public CheckOutShippingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getTermsCheckBoxn() {
		return Utility.Utils.waitForElementPresence(driver, termsCheckBox, 8);
	}

	public WebElement getProceedCheckOutBtn() {
		return Utility.Utils.waitForElementPresence(driver, ChekOutbtn, 5);
	}

}
