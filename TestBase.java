package com.example.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/addressbookv4.1.4";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
		
	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
	protected void openMainPage() {
	    driver.get("http://localhost/addressbookv4.1.4/");
	    assertEquals("Address book", driver.getTitle());
	}

	protected void gotoGroupPage() {
	    driver.findElement(By.linkText("groups")).click();
	    assertEquals("Groups | Address Book", driver.getTitle());
	}
	
	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	    assertEquals("Groups | Address Book", driver.getTitle());
	}
	
	protected void fillGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}
	
	protected void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
	    assertEquals("Groups | Address Book", driver.getTitle());
	}

	
	protected void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	    assertEquals("Groups | Address Book", driver.getTitle());
	}

	
	protected void returnToHometPage() {
		driver.findElement(By.linkText("home page")).click();
	    assertEquals("Address book", driver.getTitle());
	}

	protected void gotoContactPage() {
	    driver.findElement(By.linkText("add new")).click();
	    assertEquals("Address book", driver.getTitle());
	}
	
	protected void initContactCreation() {
	    driver.findElement(By.name("firstname")).clear();
	}


	protected void fillContactForm(GroupContact contact) {
	    driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
	  
	    driver.findElement(By.name("lastname")).clear();
	    driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
	    
	    driver.findElement(By.name("address")).clear();
	    driver.findElement(By.name("address")).sendKeys(contact.address);
	    
	    driver.findElement(By.name("home")).clear();
	    driver.findElement(By.name("home")).sendKeys(contact.home);
	    
	    driver.findElement(By.name("mobile")).clear();
	    driver.findElement(By.name("mobile")).sendKeys(contact.mobile);
	    
	    driver.findElement(By.name("work")).clear();
	    driver.findElement(By.name("work")).sendKeys(contact.work);
	    
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(contact.email1);
	    
	    driver.findElement(By.name("email2")).clear();
	    driver.findElement(By.name("email2")).sendKeys(contact.email2);
	    
	    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.day);
	    
	    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);
	    
	    driver.findElement(By.name("byear")).clear();
	    driver.findElement(By.name("byear")).sendKeys(contact.year);
	           
	    driver.findElement(By.name("address2")).clear();
	    driver.findElement(By.name("address2")).sendKeys(contact.secondaryaddress);
	    
	    driver.findElement(By.name("phone2")).clear();
	    driver.findElement(By.name("phone2")).sendKeys(contact.secondaryhome);
	}

	protected void submitContactCreation() {
	    driver.findElement(By.name("submit")).click();
	    assertEquals("Address book", driver.getTitle());
	}
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}

	

