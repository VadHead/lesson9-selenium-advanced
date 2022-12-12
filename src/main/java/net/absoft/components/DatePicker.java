package net.absoft.components;

import net.absoft.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePicker extends BaseComponent {
	
	private final String yearPicker = "//div[@class='datepicker-years']//span[text()='%s']";
	private final String monthPicker = "//div[@class='datepicker-months']//span[text()='%s']";
	private final String dayPicker = "//div[@class='datepicker-days']//td[text()='%s']";
	
	private final WebElement datePickerDate = driver.findElement(
			By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
	private final WebElement datePickerYear = driver.findElement(
			By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']"));
	private final WebElement datePickerYearsPrev = driver.findElement(
			By.xpath("//div[@class='datepicker-years']//th[@class='prev']"));
	private final WebElement datePickerYearsNext = driver.findElement(
			By.xpath("//div[@class='datepicker-years']//th[@class='next']"));
	
	public DatePicker(WebDriver driver) {
		super(driver);
	}
	
	public DatePicker selectYear(String year) {
		datePickerDate.click();
		datePickerYear.click();
		List<WebElement> yearsList;
		boolean findYear = false;
		while (!findYear) {
			yearsList = driver.findElements(By.xpath("//div[@class='datepicker-years']//span"));
			for (WebElement y : yearsList) {
				if (y.getText().equals(year)) {
					findYear = true;
					break;
				}
			}
			datePickerYearsPrev.click();
		}
		datePickerYearsNext.click();
		driver.findElement(By.xpath(String.format(yearPicker, year))).click();
		return this;
	}
	
	public DatePicker selectMonth(String month) {
		driver.findElement(By.xpath(String.format(monthPicker, month))).click();
		return this;
	}
	
	public DatePicker selectDay(String day) {
		driver.findElement(By.xpath(String.format(dayPicker, day))).click();
		return this;
	}
	
}
