package qa.selenium;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
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


public class VisualTestsV2 extends VisualTests
{	
	@BeforeTest
	public void setUp() {
		super.loginUrl = "https://demo.applitools.com/hackathonV2.html";
		super.dashboardUserNameText = By.cssSelector("#logged-user-name-new");
		eyes.setApiKey("MkPu2bfaLsokwn2Yarkp4sOWv107RCGveuXbc4PN105W107v8110");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		eyes.open(driver, "HackathonApp", "Visual AI Tests", new RectangleSize(800, 600));
		eyes.setForceFullPageScreenshot(true);
		eyes.setBatch(batch);
		driver.get(super.loginUrl);
	}
	
	}