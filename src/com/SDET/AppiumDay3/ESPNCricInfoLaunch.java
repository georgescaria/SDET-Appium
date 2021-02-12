package com.SDET.AppiumDay3;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ESPNCricInfoLaunch {

	public static void main(String[] args) throws Exception {

DesiredCapabilities capabality = new DesiredCapabilities();
		
		//capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		//capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		capabality.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.july.cricinfo");
		capabality.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.july.cricinfo.ui.SplashActivity");
		capabality.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		
		
		
		

	}

}
