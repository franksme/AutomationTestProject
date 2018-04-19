package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{

	
	@FindBy(xpath="a//[contains(text(), 'Deals'])")
	WebElement dealsPageLabel;
	
	@FindBy(xpath="a//[contains(text(), 'Title'])")
	WebElement title;
	
	@FindBy(xpath="a//[contains(text(), 'Company'])")
	WebElement company;
	
	@FindBy(xpath="a//[contains(text(), 'Primary Contact'])")
	WebElement primaryContact;
	
	@FindBy(xpath="a//[contains(text(), 'Amount'])")
	WebElement amount;
		
	@FindBy(xpath="//input[@class='button' and @value ='Save'])")
	WebElement saveBtn;
	
		public DealsPage() {
		PageFactory.initElements(driver, this);  
	}
	
	public boolean verifyDealsPageLabel() {
		return dealsPageLabel.isDisplayed();
	}
	
	public void selectDeals(String NewDeal) {
		driver.findElement(By.xpath("//a[contains(text(), 'product1']")).click();
	}
	
	public void createnewDeal(String tit, String comp, String primContact, String amoun) {
		title.sendKeys(tit);
		company.sendKeys(comp);
		primaryContact.sendKeys(primContact);
		amount.sendKeys(amoun);
		saveBtn.click();
		
		
		
	}
	
	
	
	
	
}
