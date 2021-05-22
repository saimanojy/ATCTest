package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	//objects
	WebDriver driver;
	public By signInEmailField = By.cssSelector("input#email");
	public By signInPwdField = By.cssSelector("input#passwd");
	public By signInBtn = By.cssSelector("#SubmitLogin");

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignInEmailField() {
		return Utility.Utils.waitForElementPresence(driver, signInEmailField, 10);
	}

	public WebElement getSignInPwdField() {
		return Utility.Utils.waitForElementPresence(driver, signInPwdField, 10);
	}

	public WebElement getSignInBtn() {
		return Utility.Utils.waitToBeClickable(driver, signInBtn, 10);
	}

	// methods
	public void signIn(String userName, String password) {
		getSignInEmailField().sendKeys(userName);
		getSignInPwdField().sendKeys(password);
	}
}
