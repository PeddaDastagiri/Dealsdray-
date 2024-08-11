package com.qa.Assignment;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Assignment1 {

	public  WebDriver driver;
    @Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
//			ChromeOptions option=new ChromeOptions();
//			option.addArguments("--disable-notifications");
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}else
		System.out.println("Broswer Name Invalid");
	}

	@Test
	public void links() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		
		for(int i=0;i<5;i++) {
			WebElement table = driver.findElement(By.id("sitemap"));
			List<WebElement> links = table.findElements(By.tagName("a"));
			String link = links.get(i).getAttribute("href");
			driver.findElement(By.linkText(link)).click();
			String ScreenShotPath="D:\\For_Maven\\Automation\\Screenshots\\";
			String date =new Date().toString().replace(" ", "_").replace(":", "_");
			System.out.println(date);
			Shutterbug.shootPage(driver, Capture.FULL).withName("link_ " +i+"_"+ date).save(ScreenShotPath);
			Thread.sleep(5);
			driver.navigate().back();
			System.out.println("completed " +i);
		}
	}
 
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	


}
