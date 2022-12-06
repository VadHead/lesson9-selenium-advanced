package net.absoft.components;

import net.absoft.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton extends BaseComponent {
	
	private final WebElement greenButton = driver.findElement(By.cssSelector("[value=green]"));
	private final WebElement blueButton = driver.findElement(By.cssSelector("[value=blue]"));
	private final WebElement yellowButton = driver.findElement(By.cssSelector("[value=yellow]"));
	private final WebElement orangeButton = driver.findElement(By.cssSelector("[value=orange]"));
	private final WebElement purpleButton = driver.findElement(By.cssSelector("[value=purple]"));
	
	public RadioButton(WebDriver driver) {
		super(driver);
	}
	
	public RadioButton selectGreen() {
		greenButton.click();
		return this;
	}
	
	public RadioButton selectBlue() {
		blueButton.click();
		return this;
	}
	
	public RadioButton selectYellow() {
		yellowButton.click();
		return this;
	}
	
	public RadioButton selectOrange() {
		orangeButton.click();
		return this;
	}
	
	public RadioButton selectPurple() {
		purpleButton.click();
		return this;
	}
	
}
