package com.example.tests;

public class GroupContact {
	
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email1;
	public String email2;
	public String day;
	public String month;
	public String year;
	public String secondaryaddress;
	public String secondaryhome;

	public GroupContact() {
	}
	public GroupContact(String firstname, String lastname, String address, String home, String mobile, String work,
			String email1, String email2, String day, String month, String year, String secondaryaddress,
			String secondaryhome) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.day = day;
		this.month = month;
		this.year = year;
		this.secondaryaddress = secondaryaddress;
		this.secondaryhome = secondaryhome;
	}
}