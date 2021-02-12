package com.SDET.AppiumDay3;

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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KhanLaunch {

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws Exception {
		

DesiredCapabilities capabality = new DesiredCapabilities();
		
		//capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		//capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");
		//capabality.setCapability(MobileCapabilityType.NO_RESET,true);
		
		capabality.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		capabality.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
		//capabality.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Dismiss\")")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		scrollAndClick("Sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        scrollAndClick("Continue with Facebook");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("abc@gmail.com");
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Facebook password\")")).sendKeys("pass");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.hideKeyboard();
        driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log In\")")).click();
		
	}

		public static void scrollAndClick(String visibleText) {
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	        }
	    

}

