package com.myq.chamberlain.Tests.Android.Tests;

/**
 * Created by crhoads on 3/3/16.
 */

import com.MyQApp.PageObjects.*;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidSmokeTest_CH {

    //SauceREST r = new SauceREST("Crhoads1024", "38d73031-58f8-4874-80bf-449635bfd13b");
    //String tunnels = r.getTunnels();

    AndroidDriver driver;
    TouchAction action = new TouchAction(driver);

    //String appUrl = "https://bitbucket.org/crhoads/myq-automation/src/451b2a33e2b7ac62b48b5ea784b40a7ac2344809/app/Chamberlain_3.3.1.apk";
    //public static final String USERNAME = "crhoads";
    //public static final String ACCESSKEY = "d4dfe90e-a6ed-42b4-bdf3-dc01ad58844e";
    //public static final String URL = "https://" + USERNAME + ":" + ACCESSKEY + "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeTest

   /*
   //****************************************SauceLabs Remote Webdriver Config**************************************
    public void SauceLabsSetup() throws MalformedURLException {

        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.5.3");
        caps.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "");
        caps.setCapability("app", "sauce-storage:Chamberlain_3.3.1.apk");
        caps.setCapability("platformVersion", "4.4");
        caps.setCapability("platformName", "Android");


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
        //ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
        //selectDevice.clickWGDO(driver);
        //createRules.createImmediateRule(driver);
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

    @Test
    public void loginActuateDeviceCreateRuleForDevice(){


        LoginPage login = new LoginPage(driver);
        PlacesPage devicePageList = new PlacesPage(driver);
        FlyOutMenu flyOutmenu = new FlyOutMenu(driver);
        AddRuleChooseDevicePage selectDevice = new AddRuleChooseDevicePage(driver);
        RuleCreationPage createRules = new RuleCreationPage(driver);
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);


        login.existingUserSignsInToPreProd(driver);

        devicePageList.actuateAndCheckforChangedDeviceState(driver);
        devicePageList.accessFlyoutMenu();
        flyOutmenu.clickRuleOptionOnPlacesFlyoutMenu(driver);
        ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();

        //Gets to here - displays devices to add rule for and dies - Its not seeing the WGDO option for some reason.
        selectDevice.clickWGDO(driver);
        createRules.createDelayedRule(driver);

        selectDevice.clickWGDO(driver);
        createRules.createImmediateRule(driver);

        selectDevice.clickWGDO(driver);
        createRules.createScheduledRule(driver);

        devicePageList.accessFlyoutMenu();
        flyOutmenu.clickPlacesOptionOnPlacesFlyoutMenu(driver);
        devicePageList.actuateAndCheckforChangedDeviceStateWithTryCatchForPopUps();




    }


    @Test (priority = 1)
    public void smokeTest(){
        PlacesPage devicePageList = new PlacesPage(driver);
        LoginPage login = new LoginPage(driver);
        FlyOutMenu flyOutMenu = new FlyOutMenu(driver);
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
        RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);


        login.existingUserSignsInToPreProd(driver);

        devicePageList.actuateAndCheckforChangedDeviceState(driver);
        devicePageList.accessFlyoutMenu();
        flyOutMenu.clickRuleOptionOnPlacesFlyoutMenu(driver);

        ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
        ruleCreationPage.createImmediateRule(driver);
        ruleCreationPage.createDelayedRule(driver);
        ruleCreationPage.createScheduledRule(driver);

    }

    @Test (priority = 2)
    public void actuateDevice(){
        smokeTest();
        PlacesPage devicePageList = new PlacesPage(driver);
        devicePageList.actuateAndCheckforChangedDeviceState(driver);

    }







    @Test (priority = 5)
    public void deleteImmediateRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);

        //clicks the menu button to expose rules
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")));

        //clicks rules menu
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")).click();

        //selects rule by text
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();

        //clicks the trash can button
        driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/delete_rule")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));

        //clicks ok button to delete rule
        driver.findElement(By.id("android:id/button1")).click();





    }

    @Test (priority = 6)
    public void deleteScheduledRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);

        //clicks the menu button to expose rules
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")));

        //clicks rules menu
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")).click();
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();

        //clicks the trash can button
        driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/delete_rule")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));

        //clicks ok button to delete rule
        driver.findElement(By.id("android:id/button1")).click();

    }
    @Test (priority = 7)
    public void deleteDelayedRule(){
        WebDriverWait wait = new WebDriverWait(driver,100);

        //clicks the menu button to expose rules
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")));

        //clicks rules menu
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")).click();

        //selects Delayed Rule for deletion
        driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[3]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();

        //clicks the trash can button
        driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/delete_rule")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));

        //clicks ok button to delete rule
        driver.findElement(By.id("android:id/button1")).click();


    }

    @AfterTest
    public void tearDown() {
        driver.closeApp();
        driver.quit();
    }


}
