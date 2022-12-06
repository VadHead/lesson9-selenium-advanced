package net.absoft;

import net.absoft.components.CheckBox;
import net.absoft.components.DropDown;
import net.absoft.components.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectionControlsTest extends BaseTest {
	
	@BeforeMethod
	public void setUp() {
		driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
	}
	
	@Test(description = "Dropdown Menus test")
	public void dropDownTest() {
		DropDown dropDown = new DropDown(driver);
		
		dropDown.getDropDown1().selectByValue("java");
		dropDown.getDropDown2().selectByValue("testng");
		dropDown.getDropDown3().selectByValue("html");
	}
	
	@Test(description = "Checkboxes test")
	public void checkBoxesTest() {
		CheckBox checkBox = new CheckBox(driver);
		checkBox.deselectAll();
		checkBox.clickOption1().clickOption4();
	}
	
	@Test(description = "Radio Buttons test")
	public void radioButtonsTest() {
		RadioButton radioButton = new RadioButton(driver);
		radioButton.selectOrange();
	}
	
	@Test(description = "Selected & Disabled test")
	public void selectedAndDisableTest() {
		WebElement pumpkinRadioButton = driver.findElement(By.cssSelector("[value='pumpkin']"));
		WebElement cabbageRadioButton = driver.findElement(By.cssSelector("[value='cabbage']"));
		Select fruitSelect = new Select(driver.findElement(By.id("fruit-selects")));
		
		assertTrue(pumpkinRadioButton.isSelected());
		assertFalse(cabbageRadioButton.isEnabled());
		
		assertEquals(fruitSelect.getFirstSelectedOption().getText(), "Grape");
		assertFalse(fruitSelect.getOptions().stream().filter(o -> o.getText().equals("Orange")).findFirst().get()
				.isEnabled());
	}
	
}
