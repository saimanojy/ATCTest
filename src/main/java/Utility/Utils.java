package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atcTest.pageObject.ProductPage;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Utils {
	// function to wait for element to be click able, returns web element
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		try {
			WebElement element = (new WebDriverWait(driver, waitInterval))
					.until(ExpectedConditions.elementToBeClickable(selector));
			return element;
		} catch (TimeoutException e) {
			/* handling when URL blocked alert is displayed after clicking on Add To Cart */
			if (driver.findElement(By.cssSelector("p[class='fancybox-error']")).isDisplayed()) {
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(new ProductPage(driver).addToCartBtn).click();
				return driver.findElement(new ProductPage(driver).continueShopBtn);
			} else
				e.printStackTrace();
		}
		return null;
	}

	// function to wait for element to be present, returns web element
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}

	// function to wait for child element to visible, returns web element
	public static WebElement waitforChild(WebDriver driver, WebElement element, By selector, int waitInterval) {
		WebElement result = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.visibilityOf(element.findElement(selector)));
		return result;
	}

	// function to wait for elements to visible, returns list of web element
	public static List<WebElement> waitForElementsPresence(WebDriver driver, By selector, int waitInterval) {
		java.util.List<WebElement> element = (new WebDriverWait(driver, waitInterval))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
		return element;
	}

	// function to select value in drop down
	public static boolean dropDownSelect(Select select, String value) {

		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			// System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				return true;
			}
		}
		return false;

	}

	// funcion to take screenshot, takes webDriver and string as parameter
	public static void takeSceenShot(WebDriver driver, String msg) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		// System.out.println("time"+timeStamp);
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("./screenshots/" + msg + "_" + timeStamp + ".png"));
	}

	// funcion to take screenshot, takes webDriver, element and string as parameter
	public static void takeSceenShotWithScroll(WebDriver driver, WebElement ele, String msg) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		// System.out.println(msg + "_" + timeStamp);
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("./screenshots/" + msg + "_" + timeStamp + ".png"));
	}

	// function to check two values and report assertion error
	public static void checkAssertEquals(WebDriver driver, String expected, String msg) {
		// System.out.println("checking");
		int refreshRate = 3;
		try {
			Assert.assertEquals(driver.getTitle(), expected, msg);
		} catch (java.lang.AssertionError e) {

			/*
			 * Code to handle where URL id blocked This situation is overcome by refreshing
			 * page however this has to be reported in real time
			 */

			if (driver.getTitle().toString().length() == 0) {
				while (refreshRate != 0 && driver.getTitle().toString().length() == 0) {
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					/*
					 * This error came when URL blocked by clicking confirm order. In this case
					 * after refresh order already placed message will be displayed so navigation to
					 * account URL in this case
					 */
					if (driver.findElement(By.xpath("/html/body")).getText()
							.contains("Cart cannot be loaded or an order has already been placed")) {
						driver.get("http://automationpractice.com/index.php?controller=my-account");
						return;
					}
					refreshRate--;

				}

			} else
				e.printStackTrace();
		}

	}

}
