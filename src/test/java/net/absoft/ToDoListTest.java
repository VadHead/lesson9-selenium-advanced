package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ToDoListTest extends BaseTest {
	
	private final String taskNameToAdd = "Bavovna!";
	private final String taskNameToRemove = " Practice magic";
	private WebElement addTaskInput;
	private final String searchTaskXPath = "//ul//li[contains(text(),'%s')]";
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
		addTaskInput = driver.findElement(By.cssSelector("[placeholder='Add new todo']"));
	}
	
	@Test
	public void addTaskTest() {
		addTaskInput.sendKeys(taskNameToAdd);
		addTaskInput.sendKeys(Keys.ENTER);
		WebElement taskListItem = driver.findElement(By.xpath(String.format(searchTaskXPath, taskNameToAdd)));
		assertEquals(taskListItem.getText().stripLeading(), taskNameToAdd);
	}
	
	@Test
	public void removeTaskTest() {
		WebElement taskListItem = driver.findElement(By.xpath(String.format(searchTaskXPath, taskNameToRemove)));
		WebElement trashListItem = driver.findElement(
				By.xpath(String.format(searchTaskXPath + "//i[@class='fa fa-trash']", taskNameToRemove)));
		new Actions(driver)
				.moveToElement(taskListItem)
				.moveToElement(trashListItem)
				.click().perform();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(
				ExpectedConditions.invisibilityOf(taskListItem));
	}
	
}
