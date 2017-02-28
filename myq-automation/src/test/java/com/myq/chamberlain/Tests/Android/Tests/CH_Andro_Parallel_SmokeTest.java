package com.myq.chamberlain.Tests.Android.Tests;

import com.MyQApp.PageObjects.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by crhoads on 1/20/2017.
 */
public class CH_Andro_Parallel_SmokeTest {

    //SauceREST r = new SauceREST("Crhoads1024", "38d73031-58f8-4874-80bf-449635bfd13b");
    //String tunnels = r.getTunnels();

    AndroidDriver driver;
    TouchAction action = new TouchAction(driver);

    //String appUrl = "https://bitbucket.org/crhoads/myq-automation/src/451b2a33e2b7ac62b48b5ea784b40a7ac2344809/app/Chamberlain_3.3.1.apk";
    //public static final String USERNAME = "crhoads";
    //public static final String ACCESSKEY = "d4dfe90e-a6ed-42b4-bdf3-dc01ad58844e";
    //public static final String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeTest
   /* //****************************************SauceLabs Remote Webdriver Config**************************************
    public void SauceLabsSetup() throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.5.3");
        caps.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "");
        caps.setCapability("app", "sauce-storage:Chamberlain_3.3.1.apk");
        caps.setCapability("platformVersion", "4.4");
        caps.setCapability("platformName", "Android");

        /*
        DesiredCapabilities caps = DesiredCapabilities.android();
    caps.setCapability("appiumVersion", "1.5.3");
    caps.setCapability("deviceName","Samsung Galaxy S7 Device");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("browserName", "");
    caps.setCapability("app", appUrl);
    caps.setCapability("platformVersion","6.0");
    caps.setCapability("platformName","Android");

        driver = new AndroidDriver(new URL("https://crhoads:d4dfe90e-a6ed-42b4-bdf3-dc01ad58844e@ondemand.saucelabs.com:443/wd/hub"), caps);
    }
*/


    //***************************************Local Machine Config********************************************************
    public void PP_Chamberlain_LoginSetUp() throws MalformedURLException {



        DesiredCapabilities caps = new DesiredCapabilities();
        File app = new File(System.getProperty("user.dir") + "//app//Chamberlain_3.73.apk");
        //caps.setCapability("deviceName", "SAMSUNG-SM-G900A"); //Galaxy S5
        //caps.setCapability("platformVersion", "5.1.1"); //Galaxy S5

        caps.setCapability("deviceName", "SAMSUNG-SM-G935A"); //Galaxy S7 Edge
        caps.setCapability("platformVersion", "6.0.1"); //Galaxy S7 Edge

        caps.setCapability("platformName", "Android");
        caps.setCapability("app", app.getAbsolutePath());
        //This will pull the apk file from where it resides on the hard drive


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);




    }
    //   *******************************************************************************************************************

    @Test
    public void existingUserLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.existingUserSignsInToPreProd(driver);

    }

    @Test
    public void loginExistingUserActuateDeviceTest() {
        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);

        login.existingUserSignsInToPreProd(driver);

        devicePageList.actuateAndCheckforChangedDeviceState(driver);
    }

    @Test
    public void loginAddImmediateRuleTest() {
        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);
        FlyOutMenu flyOutmenu = new FlyOutMenu(driver);
        AddRuleChooseDevicePage selectDevice = new AddRuleChooseDevicePage(driver);
        RuleCreationPage createRules = new RuleCreationPage(driver);
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);

        login.existingUserSignsInToPreProd(driver);
        devicePageList.accessFlyoutMenu();
        flyOutmenu.clickRuleOptionOnPlacesFlyoutMenu(driver);
        try {
            Thread.sleep(35000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
        selectDevice.clickWGDO(driver);
        createRules.createImmediateRule(driver);
    }

    @Test
    public void loginAddDelayedRuleTest() {
        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);
        FlyOutMenu flyOutmenu = new FlyOutMenu(driver);
        AddRuleChooseDevicePage selectDevice = new AddRuleChooseDevicePage(driver);
        RuleCreationPage createRules = new RuleCreationPage(driver);
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);

        login.existingUserSignsInToPreProd(driver);
        devicePageList.accessFlyoutMenu();
        flyOutmenu.clickRuleOptionOnPlacesFlyoutMenu(driver);
        ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
        selectDevice.clickWGDO(driver);
        createRules.createDelayedRule(driver);
    }

    @Test
    public void loginAddScheduledRuleTest() {
        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);
        FlyOutMenu flyOutmenu = new FlyOutMenu(driver);
        AddRuleChooseDevicePage selectDevice = new AddRuleChooseDevicePage(driver);
        RuleCreationPage createRules = new RuleCreationPage(driver);
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);

        login.existingUserSignsInToPreProd(driver);
        devicePageList.accessFlyoutMenu();
        flyOutmenu.clickRuleOptionOnPlacesFlyoutMenu(driver);
        ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
        selectDevice.clickWGDO(driver);
        createRules.createScheduledRule(driver);
    }

    @Test
    public void loginExistingUserTriggerPushAlertsTest() {
        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);

        login.existingUserSignsInToPreProd(driver);

        devicePageList.actuateAndCheckforChangedDeviceState(driver);


    }

/*
    @Test
    public void deleteImmediateRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);


    }

    @Test
    public void deleteScheduledRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);


    }
    @Test
    public void deleteDelayedRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);



    }
*/
    @AfterTest
    public void tearDown() {
        driver.closeApp();
        driver.quit();
    }

}