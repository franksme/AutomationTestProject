package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	String sheetName = "deals";
	
	
	
	public DealsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	
	@Test(priority=1)
	public void verifyDealsPageLabel() {
		Assert.assertTrue(dealsPage.verifyDealsPageLabel(), "deals label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleDealsTest() {
		dealsPage.selectDeals("product1");
	}
	
	
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCRMData")
	public void validateCreateNewDeal(String title, String company, String primaryContact, String amount) {
		homePage.clickOnNewDealLink();
		//dealsPage.createnewDeal("Decor", "Amazon", "John", "100");
		dealsPage.createnewDeal(title, company, primaryContact, amount);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	
	}
}

