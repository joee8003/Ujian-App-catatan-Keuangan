package com.juaracoding.catkeuangan.pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {


	AndroidDriver<MobileElement> driver;
	
	public HomePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	By pilihAllow = By.xpath("//android.widget.TextView[contains(@text, 'ALLOW')]");
	By pilihTutup = By.xpath("//android.widget.TextView[contains(@text, 'TUTUP')]");
	
	public void goToHomePage() {
		driver.findElement(pilihAllow).click();
		driver.findElement(pilihTutup).click();
		tunggu(5);
	}
	
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
