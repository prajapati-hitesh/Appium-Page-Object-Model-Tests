package com.myq.chamberlain.Tests.iOS.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by crhoads on 1/28/16.
 */
public class appiumCapabilities {

    AppiumDriver driver;

    @BeforeTest
    public void setUp(){
    System.out.println("Setup Complete");

    }
    @Test (priority = 1)
    public void testAppiumLaunchOnIOSdevice() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        File app = new File(System.getProperty("user.dir")+ "//iOS_app//Chamberlain_testing.ipa");
        caps.setCapability("deviceName", "Christopher's iPhone");
        caps.setCapability("platformVersion", "9.2");
        caps.setCapability("platformName","iOS");
        caps.setCapability("udid", "7f5659bd40099b5f5809fcdb0e7c05b2bcd79ff2");
        //caps.setCapability("bundleId", "com.chamberlain.myq.chamberlain.testing");
        caps.setCapability("app", app.getAbsolutePath());
        //caps.setCapability("noReset", "true");
        //caps.setCapability("fullReset","fullReset");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Thread.sleep(10000);


    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }
}
