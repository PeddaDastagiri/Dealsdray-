package com.qa.Assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Assignment2 {

	@Test
	public void Test2() throws AWTException, InterruptedException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-popup-blocking");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.dealsdray.com/");

		WebElement userName = driver.findElement(By.id("mui-1"));
		userName.sendKeys("prexo.mis@dealsdray.com");
		WebElement password = driver.findElement(By.id("mui-2"));
		password.sendKeys("prexo.mis@dealsdray.com");
		WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));
		loginButton.click();
		WebElement orderButton = driver.findElement(By.cssSelector(".MuiButtonBase-root.has-submenu.compactNavItem.css-46up3a"));
		orderButton.click();
		WebElement ordersButton = driver.findElement(By.xpath("//*[@class='expansion-panel submenu']/div[1]/a"));
		ordersButton.click();
		WebElement addBulkOrder =driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']"));
		addBulkOrder.click();
		WebElement upload = driver.findElement(By.xpath("//*[@id='mui-7']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()",upload);
		String filePath="C:\\Users\\M PEDDA DASTAGIRI\\Downloads\\demo-data.xlsx";
		StringSelection SS=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS, SS);
		Thread.sleep(5);
		
		Robot robo=new Robot();
		robo.setAutoDelay(200);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5);
		WebElement importButton = driver.findElement(By.xpath("//*[text()='Import']"));
		importButton.click();
		WebElement validateData = driver.findElement(By.xpath("//*[text()='Validate Data']"));
		validateData.click();
	
		driver.switchTo().alert().accept();
		
		String ScreenShotPath="D:\\For_Maven\\Automation\\Screenshots";
		String date =new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(date);
		Shutterbug.shootPage(driver, Capture.FULL).withName("ScreenShot" + date).save(ScreenShotPath);
		
		
			
	}

}
