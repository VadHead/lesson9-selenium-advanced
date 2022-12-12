package net.absoft.components;

import net.absoft.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButton extends BaseComponent {
	
	@FindBy(css = "[value=green]")
	private WebElement greenButton;
	
	@FindBy(css = "[value=blue]")
	private WebElement blueButton;
	
	@FindBy(css = "[value=yellow]")
	private  WebElement yellowButton;
	
	@FindBy(css = "[value=orange]")
	private  WebElement orangeButton;
	
	@FindBy(css = "[value=purple]")
	private  WebElement purpleButton;
	
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
