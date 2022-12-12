package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPortalTest extends BaseTest {
	
	private WebElement userNameInput;
	private WebElement loginButton;
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
		userNameInput = driver.findElement(By.id("text"));
		loginButton = driver.findElement(By.id("login-button"));
	}
	
	@Test
	public void loginWithoutPasswordTest() {
		userNameInput.sendKeys("user");
		loginButton.click();
	
		assertEquals(driver.switchTo().alert().getText(), "validation failed");
	}
	
}
