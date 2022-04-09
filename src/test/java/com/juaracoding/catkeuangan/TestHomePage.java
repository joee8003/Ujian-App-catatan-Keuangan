package com.juaracoding.catkeuangan;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.catkeuangan.pages.HomePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TestHomePage {

	AndroidDriver<MobileElement> driver;
	HomePage homePage;
	
	
	@BeforeMethod
	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel_2_API_24");
		capabilities.setCapability("uuid", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.0");
		
		capabilities.setCapability("appPackage", "com.chad.financialrecord");
		capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void beforeMethodTest() {
		homePage = new HomePage(driver);
		
	}
	
	@Test
	public void testHomePage() {
		tunggu(5);
		homePage.goToHomePage();
		tunggu(5);
	}
	
	public void testTambahTransaksi() {
	WebElement btnfabMenu = driver.findElement(By.id("com.chad.financialrecord:id/fabMenu"));
	btnfabMenu.click();
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scroll(int startX, int startY, int endX, int endY) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();
	}
}
