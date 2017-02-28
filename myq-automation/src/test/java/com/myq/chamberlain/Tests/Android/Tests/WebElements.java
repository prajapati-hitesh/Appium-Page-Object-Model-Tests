package com.myq.chamberlain.Tests.Android.Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class WebElements {

    AndroidDriver driver;


    //Sign In
    WebElement username = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/username"));
    WebElement password = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/password"));
    WebElement ppPicker = driver.findElement(By.id("android:id/title"));
    WebElement envPickerPreProd = driver.findElementById("com.chamberlain.myq.chamberlain:id/version_name");
    WebElement loginButton = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/login_button"));

    //Device Gallery
    WebElement helpScreen = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/imageView"));
    WebElement deviceName = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/list_label"));
    WebElement deviceIcon = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_icon"));
    WebElement deviceGallery = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_gallery"));
    WebElement deviceState = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_state"));

    //Rules
    WebElement ruleSelector = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]"));
    WebElement menuBar = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]"));
    WebElement ruleName = driver.findElement(By.xpath("com.chamberlain.myq.chamberlain:id/EditRuleFragment_EditText_RuleName"));
    WebElement ruleAddBtn = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/create_new_rule"));
    WebElement toggleAlertOnOpen = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertOnOpen"));
    WebElement toggleAlertOnClosed = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertOffClosed"));
    WebElement toggleAlertNotifyAsSoonAsItHappens = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertInstantly"));
    WebElement togglePushNotification = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_SendPush"));
    WebElement toggleEmailNotification = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_SendEmail"));
    WebElement ruleSaveButton = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/right_button"));
    WebElement toggleDeviceIsStopped = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertStopped"));




    public void swipeLeft() {

        driver.swipe(865,400,-25,50,1000);

    }

    public void swipeRight() {
        //driver.swipe(int start x, start y, end x, end y, duration);
        System.out.println("SwipeRight method intiated");
        driver.swipe(865,400,25,25,1000);

    }

    public void createImmediateRule(String desiredDeviceNameToApplyRule)
    {



        //click menu button
        menuBar.click();

        //select rules
        ruleSelector.click();

        //click add rule button
        ruleAddBtn.click();

        //Select device from menu that rule will apply to.
        boolean found = false;

        while (found = false)
        {


            String availableDeviceForRules = deviceName.getText().toUpperCase();

                if(availableDeviceForRules.equals(desiredDeviceNameToApplyRule))
                {

                    found = true;
                    deviceName.click();
                    System.out.println("Desired device name has been found.");
                    break;

                }

            else
                {
                    swipeRight();
                    System.out.println("The device you specified was not found in the available devices under the ADD RULES menu.");

                }


            if(deviceName.equals("CDO") || (deviceName.equals("GATE")))
            {

                ruleName.clear();
                ruleName.sendKeys("Appium " + deviceName + " Immediate Rule");

                toggleAlertOnOpen.click();
                toggleAlertOnClosed.click();
                toggleDeviceIsStopped.click();
                driver.scrollTo("Rule enabled");
                togglePushNotification.click();
                toggleEmailNotification.click();
                ruleSaveButton.click();

            }

            else
            {

                toggleAlertOnOpen.click();
                toggleAlertOnClosed.click();
                driver.scrollTo("Rule enabled");
                togglePushNotification.click();
                toggleEmailNotification.click();
                ruleSaveButton.click();
                WebDriverWait wait = new WebDriverWait(driver, 100);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/device_gallery")));

            }

        }

    }



    /*
    ************
    *
    *
    * This method was created with the thought that you could tell the method what device you wanted to actuate and it would then
    * swipe its way to the device based on the "deviceName" label matching the "deviceNameToActuate" input to the method by the user
    *
    * I ran intot he same problem as before where the swipeRight would view the first device twice and not stop on the device when it was
    * centered in the window. In fact this code doesnt ever stop to evaluate the deviceIcon.click() so this may need revisited at another time
    *
    *
    * I am going to create just the actioning and the rule creating and deleting without regard to what devices it is on, then validate after each
    * all the stuff is done that the devices have all been covered.....will see how that turns out.
    *
    *

    public void actuateDeviceAndCheckforChangedDeviceState(String deviceNameToActuate, AndroidDriver driver) {
    int swipeCount = 0;
    System.out.println("Actuate Method has entered and device state is  " + deviceState.getText());


    String startingDeviceState = deviceState.getText().toUpperCase();
    System.out.println("Device State before actuation is " + startingDeviceState);
    System.out.println("SwipeCount is " + swipeCount);

    String availableDeviceForRules = deviceName.getText().toUpperCase();

    System.out.println("Value of availableDeviceForRules is " +availableDeviceForRules + "Desired device to actuate is " + deviceNameToActuate );

    boolean found = false;

    while (found == false){
        System.out.println("Value of availableDeviceForRules is " +availableDeviceForRules + " Desired device to actuate is " + deviceNameToActuate );

        if (availableDeviceForRules == deviceNameToActuate) {

            found = true;
            swipeLeft(driver);

            try {

                if (deviceState.getText().toUpperCase().contains("OPEN")) {

                    deviceIcon.click();


                    WebDriverWait wait = new WebDriverWait(driver, 20);

                    try {
                        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Closed"));

                        System.out.println("The device successfully closed or turned off.");
                    } catch (TimeoutException a) {

                        System.out.println("TimeoutException has been caught and it is now trying to figure out if the errorMessageBox is displayed.");

                        WebElement okButton = driver.findElementById("android:id/button1");
                        WebElement errorMessageBox = driver.findElementById("android:id/message");
                        WebElement errorMessageContent = driver.findElementById("android:id/content");


                        if (errorMessageBox.isDisplayed()) {
                            errorMessageContent.getText();

                            System.out.println(errorMessageContent);

                            okButton.click();

                            a.getStackTrace();
                        }

                    }


                } else if (deviceState.getText().toUpperCase().contains("CLOSED")) {

                    deviceIcon.click();


                    WebDriverWait wait = new WebDriverWait(driver, 20);


                    try {
                        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Open for"));
                        System.out.println("The device successfully opened or turned on.");
                    } catch (TimeoutException e) {
                        System.out.println("TimeoutException e has been caught and it is now trying to figure out if the errorMessageBox is displayed.");

                        WebElement okButton = driver.findElementById("android:id/button1");
                        WebElement errorMessageBox = driver.findElementById("android:id/message");
                        WebElement errorMessageContent = driver.findElementById("android:id/content");


                        if (errorMessageBox.isDisplayed()) {
                            errorMessageContent.getText();

                            System.out.println(errorMessageContent);

                            okButton.click();

                            e.getStackTrace();
                        }
                    }
                }

            } catch (TimeoutException m) {

                WebElement okButton = driver.findElementById("android:id/button1");
                WebElement errorMessageBox = driver.findElementById("android:id/message");
                WebElement errorMessageContent = driver.findElementById("android:id/content");

                if (errorMessageBox.isDisplayed()) {
                    errorMessageContent.getText();

                    System.out.println(errorMessageContent);

                    okButton.click();
                }
            }


            break;
        }
        else {
            swipeRight(driver);
            availableDeviceForRules = deviceName.getText().toUpperCase();
            swipeCount++;

            if (swipeCount <= 6) {
                System.out.println("The device you specified was not found in the available devices under the ADD RULES menu. Please check the name and try again.");
            }
        }
    }
}

    */

    public void createDelayedRule(String desiredDeviceNameToApplyRule)
    {
        //click menu button
        menuBar.click();

        //select rules
        ruleSelector.click();

        //click add rule button
        ruleAddBtn.click();

        //Select device from menu that rule will apply to.
        boolean found = false;

        while (found = false)
        {


            String availableDeviceForRules = deviceName.getText().toUpperCase();

            if(availableDeviceForRules.equals(desiredDeviceNameToApplyRule))
            {

                found = true;
                deviceName.click();
                System.out.println("Desired device name has been found.");
                break;

            }

            else
            {

                System.out.println("The device you specified was not found in the available devices under the ADD RULES menu.");

            }


            if(deviceName.equals("CDO") || (deviceName.equals("GATE")))
            {

                ruleName.clear();
                ruleName.sendKeys("Appium " + deviceName + " Delayed Rule");

                toggleAlertOnOpen.click();
                toggleAlertOnClosed.click();
                toggleDeviceIsStopped.click();
                toggleAlertNotifyAsSoonAsItHappens.click();



                driver.scrollTo("Rule enabled");
                togglePushNotification.click();
                toggleEmailNotification.click();
                ruleSaveButton.click();

            }

            else
            {

                toggleAlertOnOpen.click();
                toggleAlertOnClosed.click();
                driver.scrollTo("Rule enabled");
                togglePushNotification.click();
                toggleEmailNotification.click();
                ruleSaveButton.click();
                WebDriverWait wait = new WebDriverWait(driver, 100);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/device_gallery")));
            }

        }

    }

