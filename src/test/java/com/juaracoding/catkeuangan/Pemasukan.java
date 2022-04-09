package com.juaracoding.catkeuangan;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Pemasukan {

	AndroidDriver<MobileElement> driver;
	public Pemasukan(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	
	}
	By btnfabMenu = By.id("com.chad.financialrecord:id/fabMenu");
	By btnPengeluaran = By.id("com.chad.financialrecord:id/btnIncome");
	By inputtvDate = By.id("com.chad.financialrecord:id/tvDate");
	By inputDate = By.xpath("//android.view.View[@content-desc=\"10 April 2022\"]");
	By inputtvName = By.id("com.chad.financialrecord:id/tvName");
	By inputJumlah = By.xpath("//android.widget.EditText[contains(@text, 'Jumlah')]");
	By inputKeterangan  = By.xpath("//android.widget.EditText[contains(@text, 'Keterangan']");
	By btnSave = By.id("com.chad.financialrecord:id/btSave");
	By type2 = By.id("com.chad.financialrecord:id/elTransaction");
	
	public void addNewContact(String tvDate, String tvName, String Jumlah, String Keterangan) {
		driver.findElementByAccessibilityId("fab Menu").click();
		tunggu(1);
		driver.findElement(btnfabMenu).click();
		tunggu(1);
		driver.findElementByAccessibilityId("btnIncome").click();
		tunggu(1);
		driver.findElement(inputtvDate).sendKeys(tvDate);
		driver.findElement(inputtvName).sendKeys(tvName);
		driver.findElement(inputJumlah).sendKeys(Jumlah);
		driver.findElement(inputKeterangan).sendKeys(Keterangan);
		driver.findElementByAccessibilityId("Save").click();
		
		
	}
	
	public void tunggu(int detik) {
		try {
			Thread.sleep(detik*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scroll(int startX, int startY, int endX, int endY) {
		AndroidTouchAction touchAction = new AndroidTouchAction(driver);
		touchAction.longPress(PointOption.point(startX, startY))
		.moveTo(PointOption.point(endX, endY))
		.release().perform();
	}
}

