package atcTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	 WebDriver driver;
	//Objects
	public  By myAddresses=By.cssSelector("a[title*='Addresses'] span");
	public By orderHistory=By.cssSelector("a[title*='Orders'] span");
	
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}


	public   WebElement getMyAddressesBtn()
	{
		return Utility.Utils.waitToBeClickable(driver, myAddresses, 15);
	}
	public   WebElement getOrderHistory()
	{
		return Utility.Utils.waitToBeClickable(driver, orderHistory, 15);
	}

}
