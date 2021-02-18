package com.SDET.AppiumDay7;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

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
        Thread.sleep(3000);
//        String expected2 = "geo@gmail.com";
//        Thread.sleep(5000);
//        String actual2 = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText();
//        Assert.assertEquals(expected2, actual2);
        try
        {
        	driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).isDisplayed();
        	System.out.println("Enter correct credentials");
        }
        catch (NoSuchElementException e) {
        	System.out.println("Login successfull by "+driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText());
		}
        	
        
        	
	}

}
