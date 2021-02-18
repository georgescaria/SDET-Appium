package com.SDET.AppiumDay8;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemoTabScroll {

	public static AndroidDriver driver;
	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabality = new DesiredCapabilities();
		
		//capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		capabality.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		capabality.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByAccessibilityId("Views").click();
        scrollAndClick("Tabs");
        driver.findElementByAccessibilityId("5. Scrollable").click();
        //scrollAndClick("TAB 14");
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TAB 14\"));")).click();
        Thread.sleep(3000);
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
//                + "resourceId(\"android:id/tabs\"))"
//                + ".setAsHorizontalList().scrollIntoView(new UiSelector().text(\"TAB 8\"))").click();
        
        driver.findElement (MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(" + "\"android:id/tabs\"" +")).setAsHorizontalList().scrollIntoView("+ "new UiSelector().textMatches(" + "\"TAB 8\"" + ").instance(0))"));
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"TAB 8\")")).click();
	}
	
	public static void scrollAndClick(String visibleText) {
  	     
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
  	        
	}

}
