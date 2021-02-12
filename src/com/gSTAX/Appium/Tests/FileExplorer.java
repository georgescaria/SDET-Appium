package com.gSTAX.Appium.Tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FileExplorer {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");

		dc.setCapability("appPackage", "com.estrongs.android.pop");
		dc.setCapability("appActivity", "com.estrongs.android.pop.view.FileExplorerActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(10000);
		
		
		WebElement parent = driver.findElement(By.id("com.estrongs.android.pop:id/exlayout"));
		WebElement children  = parent.findElement(By.xpath("//android.widget.LinearLayout[4]"));
		children.click();
		Thread.sleep(10000);
		
//		driver.findElementByXPath("//").click();
//		driver.findElementById("com.google.android.calculator:id/op_mul").click();
//		driver.findElementById("com.google.android.calculator:id/digit_3").click();
//		driver.findElementById("com.google.android.calculator:id/eq").click();
//		String result = driver.findElementById("com.google.android.calculator:id/result_final").getText();
		
		//System.out.println(result);
		driver.quit();
		
		
	}

}
