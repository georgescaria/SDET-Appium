package com.SDET.AppiumDay2;

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
import io.appium.java_client.remote.MobileCapabilityType;

public class DataDrivenLogin {

	public static void main(String[] args) throws Exception {

DesiredCapabilities capabality = new DesiredCapabilities();
		
		capabality.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabality.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabality.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabality.setCapability("chromedriverExecutable", "C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\chromedriver.exe");

		AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabality);
		
		
		File file = new File("C:\\Users\\GeorgeScaria\\git\\gSTAX-Appium\\TestData.xlsx");
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
		      String expected = username;
		      Thread.sleep(5000);
		      String actual = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).getText();
		      Assert.assertEquals(expected, actual);
		      driver.findElement(By.xpath("//a[@href='/logout']")).click();
		      Thread.sleep(5000);
		    
		}
		

	}

}