/*
    public void ScrollandFindElement(String searchedDeviceName) {

        int swipeCount = 0;
        boolean found = false;
        WebElement deviceLabel = null;


        while (found == false) {

            deviceLabel = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_label"));
            String currentDeviceNameStart = deviceLabel.getText().toUpperCase();

            System.out.println("Value OF currentDeviceName is " + currentDeviceNameStart);
            System.out.println("Value OF searchedDeviceName is " + searchedDeviceName);

                if (currentDeviceNameStart.equals(searchedDeviceName)) {
                    found = true;


                    System.out.println("The currentDeviceName has been found to match the name given in ScrollAndFindElement() method");
                    System.out.println("There were " + swipeCount + " swipes made to find this element.");
                    System.out.println("*                                                                            ");
                    System.out.println("*                                                                            ");



                break;


                    }

                else {
                System.out.println("currentDeviceName has NOT been found to match the name given in ScrollAndFindElement() method and a swipe() method will now execute.");

                    try {

                        swipeRight();
                        swipeCount++;
                        System.out.println("SwipeCount is " + swipeCount);



                        System.out.println("*                                                                            ");
                        System.out.println("*                                                                            ");
                        System.out.println("*                                                                            ");
                        }

                    catch (UnsupportedOperationException e) {
                        swipeLeft();
                        }

                    }


                    WebDriverWait wait = new WebDriverWait(driver, 100);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/device_gallery")));
        }
        String currentDeviceNameEnd= deviceLabel.getText().toUpperCase();
        System.out.println("* The current device name is " + currentDeviceNameEnd);
    }

            //WebElement deviceState = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_state"));



*/

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






    @Test
    public void actuateDevice() throws InterruptedException {

        //xpathTest();

        //ScrollandFindElement("CDO");

                if(deviceState.getText().toUpperCase().contains("OPEN")) {

                    deviceIcon.click();

                    System.out.println("Waiting for device to Close or turn off.");


                    WebDriverWait wait = new WebDriverWait(driver, 100);
                    wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Closed for"));

                    System.out.println("The device successfully closed or turned off.");
                }

                else if(deviceState.getText().toUpperCase().contains("CLOSED")){

                    deviceIcon.click();

                    System.out.println("Waiting for device to Open or turn on.");

                    WebDriverWait wait = new WebDriverWait(driver, 100);
                    wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Open for"));

                    System.out.println("The device successfully opened or turned on.");
                }
	}

        @AfterMethod
        public void tearDown ()throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
        }
    }


