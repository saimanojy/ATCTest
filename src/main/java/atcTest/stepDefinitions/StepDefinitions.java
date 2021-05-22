package atcTest.stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Utility.Utils;
import atcTest.pageObject.AccountPage;
import atcTest.pageObject.AddAddressPage;
import atcTest.pageObject.CheckOutAddressPage;
import atcTest.pageObject.CheckOutBankWirePage;
import atcTest.pageObject.CheckOutPaymentPage;
import atcTest.pageObject.CheckOutShippingPage;
import atcTest.pageObject.CheckOutSummaryPage;
import atcTest.pageObject.HomePage;
import atcTest.pageObject.MyAddressesPage;
import atcTest.pageObject.OrderHistoryPage;
import atcTest.pageObject.SignInPage;
import atcTest.pageObject.SummerDressesPage;
import atcTest.pageObject.TopMenuElements;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	public WebDriver driver;
	public String userEmail, userPassword, url, browser;
	public Properties prop;
	public List<HashMap<String, String>> dataSet;
	public AccountPage accountPage;
	public AddAddressPage addAddressPage;
	public HomePage homePage;
	public MyAddressesPage myAddressesPage;
	public SignInPage signInPage;
	public TopMenuElements topMenu;
	public SummerDressesPage summerDressesPage;
	public CheckOutSummaryPage checkOutSummary;
	public CheckOutAddressPage checkOutAddress;
	public CheckOutShippingPage checkOutShip;
	public CheckOutPaymentPage checkOutPay;
	public CheckOutBankWirePage checkOutBankWire;
	public OrderHistoryPage orderHis;

	public StepDefinitions() throws FileNotFoundException, IOException {

		// reading input.properties file
		prop = new Properties();
		prop.load(new FileInputStream("./src/test/resources/input.properties"));
		url = prop.getProperty("URL");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		// initializing driver of all POM class using constructor with driver parameter
		accountPage = new AccountPage(driver);
		addAddressPage = new AddAddressPage(driver);
		homePage = new HomePage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		signInPage = new SignInPage(driver);
		topMenu = new TopMenuElements(driver);
		summerDressesPage = new SummerDressesPage(driver);
		checkOutSummary = new CheckOutSummaryPage(driver);
		checkOutAddress = new CheckOutAddressPage(driver);
		checkOutShip = new CheckOutShippingPage(driver);
		checkOutPay = new CheckOutPaymentPage(driver);
		checkOutBankWire = new CheckOutBankWirePage(driver);
		orderHis = new OrderHistoryPage(driver);
		// read input excel data
		dataSet = Utility.ReadExcelData.readExcelDatafromFile("./src/test/resources/input.xlsx", "Sheet1");

	}

	@After // executes when scenario fails
	public void tearDown(Scenario scenario) throws IOException {
		System.out.println("Test case Failed");
		if (scenario.isFailed()) {
			// Take a screenshot...
			Utils.takeSceenShot(driver, "Error Page");
		}
	}

	@After // executes when scenario is passed
	public void cleanUp() {
		// closes driver
		driver.quit();
	}

	@Given("^valid registered email and password in (\\d+) row$")
	public void valid_registered_email_and_password_in_row(int row) throws Throwable {
		Utils.checkAssertEquals(driver, "My Store", "web page not opened");
		homePage.getSingInBtn().click();
		Utils.checkAssertEquals(driver, "Login - My Store", "Sign In page not opened");
		signInPage.signIn(dataSet.get(row - 1).get("emailId"), dataSet.get(row - 1).get("password"));
	}

	@Given("clicked on SignIn")
	public void clicked_on_SignIn() {
		signInPage.getSignInBtn().click();
	}

	@Then("login should be successfull")
	public void login_should_be_successfull() {
		Utils.checkAssertEquals(driver, "My account - My Store", "Login Unsuccessfull");
	}

	@When("^clicked My addresses$")
	public void clicked_My_addresses() throws Throwable {
		accountPage.getMyAddressesBtn().click();
	}

	@Then("^addresses page should be navigated successfully$")
	public void addresses_page_should_be_navigated_successfully() throws Throwable {
		Utils.checkAssertEquals(driver, "Addresses - My Store", "Addresses page not opened");
	}

	@When("^clicked Add New Addresses$")
	public void clicked_Add_New_Addresses() throws Throwable {
		myAddressesPage.getAddAddress().click();
	}

	@Then("^Add address pages should be displayed$")
	public void add_address_pages_should_be_displayed() throws Throwable {
		Utils.checkAssertEquals(driver, "Address - My Store", "Add Address page not opened");
	}

	@When("^user fills all fields from (\\d+) with new data and click on save$")
	public void user_fills_all_fields_from_with_new_data_and_click_on_save(int row) throws Throwable {
		addAddressPage.fillAllDetails(dataSet.get(row - 1));
		addAddressPage.getSaveBtn().click(); // clicking save button
	}

	@Then("^my address page should be displayed$")
	public void my_address_page_should_be_displayed() throws Throwable {
		Utils.checkAssertEquals(driver, "Addresses - My Store", "Addresses addition failed, it may be already present");
	}

	@When("^clicked on women and selected summer dresses$")
	public void clicked_on_women_and_selected_summer_dresses() throws Throwable {
		topMenu.clickCategory("Women", "Dresses", "Summer Dresses");

	}

	@Then("^summer dresses page should be opened$")
	public void summer_dresses_page_should_be_opened() throws Throwable {
		Utils.checkAssertEquals(driver, "Summer Dresses - My Store", "Navigation unsuccessful to Summer dresses page");
	}

	@Then("^change view to list view$")
	public void change_view_to_list_view() throws Throwable {
		summerDressesPage.getListView().click();
	}

	@Then("^add (\\d+) items to cart$")
	public void add_items_to_cart(int count) throws Throwable {
		// adding items in 3 rows continuously
		for (int row = 1; row <= count; row++)
			summerDressesPage.addItemsToCart(row, 5, "L");
	}

	@When("^clicked on checkout$")
	public void clicked_on_checkout() throws Throwable {
		topMenu.clickCheckOut();

	}

	@Then("^order page should be opened$")
	public void order_page_should_be_opened() throws Throwable {
		Utils.checkAssertEquals(driver, "Order - My Store", "Navigation unsuccessful to check out page");
	}

	@Then("^complete the order$")
	public void complete_the_order() throws Throwable {
		checkOutSummary.getProceedCheckOutBtn().click(); // clicks proceed in check out summary page

		Utils.checkAssertEquals(driver, "Order - My Store", "Navigation to address page failed");
		checkOutAddress.getProceedCheckOutBtn().click(); // click proceed in check out Address Page

		Utils.checkAssertEquals(driver, "Order - My Store", "Navigation to shipment page failed");
		checkOutShip.getTermsCheckBoxn().click(); // accept terms in check out ship page
		checkOutShip.getProceedCheckOutBtn().click(); // clicks process in check out shipping page

		Utils.checkAssertEquals(driver, "Order - My Store", "Navigation to payment page failed");
		checkOutPay.getBankPay().click(); // clicks on pay by bank in payment page

		Utils.checkAssertEquals(driver, "My Store", "Navigation unsuccessful to bank wire payment page");
		checkOutBankWire.getConfirmOrder().click(); // clicks on confirm order in bank payment page
		Utils.checkAssertEquals(driver, "Order confirmation - My Store", "Order not placed");
	}

	@When("^clicked on username$")
	public void clicked_on_username() throws Throwable {
		topMenu.getMyAccount().click(); // click in My account form toper
	}

	@Then("^acoount details should be opened$")
	public void acoount_details_should_be_opened() throws Throwable {

		Utils.checkAssertEquals(driver, "My account - My Store", "Navigation to My account failed");
	}

	@When("^clicked order history and details$")
	public void clicked_order_history_and_details() throws Throwable {
		accountPage.getOrderHistory().click();
	}

	@Then("^order history should be displayed$")
	public void order_history_should_be_displayed() throws Throwable {
		Utils.checkAssertEquals(driver, "Order history - My Store", "Navigation to My oder history failed");
		Utils.takeSceenShotWithScroll(driver, orderHis.getOrderHistoryDiv(), "Oder History");
	}

	@When("^clicked sign out$")
	public void clicked_sign_out() throws Throwable {
		topMenu.getLogOut().click(); // clicks sign out
	}

	@Then("^signIn home page should be displayed$")
	public void signin_home_page_should_be_displayed() throws Throwable {
		Utils.checkAssertEquals(driver, "Login - My Store", "Log out not successfull - Sign In page not opened");
	}

}
