package com.SDET.AppiumDay1;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginValidation {
	
	AndroidDriver driver;
	DesiredCapabilities capabality = new DesiredCapabilities();
  @Test
  public void f() throws Exception {
	  driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
	  driver.get("http://demowebshop.tricentis.com/login");
	  driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("geo@gmail.com");
      driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("George");
      driver.hideKeyboard();
      driver.findElement(By.xpath("//input[@value='Log in']")).click();
      String expected = "geo@gmail.com";
      Thread.sleep(5000);
      String actual = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText();
      Assert.assertEquals(expected, actual);
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	    capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		
     
  }

  @AfterClass
  public void afterClass() {
  }

}
