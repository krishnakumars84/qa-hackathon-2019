package qa.selenium;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TraditionalTests 
{	public WebDriver driver;
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
	By dynamicAdOne = By.cssSelector("#flashSale");
	By dynamicAdOneImage = By.cssSelector("#flashSale img");
	By dynamicAdTwo = By.cssSelector("#flashSale2");
	By dynamicAdTwoImage = By.cssSelector("#flashSale2 img");
	//Login URL String:
	public String loginUrl;
	
	//Strings to be used for comparison in tests:
	public String loginPageUsernameLabelText= "Username";
	public String loginPagePasswordLabelText = "Password";
	public String loginPageHeaderTextContent = "Login Form";
	public String loginPageUsernamePlaceholderText = "Enter your username";
	public String loginPagePasswordPlaceholderText = "Enter your password";
	public String loginPageErrorBlankUsernamePassword = "Both Username and Password must be present";
	public String loginPageErrorBlankUsername = "Username must be present";
	public String loginPageErrorBlankPassword = "Password must be present";
	public String expectedDashboardUrl = "https://demo.applitools.com/hackathonApp.html";

	
	
		
	@BeforeTest
	public void setUp() {
		loginUrl = "https://demo.applitools.com/hackathon.html";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(loginUrl);
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void checkUsernameFieldExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageUsername).size(), 0, 0, "Username field does not exist");
		}
	@Test(priority = 2)
	public void checkUsernameLabelExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageUsernameLabel).size(), 0, 0, "Username label does not exist");
		Assert.assertEquals(driver.findElement(loginPageUsernameLabel).getText(), loginPageUsernameLabelText,"Username label text is not as expected");
	}
	@Test(priority = 3)
	public void checkUsernameIconExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageUsernameIcon).size(), 0, 0, "Username icon does not exist");

	}
	@Test(priority = 4)
	public void checkPasswordFieldExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPagePassword).size(), 0, 0, "Password field does not exist");
	}
	@Test(priority = 5)
	public void checkPasswordLabelExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPagePasswordLabel).size(), 0, 0, "Password label does not exist");
		Assert.assertEquals(driver.findElement(loginPagePasswordLabel).getText(), loginPagePasswordLabelText,"Password label text is not as expected");

	}
	@Test(priority = 6)
	public void checkPasswordIconExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPagePasswordIcon).size(), 0, 0, "Password icon does not exist");
	}
	@Test(priority = 7)
	public void checkLoginButtonExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageLoginButton).size(), 0, 0, "Login button does not exist");
	}
	@Test(priority = 8)
	public void checkRememberMeCheckboxExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageRememberMeCheckbox).size(), 0, 0, "Remember Me checkbox does not exist");
	}
	@Test(priority = 9)
	public void checkTwitterButtonExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageTwitterButton).size(), 0, 0, "Twitter button does not exist");
	}
	@Test(priority = 10)
	public void checkFacebookButtonExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageFacebookButton).size(), 0, 0, "Facebook button does not exist");
	}
	@Test(priority = 11)
	public void checkLinkedinButtonExists( ) {
		Assert.assertNotEquals(driver.findElements(loginPageLinkedinButton).size(), 0, 0, "Linkedin button does not exist");
	}
	@Test(priority = 12)
	public void checkLogoImageExists() {
		Assert.assertNotEquals(driver.findElements(loginPageLogoImage).size(), 0, 0, "Logo image does not exist");
	}
	@Test(priority = 13)
	public void checkHeaderTextExists() {
		Assert.assertNotEquals(driver.findElements(loginPageHeaderText).size(), 0, 0, "Header text does not exist");
	}
	@Test(priority = 14)
	public void checkHeaderTextIsCorrect() {
		Assert.assertEquals(driver.findElement(loginPageHeaderText).getText(), loginPageHeaderTextContent, "Login page header text is not proper");
	}
	@Test(priority = 15)
	public void checkUsernamePlaceholderText( ) {
		Assert.assertEquals(driver.findElement(loginPageUsername).getAttribute("placeholder"), loginPageUsernamePlaceholderText,"Placeholder text for username is not correct");
	}
	@Test(priority = 16)
	public void checkPasswordPlaceholderText( ) {
		Assert.assertEquals(driver.findElement(loginPagePassword).getAttribute("placeholder"), loginPagePasswordPlaceholderText,"Placeholder text for password is not correct");
	}
	@Test(priority = 17)
	public void validateSubmitEmptyUsernamePassword() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getText(),loginPageErrorBlankUsernamePassword,"Error message for missing username and password is not correct");
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getAttribute("style"), "display: block;", "Error message style is not proper");
	}
	@Test(priority = 18)
	public void validateSubmitEmptyPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getText(),loginPageErrorBlankPassword,"Error message for missing password is not correct");
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getAttribute("style"), "display: block;", "Error message style is not proper");
	}
	@Test(priority = 19)
	public void validateSubmitEmptyUsername() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageAlertMessage));
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getText(),loginPageErrorBlankUsername,"Error message for missing username is not correct");
		Assert.assertEquals(driver.findElement(loginPageAlertMessage).getAttribute("style"), "display: block;", "Error message style is not proper");
		}
	@Test(priority = 20)
	public void validateSuccessfulLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(loginPageUsername).clear();
		driver.findElement(loginPagePassword).clear();
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardUserNameText));
		Assert.assertEquals(driver.getCurrentUrl(),expectedDashboardUrl);		
	}
	
	@Test(priority = 21,dependsOnMethods = {"validateSuccessfulLogin"})
	public void validateTableSortedDescendingAmount( ) throws ParseException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		List<WebElement> initTableRows = driver.findElements(dashboardTableRow);
		List<Double> baseAmountValues = new ArrayList<Double>();
		for (WebElement row : initTableRows) {
			String value = row.findElement(dashboardTableRowAmountValue).getText();
			value = value.substring(0,value.length()-4).replaceAll(" ", "").replace("+", "").replace(",", "");
//			baseAmountValues.add(NumberFormat.getNumberInstance(java.util.Locale.US).parse(value));			
			baseAmountValues.add(Double.parseDouble(value));
		}
		Collections.sort(baseAmountValues);
		driver.findElement(dashboardTableAmountColumnHeader).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTableRow));
		List<WebElement> sortedTableRows = driver.findElements(dashboardTableRow);
		List<Double> sortedAmountValues = new ArrayList<Double>();
		for (WebElement row : sortedTableRows) {
			String value = row.findElement(dashboardTableRowAmountValue).getText();
			value = value.substring(0,value.length()-4).replaceAll(" ", "").replace("+", "").replace(",", "");
			sortedAmountValues.add(Double.parseDouble(value));			
		}
		Assert.assertEquals(sortedAmountValues,baseAmountValues,"Amount column is NOT sorted in ascending order");
	}
	@Test(priority = 22, dependsOnMethods = {"validateSuccessfulLogin"})
	public void validateAllRowsAreIntactAfterSorting() {
		driver.navigate().refresh();
		List<WebElement> initTableRows = driver.findElements(dashboardTableRow);
		driver.findElement(dashboardTableAmountColumnHeader).click();
		List<WebElement> sortedTableRows = driver.findElements(dashboardTableRow);
		System.out.println(initTableRows.toString() + " : " + sortedTableRows.toString());
		for(WebElement row: initTableRows) {
			if (sortedTableRows.contains(row)) {
				continue;
			} else {
				Assert.assertTrue(false, "Row " + row.toString() + " not found in sorted list");
			}
		}
	}
	
	@Test(priority = 23,enabled=false)
	public void validateBarCharts() throws IOException {
		//Abandoning this test as I am unable to automate a proper validator for the bar charts 
	}
	@Test(priority=24)
	public void  validateFirstDynamicAdExists( ) {
		driver.get(loginUrl+"?showAd=true");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(loginPageUsername).sendKeys("1");
		driver.findElement(loginPagePassword).sendKeys("1");
		driver.findElement(loginPageLoginButton).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardUserNameText));
		Assert.assertNotEquals(driver.findElements(dynamicAdOne).size(), 0, 0, "The first dynamic ad does not exist");
	}
	
	@Test(priority=25) 
	public void validateFirstDynamicAdImageExists( ) {
		Assert.assertNotEquals(driver.findElements(dynamicAdOneImage).size(), 0, 0, "The first dynamic ad image does not exist");

		String imageSrc = driver.findElement(dynamicAdOneImage).getAttribute("src");
		Assert.assertTrue(imageSrc.endsWith("gif"),"GIF image not found for first dynamic ad");
	}
	
	@Test(priority = 26)
	public void validateSecondDynamicAdExists() {
		Assert.assertNotEquals(driver.findElements(dynamicAdTwo).size(), 0, 0, "The second dynamic ad does not exist");

	}
	
	@Test(priority = 27)
	public void validateSecondDynamicAdImageExists( ) {
		Assert.assertNotEquals(driver.findElements(dynamicAdTwoImage).size(), 0, 0, "The second dynamic ad image does not exist");

		String imageSrc = driver.findElement(dynamicAdTwoImage).getAttribute("src");
		Assert.assertTrue(imageSrc.endsWith("gif"),"GIF image not found for second dynamic ad");
	}
}
