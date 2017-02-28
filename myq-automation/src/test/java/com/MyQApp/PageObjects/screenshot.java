package com.MyQApp.PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

public class screenshot {
	public WebDriver driver;

	public void takeScreenshot( String ScreenshotName) {
		try
		{  
			Thread.sleep(3000);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//The below method will save the screen shot in C drive with name "screenshot.png"
			FileUtils.copyFile(scrFile, new File("./target/screenshots/" + ScreenshotName));
		}
		catch (Exception a)
		{
			System.err.println("Failed to capture screenshot:");
			a.printStackTrace();	
		}
	}
	
	public String captureScreen() {
	    String path;
	    try {
	        WebDriver augmentedDriver = new Augmenter().augment(driver);
	        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	        path = "./target/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    return path;
	}
}