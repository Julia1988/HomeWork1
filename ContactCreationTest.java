package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
	
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	
    openMainPage();
    
    gotoContactPage();
    
    initContactCreation();
    
    GroupContact contact = new GroupContact();
    	contact.firstname = "FName";
		contact.lastname = "LName";
		contact.address = "Address";
		contact.home = "Home";
		contact.mobile = "Mobile";
		contact.work = "Work";
		contact.email1 = "E-mail:";
		contact.email2 = "E-mail:";
		contact.day = "1";
		contact.month = "January";
		contact.year = "2015";
		contact.secondaryaddress = "Secondary Address";
		contact.secondaryhome = "Secondary Home";
	    
    fillContactForm(contact);
    
    submitContactCreation();
    
    returnToHometPage();
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	
	openMainPage();
    
    gotoContactPage();
    
    initContactCreation();
    
    fillContactForm(new GroupContact("", "", "", "", "", "", "", "", "-", "-", "", "", ""));
    
    submitContactCreation();
    
    returnToHometPage();
  }
}
