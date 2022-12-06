package net.absoft.components;

import net.absoft.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class CheckBox extends BaseComponent {
	
	private final WebElement option1 = driver.findElement(By.cssSelector("[value='option-1']"));
	private final WebElement option2 = driver.findElement(By.cssSelector("[value='option-2']"));
	private final WebElement option3 = driver.findElement(By.cssSelector("[value='option-3']"));
	private final WebElement option4 = driver.findElement(By.cssSelector("[value='option-4']"));
	
	public CheckBox(WebDriver driver) {
		super(driver);
	}
	
	
	public void deselectAll() {
		List<WebElement> webElementsList = Arrays.asList(option1, option2, option3, option4);
		webElementsList.forEach(el -> {
			if (el.isSelected()) {
				el.click();
			}
		});
	}
	
	public CheckBox clickOption1(){
		if (!option1.isSelected()) option1.click();
		return this;
	}
	public CheckBox clickOption2(){
		if (!option2.isSelected()) option2.click();
		return this;
	}
	public CheckBox clickOption3(){
		if (!option3.isSelected()) option3.click();
		return this;
	}
	public CheckBox clickOption4(){
		if (!option4.isSelected()) option4.click();
		return this;
	}
	
}
