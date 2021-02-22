package com.SDET.AppiumDay1;

import java.awt.Checkbox;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoRegister {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		driver.get("http://demowebshop.tricentis.com/register");
        driver.findElement(By.xpath("//*[@id='gender-male']")).click();
        driver.findElement(By.xpath("//*[@id='FirstName']")).sendKeys("George");
        driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys("Scaria");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("george@gmail.com");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("George");
        driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("George");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//input[@id='register-button']")).click();
        
        
        
	}

}
