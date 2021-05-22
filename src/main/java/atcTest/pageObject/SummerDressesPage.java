package atcTest.pageObject;

import java.util.List;

import org.openqa.selenium.By;
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
		List<WebElement> items = getNumberOfItems();
		//System.out.println("itrems" + items.size());

		items.get(row - 1).click();
		Utils.checkAssertEquals(driver, "Printed Summer Dress - My Store", "Product not selected properly");
		int count=1;
		// quantity selection
		// System.out.println("qc"+getQuantityField().getAttribute("value"));
		
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

	private List<WebElement> getNumberOfItems() {

		return Utility.Utils.waitForElementsPresence(driver, listViewNoOfItems, 20);
	}
}
