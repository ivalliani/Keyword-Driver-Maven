package lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class typeScreenShots {
	
	public static String captureScreenShots(WebDriver driver, String screenshotName) throws IOException
	{ TakesScreenshot ts = (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destination="C:\\Users\\anoosha\\git\\Keyword-Driver-Maven\\ScreenShot"+screenshotName+System.currentTimeMillis()+".png";
	try { FileUtils.copyFile(src, new File(destination));
	} catch (IOException e) {
	System.out.println("Failed to capture Screenshots"+e.getMessage());}
	return destination;}}



