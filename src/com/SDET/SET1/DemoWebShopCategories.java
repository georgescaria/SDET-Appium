package com.SDET.AppiumDay1;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DemoWebShopCategories {

	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		driver.get("http://demowebshop.tricentis.com");
        driver.findElement(By.xpath("//div[@id='mob-menu-button']")).click();
        driver.findElement(By.xpath("//a[@href='/computers']//following-sibling::span")).click();
        driver.findElement(By.xpath("(//a[@href='/desktops'])[2]")).click();
        //driver.findElement(By.xpath("//input[@value='Log in']")).click();
        Thread.sleep(3000);
        WebElement drop=driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Select sel = new Select(drop);
        sel.selectByVisibleText("Created on");
	}

}
