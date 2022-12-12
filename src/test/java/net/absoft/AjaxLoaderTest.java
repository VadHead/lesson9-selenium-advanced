package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class AjaxLoaderTest extends BaseTest {
	
	private WebElement clickMeButton;
	private WebElement modalFrame;
	private WebElement modalCloseButton;
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
		clickMeButton = driver.findElement(By.cssSelector("[class='btn btn-default btn-lg dropdown-toggle']"));
		modalFrame = driver.findElement(By.id("myModalClick"));
		modalCloseButton = driver.findElement(By.xpath("//button[@class='close']"));
	}
	
	@Test
	public void ajaxTest() {
		new WebDriverWait(driver, Duration.ofSeconds(7)).until(
				ExpectedConditions.visibilityOf(clickMeButton));
		clickMeButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(
				ExpectedConditions.visibilityOf(modalFrame));
		
		assertEquals(modalFrame.getAttribute("class"), "modal fade in");
		
		modalCloseButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(
				ExpectedConditions.invisibilityOf(modalFrame));
		
		assertEquals(modalFrame.getAttribute("class"), "modal fade");
		
	}
	
}
