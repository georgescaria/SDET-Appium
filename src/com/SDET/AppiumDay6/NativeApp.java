package com.SDET.AppiumDay6;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NativeApp {

	public static void main(String[] args) throws Exception {

DesiredCapabilities capabality = new DesiredCapabilities();
		
		//capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		capabality.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		capabality.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
		
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"India\")")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Enter name here\")")).sendKeys("George");
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Male\")")).click();
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).click();
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("George");
        Thread.sleep(3000);
       
	}

}
