package com.gSTAX.Appium.Setup;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Setup {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\GeorgeScaria\\Desktop\\Apkfiles\\playstore.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
	}

}
