package atcTest.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utility.Utils;

public class TopMenuElements { // common for every pages
	// objects
	WebDriver driver;
	public By categories = By.xpath("//div[@id='block_top_menu']/ul");
	public By myCart = By.cssSelector("div[class='shopping_cart'] a");
	public By checkOut = By.cssSelector("a#button_order_cart");
	public By myAccount = By.cssSelector("div[class*='header'] a[class='account']");
	public By logOut = By.cssSelector("div[class*='header'] a[title*='Log']");

	public TopMenuElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCategories() {
		return Utils.waitForElementPresence(driver, categories, 7);
	}

	public WebElement getCheckOut() {
		return Utils.waitForElementPresence(driver, checkOut, 7);
	}

	public WebElement getMyAccount() {
		return Utils.waitForElementPresence(driver, myAccount, 7);
	}

	public WebElement getLogOut() {
		return Utils.waitForElementPresence(driver, logOut, 7);
	}

	public void clickCategory(String value, String category1, String category2) {
		List<WebElement> categories = getCategories().findElements(By.tagName("li"));
		//System.out.println("cate " + categories.size());
		for (WebElement category : categories) {
			if (category.getText().trim().equalsIgnoreCase(value)) {
				Actions act = new Actions(driver);
				act.moveToElement(category).build().perform();
				List<WebElement> subCaterogories1 = category.findElements(By.xpath("./ul/child::li"));
				// System.out.println("cat1 len"+subCaterogories1.size());
				for (WebElement subCategory1 : subCaterogories1) {
					// System.out.println("1"+subCategory1.findElement(By.tagName("a")).getText().trim());
					if (Utils.waitforChild(driver, subCategory1, By.tagName("a"), 7).getText().trim()
							.equalsIgnoreCase(category1)) {
						// System.out.println("cat1 found");
						List<WebElement> subCategories2 = subCategory1.findElements(By.xpath("./ul/child::li"));
						// System.out.println("cat2 lenght"+subCategories2.size());
						for (WebElement subCategory2 : subCategories2) {
							//System.out.println("2" + subCategory2.getText().trim());
							if (Utils.waitforChild(driver, subCategory2, By.tagName("a"), 7).getText().trim()
									.equalsIgnoreCase(category2)) {
								subCategory2.click();
								break;
							}

						}
						break;
					}
				}
				break;
				// act.moveToElement(category).moveToElement(category.findElement(By.xpath("./ul/child:li)))
			}
		}
	}

	public void clickCheckOut() {
		WebElement cart = Utils.waitForElementPresence(driver, myCart, 7);
		/*
		 * Actions act=new Actions(driver); act.moveToElement(cart).build().perform();
		 * getCheckOut().click();
		 */
		cart.click();

	}
}
