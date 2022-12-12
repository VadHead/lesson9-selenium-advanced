package net.absoft;

import net.absoft.components.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest {
	
	private WebElement calendarIcon;
	WebElement calendarInput;
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/Datepicker/index.html");
		calendarIcon = driver.findElement(By.className("input-group-addon"));
		calendarInput = driver.findElement(By.className("form-control"));
	}
	
	@Test
	public void selectDateTest() {
		calendarIcon.click();
		DatePicker datePicker = new DatePicker(driver);
		
		datePicker
				.selectYear("1991")
				.selectMonth("Aug")
				.selectDay("24");
	}
	
	@Test
	public void selectDateJSTest() {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly');",
				calendarInput);
		calendarInput.clear();
		calendarInput.sendKeys("08-24-1991");
	}
	
}
