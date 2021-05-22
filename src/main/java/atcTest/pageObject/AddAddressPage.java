package atcTest.pageObject;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.Utils;

public class AddAddressPage {
	WebDriver driver;
	// objects
	public By firstNameField = By.xpath("//input[@id='firstname']");
	public By lastNameField = By.xpath("//input[@id='lastname']");
	public By companyField = By.xpath("//input[@id='company']");
	public By address1Field = By.xpath("//input[@id='address1']");
	public By address2Field = By.xpath("//input[@id='address2']");
	public By cityField = By.xpath("//input[@id='city']");
	public By stateSelect = By.xpath("//select[@id='id_state']");
	public By zipField = By.xpath("//input[@id='postcode']");
	public By countrySelect = By.xpath("//select[@id='id_country']");
	public By homePhoneField = By.xpath("//input[@id='phone']");
	public By mobilePhoneField = By.xpath("//input[@id='phone_mobile']");
	public By additionalInfoText = By.xpath("//textarea[@id='other']");
	public By addressTitleField = By.xpath("//input[@id='alias']");
	public By saveBtn = By.xpath("//button[@id='submitAddress']");

	public AddAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	// getters
	public WebElement getFirstNameField() {
		return Utility.Utils.waitForElementPresence(driver, firstNameField, 10);
	}

	public WebElement getLastNameField() {
		return Utility.Utils.waitForElementPresence(driver, lastNameField, 10);
	}

	public WebElement getCompanyField() {
		return Utility.Utils.waitForElementPresence(driver, companyField, 10);
	}

	public WebElement getAddress1Field() {
		return Utility.Utils.waitForElementPresence(driver, address1Field, 10);
	}

	public WebElement getAddress2Field() {
		return Utility.Utils.waitForElementPresence(driver, address2Field, 10);
	}

	public WebElement getCityField() {
		return Utility.Utils.waitForElementPresence(driver, cityField, 10);
	}

	public Select stateSelect() {
		WebElement state = Utils.waitForElementPresence(driver, stateSelect, 10);
		return new Select(state);
	}

	public WebElement getZipField() {
		return Utility.Utils.waitForElementPresence(driver, zipField, 10);
	}

	public Select countrySelect() {
		WebElement country = Utils.waitForElementPresence(driver, countrySelect, 10);
		return new Select(country);
	}

	public WebElement gethomePhoneField() {
		return Utility.Utils.waitForElementPresence(driver, homePhoneField, 10);
	}

	public WebElement getMobilePhoneField() {
		return Utility.Utils.waitForElementPresence(driver, mobilePhoneField, 10);
	}

	public WebElement getAdditionalInfoText() {
		return Utility.Utils.waitForElementPresence(driver, additionalInfoText, 10);
	}

	public WebElement getAddressTitleField() {
		return Utility.Utils.waitForElementPresence(driver, addressTitleField, 10);
	}

	public WebElement getSaveBtn() {
		return Utility.Utils.waitToBeClickable(driver, saveBtn, 10);
	}

	public void fillAllDetails(HashMap<String, String> data) {
		getFirstNameField().clear();
		getFirstNameField().sendKeys(data.get("firstName"));
		getLastNameField().clear();
		getLastNameField().sendKeys(data.get("lastName"));
		getCompanyField().sendKeys(data.get("company"));
		getAddress1Field().sendKeys(data.get("addressLine1"));
		getAddress2Field().sendKeys(data.get("addressLine2"));
		getCityField().sendKeys(data.get("city"));
		Utils.dropDownSelect(stateSelect(), data.get("state"));
		getZipField().sendKeys(data.get("zipCode"));
		Utils.dropDownSelect(countrySelect(), data.get("country"));
		gethomePhoneField().sendKeys(data.get("homePhone"));
		getMobilePhoneField().sendKeys(data.get("mobilePhone"));
		getAdditionalInfoText().sendKeys(data.get("additionalInfo"));
		getAddressTitleField().clear();
		getAddressTitleField().sendKeys(data.get("title"));

	}

}
