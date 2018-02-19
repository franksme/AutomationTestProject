package SeleniumWebDriverTestSamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class DropdowninTestNG

{
	public static WebDriver driver;
	
	@Test
	public void selectDropDownValues() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		//Let's select May
		WebElement month_dropdown=driver.findElement(By.id("month"));
		Select month_ddown=new Select(month_dropdown);
		month_ddown.selectByIndex(5);
		
		Thread.sleep(2000);
		
		//Select day #5
		WebElement day_dropdown=driver.findElement(By.id("day"));
		Select day_ddown=new Select(day_dropdown);
		day_ddown.selectByValue("5");
		
		Thread.sleep(2000);
		
		//Selects year 1985
		WebElement year_dropdown=driver.findElement(By.id("year"));
		Select year_ydown=new Select(year_dropdown);
		year_ydown.selectByValue("1985");
		
		Thread.sleep(4000);
		driver.quit();
		
	}
}
