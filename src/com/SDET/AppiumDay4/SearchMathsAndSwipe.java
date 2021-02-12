package com.SDET.AppiumDay4;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SearchMathsAndSwipe {

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws Exception {
		

DesiredCapabilities capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability(MobileCapabilityType.NO_RESET,true);
		
		capabality.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capabality.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_search")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("Math");
        Thread.sleep(20000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        scrollAndClick("Math mechanics of Thai banking crisis");
	}

		public static void scrollAndClick(String visibleText) {
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	        }
	    

}

