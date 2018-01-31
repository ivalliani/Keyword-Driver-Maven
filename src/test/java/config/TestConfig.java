package config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ExcelDataProvider;
import lib.BrowserAction;
import lib.ClickEvents;
import lib.SelectEvents;
import lib.TypeEvents;
import lib.typeScreenShots;

public class TestConfig {
	
	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;
	@Test
	public static void starTest() throws IOException
	{ ExcelDataProvider excel = new ExcelDataProvider();
	report = new ExtentReports("C:\\Users\\anoosha\\eclipse-workspacePart\\com.KDF.framework.driven\\Reports\\form.html");
	logger =report.startTest("LA Town car Pages");
	int rowcount = excel.rowCount("Loginform");
	for (int i=1; i<=rowcount; i++)
	{
	String description=ExcelDataProvider.getData("LoginForm", i, 0);
	String object_type= ExcelDataProvider.getData("LoginForm", i, 1);
	String Actions= ExcelDataProvider.getData("LoginForm", i, 2);
	String locator_type= ExcelDataProvider.getData("LoginForm", i, 3);
	String locator_value= ExcelDataProvider.getData("LoginForm", i, 4);
	String testData= ExcelDataProvider.getData("LoginForm", i, 5);
	if (object_type.equalsIgnoreCase("browser"))
	{
	if (testData.equalsIgnoreCase("firefox"))
	{
	if (Actions.equalsIgnoreCase("startBrowser"))
	{
	driver= new FirefoxDriver();
	}
	if (Actions.equalsIgnoreCase("closeBrowser"))
	{
	driver.quit();
	}}
	if (testData.equalsIgnoreCase("Chrome"))
	{
	if (Actions.equalsIgnoreCase("startBrowser"))
	{System.setProperty("webdriver.chrome.driver", "C:\\Users\\anoosha\\Downloads\\chromedriver_latest\\chromedriver.exe");
	driver= new ChromeDriver();}
	if (Actions.equalsIgnoreCase("closeBrowser"))                          
	{ driver.quit();}}
	logger.log(LogStatus.INFO, description);	}                      		
	if (object_type.equalsIgnoreCase("OpenAPP"))
	{
	if(Actions.equalsIgnoreCase("navigate"))
	{
	BrowserAction.openApplication(driver, testData);
	logger.log(LogStatus.INFO, description); }}
	if (object_type.equalsIgnoreCase("typeText"))
	{
	String status = TypeEvents.typeAction(driver, locator_type, locator_value, testData);
	if (status.equalsIgnoreCase("pass"))
	{logger.log(LogStatus.INFO, description); }
	else
	{ logger.log(LogStatus.FAIL, description); }}
	if (object_type.equalsIgnoreCase("typeSelect"))
	{
	SelectEvents.typeSelect(driver, locator_type, locator_value, testData);
	logger.log(LogStatus.INFO, description);
	logger.addScreenCapture(typeScreenShots.captureScreenShots(driver, "Request a Quote"));
	}
	if (object_type.equalsIgnoreCase("click"))
	{
	ClickEvents.clickAction(driver, locator_type, locator_value);
	logger.log(LogStatus.INFO, description);
	logger.log(LogStatus.INFO, logger.addScreenCapture(typeScreenShots.captureScreenShots(driver, "Request a Quote")));
	typeScreenShots.captureScreenShots(driver, "The SCreen Shots");
	}
	
	
	
	
	}
	report.endTest(logger);
	report.flush(); }  


}
