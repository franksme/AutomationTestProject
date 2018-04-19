package com.crm.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(), 'User: Frank F')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="a//[contains(tests(), 'Deals'])")
	WebElement dealsLink;
	
	@FindBy(xpath="a//[contains(tests(), 'New Deal'])")
	WebElement newDealLink;
	
	@FindBy(xpath="a//[contains(tests(), 'Cases'])")
	WebElement casesLink;
	
	@FindBy(xpath="a//[contains(tests(), 'Reports'])")
	WebElement reportsLink;
	
	//Initializing the Page Objects:
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
		
	}
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}	
	
	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
	public ReportsPage clickOnReportsLink() {
		reportsLink.click();
		return new ReportsPage();
	}
	
	public void clickOnNewDealLink() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDealLink.click();
		
		
	}

	
	}
	
	
	
	
		
	
	
	

	