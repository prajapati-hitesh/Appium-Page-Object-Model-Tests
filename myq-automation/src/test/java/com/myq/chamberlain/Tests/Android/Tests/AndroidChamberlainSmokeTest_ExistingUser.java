package com.myq.chamberlain.Tests.Android.Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by crhoads on 2/13/16.
 */
public class AndroidChamberlainSmokeTest_ExistingUser extends WebElements {

    @BeforeMethod
    public void setUp() throws MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();
        File app = new File(System.getProperty("user.dir") + "//Android_app//Chamberlain_3.4_30177.apk");
        caps.setCapability("deviceName", "SAMSUNG-SM-G900A");
        caps.setCapability("platformVersion", "5.1.1");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Wait for password box to be visible before continuing
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((By) password));


        //Enters the username

        username.clear();
        username.sendKeys("ranorextestbench+1@gmail.com");

        //Enters the password

        password.clear();
        password.sendKeys("Test123a");

        //Removes the softkeyboard from display
        driver.navigate().back();

        //Selects the environment picker
        TouchAction longPress = new TouchAction(driver);

        longPress.longPress(envPickerPreProd).perform();


        ppPicker.click();

        //Clicks the login button

        loginButton.click();



        //checks for and clears Help Overlay
        if (helpScreen.isDisplayed())
        {
            helpScreen.click();

        }

        else
        {
            wait.until(ExpectedConditions.presenceOfElementLocated((By) deviceGallery));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) deviceGallery));

    }
    public class TestNGDDT{
        private WebDriver driver;
        private StringBuffer verificationErrors = new StringBuffer();
    }

    public static int randomNumGen(){
    Random rnum = new Random();
    int num1 = rnum.nextInt(1000000000) + 1;
    String num1AsString = Integer.toString(num1);
    System.out.println("Print string num1AsString: " + num1AsString);

        return Integer.parseInt(num1AsString);
    }

    @DataProvider
    public Object[][] testData(){
        return new Object [][]{
                new Object[] {"Chris", "FirstName"},
                new Object[] {"Rhoads", "LasstName"},
                new Object[] {"ranorex+"+ randomNumGen() +"@gmail.com", "emailAddress"},
                new Object[] {"Test123a", "Password"},
                new Object[] {"Test123a", "PasswordReType"},
                new Object[] {"60126", "ZipCode"},
        };
    }



    @Test(dataProvider = "testData")
    public void smokeTest() throws InterruptedException {
        try {
            actuateDevice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //createDelayedRule("WGDO");

    }

    @AfterMethod
    public void tearDown ()throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
