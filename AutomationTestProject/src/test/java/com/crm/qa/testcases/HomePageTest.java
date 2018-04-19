package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ReportsPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DealsPage dealsPage;
	CasesPage casesPage;
	ReportsPage reportsPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		dealsPage = new DealsPage();
		casesPage = new CasesPage();
		reportsPage = new ReportsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
		
	}	
	
	@Test(priority=4)
	public void verifyCasesLinkTest() {
		testUtil.switchToFrame();
		casesPage=homePage.clickOnCasesLink();
	}
	
	@Test(priority=5)
	public void verifyReportsLinkTest() {
		testUtil.switchToFrame();
		reportsPage=homePage.clickOnReportsLink();
	}
	@DataProvider
	public void getTestData() {
		
		
	}
	@Test(priority=4)
	public void validateCreateNewDeal() {
		homePage.clickOnNewDealLink();
		dealsPage.createnewDeal("Decor", "Amazon", "John", "100");
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
