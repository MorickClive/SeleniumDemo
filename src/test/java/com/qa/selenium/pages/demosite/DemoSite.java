package com.qa.selenium.pages.demosite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoSite {
	// ATTRIBUTES
	public static final String URL = "http://thedemosite.co.uk/";
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUserLink;
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginLink;
	
	// pages
	public DemoAddUser addUserPage;
	
	// CONSTRUCTOR
	public DemoSite(WebDriver driver) {
		addUserPage = PageFactory.initElements(driver, DemoAddUser.class);
	}
	
	// METHODS
	public void navUserPage() {
		addUserLink.click();
	}
	
	public void navloginPage() {
		loginLink.click();
	}

}
