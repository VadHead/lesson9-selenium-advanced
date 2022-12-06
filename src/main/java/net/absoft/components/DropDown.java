package net.absoft.components;

import net.absoft.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseComponent {
	
	public Select dropDown1 = new Select(driver.findElement(By.id("dropdowm-menu-1")));
	public Select dropDown2 = new Select(driver.findElement(By.id("dropdowm-menu-2")));
	public Select dropDown3 = new Select(driver.findElement(By.id("dropdowm-menu-3")));
	
	public DropDown(WebDriver driver) {
		super(driver);
	}
	
	public Select getDropDown1() {
		return dropDown1;
	}
	
	public Select getDropDown2() {
		return dropDown2;
	}
	
	public Select getDropDown3() {
		return dropDown3;
	}
	
}
