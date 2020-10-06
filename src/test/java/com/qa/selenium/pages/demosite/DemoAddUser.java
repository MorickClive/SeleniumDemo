package com.qa.selenium.pages.demosite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddUser {

	// ATTRIBUTES
	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
	WebElement saveUser;

	// CONSTRUCTOR
	public DemoAddUser() {
	}

	// METHODS
	public void createUser(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		saveUser.click();
	}
}
