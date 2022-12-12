package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonTest extends BaseTest {
	
	private WebElement buttonWeb;
	private WebElement buttonJS;
	private WebElement buttonAction;
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
		buttonWeb = driver.findElement(By.id("button1"));
		buttonJS = driver.findElement(By.id("button2"));
		buttonAction = driver.findElement(By.id("button3"));
	}
	
	@Test
	public void buttonWebElementClick() {
		WebElement modalClick = driver.findElement(By.id("myModalClick"));
		
		buttonWeb.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(
				ExpectedConditions.visibilityOf(modalClick));
	}
	
	@Test
	public void buttonJSClick() {
		WebElement modalJSClick = driver.findElement(By.id("myModalJSClick"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonJS);
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(
				ExpectedConditions.visibilityOf(modalJSClick));
	}
	
	@Test
	public void buttonActionClick() {
		WebElement modalMoveClick = driver.findElement(By.id("myModalMoveClick"));
		
		new Actions(driver).moveToElement(buttonAction).perform();
		new Actions(driver).click(buttonAction).perform();
		
		new WebDriverWait(driver, Duration.ofSeconds(1)).until(
				ExpectedConditions.visibilityOf(modalMoveClick));
	}
	
}
