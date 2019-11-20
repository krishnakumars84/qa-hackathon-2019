package qa.selenium;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class VisualTests 
{	public WebDriver driver;
	public String loginUrl ;
	
	By loginPageUsername = By.cssSelector("#username");
	By loginPageUsernameLabel = By.cssSelector(".form-group:first-child label");
	By loginPageUsernameIcon = By.cssSelector(".form-group .os-icon-user-male-circle");
	By loginPagePassword = By.cssSelector("#password");
	By loginPagePasswordLabel = By.cssSelector(".form-group:nth-child(2) label");
	By loginPagePasswordIcon = By.cssSelector(".form-group .os-icon-fingerprint");
	By loginPageLoginButton = By.cssSelector("#log-in");
	By loginPageRememberMeCheckbox = By.cssSelector("input.form-check-input");
	By loginPageTwitterButton = By.cssSelector("img[src $= \"twitter.png\"]");
	By loginPageFacebookButton = By.cssSelector("img[src $= \"facebook.png\"]");
	By loginPageLinkedinButton = By.cssSelector("img[src $= \"linkedin.png\"]");
	By loginPageLogoImage = By.cssSelector(".logo-w img");
	By loginPageHeaderText = By.cssSelector(".auth-header");
	By loginPageAlertMessage = By.cssSelector(".alert-warning");
	By dashboardUserNameText = By.cssSelector("#logged-user-name");
	By dashboardTableRow = By.cssSelector("#transactionsTable tbody tr");
	By dashboardTableRowAmountValue = By.cssSelector(" td.text-right.bolder.nowrap span");
	By dashboardTableAmountColumnHeader = By.cssSelector("#amount");
	By dashboardCompareExpenses = By.cssSelector("#showExpensesChart");
	By compareExpensesChartImage = By.cssSelector("#canvas");
	By showDataForNextYearbtn = By.cssSelector("#addDataset");
	By dynamicAdOne = By.cssSelector("#flashSale");
	By dynamicAdOneImage = By.cssSelector("#flashSale img");
	By dynamicAdTwo = By.cssSelector("#flashSale2");
	By dynamicAdTwoImage = By.cssSelector("#flashSale2 img");
	
	EyesRunner runner = new ClassicRunner();
	Eyes eyes = new Eyes(runner);
	BatchInfo batch = new BatchInfo("Hackathon");
	
	@BeforeTest
	public void setUp() {
		loginUrl = "https://demo.applitools.com/hackathon.html";
		eyes.setApiKey("MkPu2bfaLsokwn2Yarkp4sOWv107RCGveuXbc4PN105W107v8110");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		eyes.open(driver, "HackathonApp", "Visual AI Tests", new RectangleSize(800, 600));
		eyes.setForceFullPageScreenshot(true);
		eyes.setBatch(batch);
		driver.get(loginUrl);
	}
	
	@AfterTest
	public void teardown() {
		eyes.closeAsync();
		driver.quit();
		eyes.abortIfNotClosed();
	}
	
	@Test(priority = 1)
	public void checkLoginpageUIonLoad( ) {
		driver.get(loginUrl);
		eyes.checkWindow("Login_Page");
		}
	@Test(priority = 17)
	public void validateSubmitEmptyUsernamePassword() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		eyes.checkWindow("Login_Page_Empty_Username_Password_Submit");
	}
	@Test(priority = 18)
	public void validateSubmitEmptyPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		eyes.checkWindow("Login_Page_Empty_Password_Submit");

	}
	@Test(priority = 19)
	public void validateSubmitEmptyUsername() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		eyes.checkWindow("Login_Page_Empty_Username_Submit");
		}
	
	@Test(priority = 20)
	public void validateSuccessfulLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardCompareExpenses));
		eyes.checkWindow("Dashboard_Page_On_Load");
	}
	
	@Test(priority = 21)
	public void validateTableSortedDescendingAmount( ) {
		driver.findElement(dashboardTableAmountColumnHeader).click();
		eyes.checkWindow("Dashboard_Page_Table_Sorted_Ascending");

	}
	
	@Test(priority = 23)
	public void validateBarCharts() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardCompareExpenses));
		driver.findElement(dashboardCompareExpenses).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(showDataForNextYearbtn));
		eyes.checkWindow("Charts_Page_Default_Load");
		}
	
	@Test(priority=24)
	public void validateShowDataForNextYear( ) {
		driver.findElement(showDataForNextYearbtn).click();
		eyes.checkWindow("Charts_Page_Added_Year_Load");
	}

	@Test(priority=25)
	public void  validateDynamicAds( ) {
		driver.get(loginUrl+"?showAd=true");
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardUserNameText));
		eyes.checkWindow("Dashboard_With_Dynamic_Ads_Default_Load");
	}
}