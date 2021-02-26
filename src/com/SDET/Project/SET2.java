package com.SDET.Project;

import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class SET2 {
	
	AndroidDriver driver;
	DesiredCapabilities capabality = new DesiredCapabilities();
	String expected, actual;
	
  @Test
  public void f() throws Exception {
	 
      File file = new File("C:\\Users\\GeorgeScaria\\Testing\\SDET-Appium\\TestData.xlsx");
		FileInputStream fin = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rc = sheet.getLastRowNum();
		
		for(int i=0;i<=rc;i++)
		{	  driver.get("http://demowebshop.tricentis.com/login");
			  
			  String username = sheet.getRow(i).getCell(0).getStringCellValue();
			  String password = sheet.getRow(i).getCell(1).getStringCellValue();
			  driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
		      driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		      driver.hideKeyboard();
		      driver.findElement(By.xpath("//input[@value='Log in']")).click();
		      expected = username;
		      Thread.sleep(5000);
		      actual = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText();
		      Assert.assertEquals(expected, actual);
		      
		      
		      scrollToElement("//div[@data-productid='31']");
		      driver.findElement(By.xpath("//div[@data-productid='31']")).click();
		      Thread.sleep(5000);
		      scrollToElement("(//input[@value='Add to cart'])[1]");
		      driver.findElement(By.xpath("(//input[@value='Add to cart'])[1]")).click();
		      Thread.sleep(5000);
		      driver.findElement(By.xpath("//li[@id='topcartlink']")).click();
		      Thread.sleep(5000);
		      scrollToElement("//div[@class='checkout-buttons']");
		    
		      driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		      driver.findElement(By.xpath("//div[@class='checkout-buttons']")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("(//input[@class='button-1 new-address-next-step-button'])[1]");
		      driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("(//input[@class='button-1 new-address-next-step-button'])[2]");
		      driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("//input[@class='button-1 shipping-method-next-step-button']");
		      driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("//input[@class='button-1 payment-method-next-step-button']");
		      driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("//input[@class='button-1 payment-info-next-step-button']");
		      driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
		      
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      scrollToElement("//input[@class='button-1 confirm-order-next-step-button']");
		      driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();
		      
		      actual = driver.findElement(By.xpath("//div[@class='title']")).getText();
		      expected = "Your order has been successfully processed!";
		      Assert.assertEquals(actual, expected);
		      
		      driver.findElement(By.xpath("//a[@href='/logout']")).click();
		      Thread.sleep(5000);
		    
		}
    
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	    capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\Testing\\SDET-Appium\\chromedriver.exe");
		driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
     
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