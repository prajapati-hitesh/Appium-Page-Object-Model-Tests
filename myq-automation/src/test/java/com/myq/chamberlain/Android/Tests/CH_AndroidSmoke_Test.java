package com.myq.chamberlain.Android.Tests;

import com.MyQApp.PageObjects.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by crhoads on 5/11/16.
 */
public class CH_AndroidSmoke_Test {




        private AndroidDriver driver;
        public int ruleCount = 0;


        @BeforeTest
        public void PP_Chamberlain_LoginSetUp() throws MalformedURLException {


            DesiredCapabilities caps = new DesiredCapabilities();
            File app = new File(System.getProperty("user.dir") + "//app//Chamberlain_3.5.7.apk");
            caps.setCapability("deviceName", "SAMSUNG-SM-G935A");
            caps.setCapability("platformVersion", "6.0.1");
            caps.setCapability("platformName", "Android");
            caps.setCapability("app", app.getAbsolutePath());
            //This will pull the apk file from where it resides on the hard drive


            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        }

        @Test(priority = 1)
        public void existingUserLogsIntoPP() {
            LoginPage login = new LoginPage(driver);

            login.existingUserSignsInToPreProd(driver);
        }

        @Test (priority = 2)
        public void actuateDeviceAndVerifyStateChange() {
            PlacesPage placesPage = new PlacesPage(driver);
            //placesPage.ScrollandFindElement("GATE");

            placesPage.actuateAndCheckforChangedDeviceState(driver);
        }

        @Test(priority = 3)
        public void createWGDORules(){

            PlacesPage placesPage = new PlacesPage(driver);

            FlyOutMenu flyOutMenu = new FlyOutMenu(driver);
            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
            RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);
            AddRuleChooseDevicePage addRuleChooseDevicePage = new AddRuleChooseDevicePage(driver);


            placesPage.accessFlyoutMenu();
            flyOutMenu.clickRuleOptionOnPlacesFlyoutMenu(driver);


            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickWGDO(driver);
            ruleCreationPage.createDelayedRule(driver);


            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickWGDO(driver);
            ruleCreationPage.createScheduledRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickWGDO(driver);
            ruleCreationPage.createImmediateRule(driver);
        }


        @Test (priority = 4)
        public void createCDORules() {

            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
            RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);
            AddRuleChooseDevicePage addRuleChooseDevicePage = new AddRuleChooseDevicePage(driver);


            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickCDO(driver);
            ruleCreationPage.createDelayedRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickCDO(driver);
            ruleCreationPage.createScheduledRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickCDO(driver);
            ruleCreationPage.createImmediateRule(driver);

        }

        @Test (priority = 5)
        public void createGATERules() {

            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
            RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);
            AddRuleChooseDevicePage addRuleChooseDevicePage = new AddRuleChooseDevicePage(driver);


            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickGATE(driver);
            ruleCreationPage.createDelayedRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickGATE(driver);
            ruleCreationPage.createScheduledRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickGATE(driver);
            ruleCreationPage.createImmediateRule(driver);

        }

        @Test (priority = 6)
        public void createLightRules(){

            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
            RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);
            AddRuleChooseDevicePage addRuleChooseDevicePage = new AddRuleChooseDevicePage(driver);


            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickLIGHT(driver);
            ruleCreationPage.createDelayedRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickLIGHT(driver);
            ruleCreationPage.createScheduledRule(driver);

            ruleDisplayPage.clickAddRuleIconToChooseDeviceToCreateRuleFor();
            addRuleChooseDevicePage.clickLIGHT(driver);
            ruleCreationPage.createImmediateRule(driver);
        }


        @Test (priority = 7)
        public void checkHistoryExists(){
            PlacesPage placesPage = new PlacesPage(driver);

            FlyOutMenu flyOutMenu = new FlyOutMenu(driver);
            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);

            HistoryPage historyPage = new HistoryPage(driver);



            //Navigates to places to actuate device to generate history.
            ruleDisplayPage.accessFlyoutMenu();

            flyOutMenu.clickPlacesOptionOnPlacesFlyoutMenu(driver);
            placesPage.actuateAndCheckforChangedDeviceState(driver);

            placesPage.accessFlyoutMenu();

            //HISTORY VERIFICATIONS AND RULE DELETIONS WILL BEGIN HERE
            flyOutMenu.clickHistoryOptionOnPlacesFlyoutMenu(driver);
            historyPage.validateHistoryExists();
        }


        @Test (priority = 8)
        public void deleteHistory(){

            HistoryPage historyPage = new HistoryPage(driver);

            historyPage.deleteHistory();

        }

        @Test (priority = 9)
        public void deleteRules() {
            PlacesPage placesPage = new PlacesPage(driver);

            FlyOutMenu flyOutMenu = new FlyOutMenu(driver);
            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);


            HistoryPage historyPage = new HistoryPage(driver);


            historyPage.accessFlyOutMenu();


            flyOutMenu.clickRuleOptionOnPlacesFlyoutMenu(driver);


            placesPage.accessFlyoutMenu();
            flyOutMenu.clickRuleOptionOnPlacesFlyoutMenu(driver);


            ruleDisplayPage.deleteAllRules();

            ruleDisplayPage.accessFlyoutMenu();
            flyOutMenu.clickAccountOptionOnPlacesFlyoutMenu(driver);

        }

        @Test (priority = 10)
        public void logOutUser() {

            AccountPage accountPage = new AccountPage(driver);


            accountPage.userLogsOut();

        }




        @AfterTest
        public void tearDown() {
            driver.closeApp();
        }


    }

