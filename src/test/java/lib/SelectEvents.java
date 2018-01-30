package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectEvents {
	
	public static String typeSelect(WebDriver driver, String locatorType, String locatorValue, String data)
	{ try { if(locatorType.equalsIgnoreCase("id"))
	{ Select selectCountry = new Select (driver.findElement(By.xpath(locatorValue)));
	selectCountry.selectByValue(data); }
	else if(locatorType.equalsIgnoreCase("xpath"))
	{ Select selectCountry = new Select (driver.findElement(By.xpath(locatorValue)));
	selectCountry.selectByValue(data);}
	return "pass";} catch (Exception e) { return e.getMessage();}}}



