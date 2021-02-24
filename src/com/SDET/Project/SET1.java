package com.SDET.Project;

import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SET1 {
	
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
      waitUntilDisplayed("(//a[@href='/customer/info'])[1]");
      String actual = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText();
      Assert.assertEquals(expected, actual);
      
      
      //scrollToElement("//a[text()='14.1-inch Laptop']");
      scrollToElement("//div[@data-productid='31']");
    
      
      
      
      Thread.sleep(5000);
      driver.findElement(By.xpath("//div[@data-productid='31']")).click();
      Thread.sleep(5000);
      scrollToElement("(//input[@value='Add to cart'])[1]");
      driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("//li[@id='topcartlink']")).click();
      Thread.sleep(5000);
      expected = "14.1-inch Laptop";
      actual = driver.findElement(By.xpath("//a[@class='product-name']")).getText();
      Assert.assertEquals(expected, actual);
    
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	    capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\Testing\\SDET-Appium\\chromedriver.exe");

		
     
  }

  @AfterClass
  public void afterClass() {
  }
  
  public void waitUntilDisplayed(String xpath)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 15);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
  
  public void scrollToElement(String xpath) throws InterruptedException
  {
		  
	  WebElement element = driver.findElement(By.xpath(xpath));
	  //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  Actions action = new Actions(driver);
      action.moveToElement(element);
	  Thread.sleep(500); 
  }

}