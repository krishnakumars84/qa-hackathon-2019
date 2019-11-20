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


public class TraditionalTestsV2 extends TraditionalTests {	
	
	
	@BeforeTest
	public void setUp() {
		super.loginUrl = "https://demo.applitools.com/hackathonV2.html";
		super.dashboardUserNameText = By.cssSelector("#logged-user-name-new");
		super.loginPageErrorBlankUsernamePassword = "Please enter both username and password";
		super.expectedDashboardUrl = "https://demo.applitools.com/hackathonAppV2.html";
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(super.loginUrl);
	}
	}
