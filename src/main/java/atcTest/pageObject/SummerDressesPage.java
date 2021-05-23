package atcTest.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utility.Utils;

public class SummerDressesPage extends ProductPage {
	// objects
	WebDriver driver;
	public By gridView = By.cssSelector("li#grid");
	public By listView = By.cssSelector("li#list");
	public By listViewNoOfItems = By
			.xpath("//span[contains(text(),'Add to cart')]/parent::a/following-sibling::a/span");
	public By listViewProducts = By.cssSelector("div[class*=center] a[class*=\"product-name\"]");

	public SummerDressesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public WebElement getGridView() {
		return Utility.Utils.waitForElementPresence(driver, gridView, 7);
	}

	public WebElement getListView() {
		return Utility.Utils.waitForElementPresence(driver, listView, 7);
	}

	public void addItemsToCart(int row, int quantity, String size) {
		List<WebElement> items = getNumberOfItems(); // gets number of available items
		List<WebElement> itemNames = getNumbeOfItemNames(); // gets names of all items
		String productName = itemNames.get(row - 1).getText().trim();
		// System.out.println("itrems" + items.size());
		items.get(row - 1).click();
		Utils.checkAssertEquals(driver, productName + " - My Store", "Product not selected properly");
		int count = 1;

		// quantity selection
		while (count != quantity) {
			getQuantityPlusField().click();
			count++;
		}
		Assert.assertEquals(Integer.parseInt(getQuantityField().getAttribute("value")), quantity,
				"Quantity Plus Minus Buttons Not working");

		// size selection
		Utils.dropDownSelect(sizeSelect(), size);

		// picking first color
		getColors().get(0).click();

		// click add to cart
		getAddToCartBtn().click();

		// click continue shop button
		getContinueShopBtn().click();

		// navigateBack
		getNavigateSummmerPage().click();
		Utils.checkAssertEquals(driver, "Summer Dresses - My Store", "Navigation unsuccessful to Summer dresses page");

	}

	private List<WebElement> getNumbeOfItemNames() {
		return Utility.Utils.waitForElementsPresence(driver, listViewProducts, 20);
	}

	private List<WebElement> getNumberOfItems() {

		return Utility.Utils.waitForElementsPresence(driver, listViewNoOfItems, 20);
	}
}
