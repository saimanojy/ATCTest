package atcTest.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.Utils;

public class ProductPage { //common for every shopping page
	// objects
	WebDriver driver;
	public By quantityField = By.cssSelector("input#quantity_wanted");
	public By sizeSelect = By.cssSelector("select#group_1");
	public By quantityPlus = By.cssSelector("a[class*='plus']");
	public By quantityMinus = By.cssSelector("a[class*='minus']");
	public By color = By.cssSelector("ul#color_to_pick_list li");
	public By addToCartBtn = By.cssSelector("p#add_to_cart button[name*='Submit']");
	public By continueShopBtn = By.cssSelector("div[class*='button'] span[class*='continue']");
	public By navigateSummmerPage = By.xpath("//div[@id='page']/div[2]/div[1]/div[1]/a[4]");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public Select sizeSelect() {
		WebElement size = Utils.waitForElementPresence(driver, sizeSelect, 5);
		return new Select(size);
	}

	public WebElement getQuantityField() {
		return Utility.Utils.waitForElementPresence(driver, quantityField, 8);
	}

	public WebElement getQuantityPlusField() {
		return Utility.Utils.waitForElementPresence(driver, quantityPlus, 5);
	}

	public WebElement getAddToCartBtn() {
		return Utility.Utils.waitToBeClickable(driver, addToCartBtn, 10);
	}

	public WebElement getQuantityMinusField() {
		return Utility.Utils.waitForElementPresence(driver, quantityMinus, 5);
	}

	public List<WebElement> getColors() {
		return Utility.Utils.waitForElementsPresence(driver, color, 5);
	}

	public WebElement getContinueShopBtn() {
		return Utility.Utils.waitToBeClickable(driver, continueShopBtn, 5);
	}

	public WebElement getNavigateSummmerPage() {
		return Utility.Utils.waitToBeClickable(driver, navigateSummmerPage, 5);
	}

}
