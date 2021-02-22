package com.SDET.AppiumDay1;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoWebShop {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		driver.get("http://demowebshop.tricentis.com/login");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("geo@gmail.com");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("George");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}

}
