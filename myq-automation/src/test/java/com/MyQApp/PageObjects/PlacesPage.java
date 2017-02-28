package com.MyQApp.PageObjects;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by crhoads on 3/18/16.
 */
public class PlacesPage {

    private AndroidDriver _driver;


    //Device Gallery
    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Gallery[1]/android.widget.LinearLayout[@selected = 'true'])")
    private WebElement deviceIsCentered;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/imageView")
    private WebElement helpScreen;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/device_label")
    private WebElement deviceName;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/device_icon")
    private WebElement deviceIcon;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/device_gallery")
    private WebElement deviceGallery;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/device_state")
    private WebElement deviceState;

    @FindBy(id = "android:id/message")
    private WebElement errorMessageBox;

    @FindBy(id = "android:id/button1")
    private WebElement okButton;

    @FindBy(id = "android:id/content")
    private WebElement errorMessageContent;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ImageButton[1]")
    private WebElement flyoutMenu;


    public PlacesPage(AndroidDriver driver) {

        PageFactory.initElements(driver, this);

        _driver = driver;
    }

    public void swipeLeft() {
        System.out.println("SwipeLeft method initiated");
        _driver.swipe(865, 400, -25, 50, 1000);
        _driver.findElementsByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Gallery[1]/android.widget.LinearLayout[2]");
    }

    public void swipeRight() {
        //driver.swipe(int start x, start y, end x, end y, duration);
        System.out.println("SwipeRight method initiated");
        _driver.swipe(865, 400, 25, 25, 1000);

    }
/*
    private void findDevice(String desiredDeviceName){
        String discoveredDeviceName = _driver.findElement(By.xpath("//android.widget.LinearLayout[contains(., desiredDeviceName)]));
        if(desiredDeviceName.equals(discoveredDeviceName)){

            driver.

        }

    }
*/
    private boolean deviceIsOpen(){

        if(deviceState.getText().contains("Open for"))
            return true;

        else return false;



    }

    private boolean deviceIsClosed(){

        if(deviceState.getText().contains("Closed for"))
            return true;
        else return false;



    }






    private void closeDevice(){

        deviceIcon.click();
        System.out.println("The closeDevice() method just activated.");
        System.out.println("deviceIcon was just clicked. Expect the deviceState to change shortly.");


        WebDriverWait wait = new WebDriverWait(_driver, 35);


        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Closed for"));

        System.out.println("The closeDevice() method has detected the device state changed to 'Closed for' or 'Off For'");


    }



    private void didDeviceClose() {

        WebDriverWait wait = new WebDriverWait(_driver, 35);

        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Closed for"));
        System.out.println("Did device Close or Turn off? Yes, the device is now 'Closed for' or turned 'Off'.");

        System.out.println("");
        System.out.println("");

    }

    private void openDevice(){

        deviceIcon.click();

        System.out.println("The openDevice() method just activated.");
        System.out.println("deviceIcon was just clicked. Expect the deviceState to change shortly.");

        WebDriverWait wait = new WebDriverWait(_driver, 35);

        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Open for"));

        System.out.println("The openDevice() method has detected the device state changed to 'Open for' or 'On For'");


    }


    private void didDeviceOpen() {

        WebDriverWait wait = new WebDriverWait(_driver, 35);

        wait.until(ExpectedConditions.textToBePresentInElement(deviceState, "Open for"));

        System.out.println("Did device Open or Turn On? Yes, the device is now 'Open for' or turned 'On'.");

        System.out.println("");
        System.out.println("");
    }


    public void actuateAndCheckforChangedDeviceState(AndroidDriver driver) {


        System.out.println("Actuate Method has entered and device state is  " + deviceState.getText());
        String startingDeviceState = deviceState.getText().toUpperCase();
        System.out.println("Device State before actuation is " + startingDeviceState);




            if ( deviceIsOpen() ) {

                closeDevice();

                didDeviceClose();


            }



            else if ( deviceIsClosed() ) {

                openDevice();

                didDeviceOpen();

                }

    }





    public void actuateAndCheckforChangedDeviceStateWithTryCatchForPopUps() {

        System.out.println("Actuate Method has entered and device state is  " + deviceState.getText());


        String startingDeviceState = deviceState.getText().toUpperCase();
        System.out.println("Device State before actuation is " + startingDeviceState);


        if (deviceIsOpen()) {
            try {
                closeDevice();


            } catch (TimeoutException a) {

                System.out.println("TimeoutException has been caught and it is now trying to figure out if the errorMessageBox is displayed.");



                if (errorMessageBox.isDisplayed()) {
                    errorMessageContent.getText();

                    System.out.println(errorMessageContent);

                    okButton.click();

                    a.getStackTrace();
                }
            }
        } else if (deviceIsClosed()) {
            try {
            openDevice();

                didDeviceOpen();




                didDeviceOpen();


            } catch (TimeoutException e) {
                System.out.println("TimeoutException e has been caught and it is now trying to figure out if the errorMessageBox is displayed.");


                if (errorMessageBox.isDisplayed()) {
                    errorMessageContent.getText();

                    System.out.println(errorMessageContent);

                    okButton.click();

                    e.getStackTrace();
                }
            }
        }
    }

    public void ScrollandFindElement(String searchedDeviceName) {

        int swipeCount = 0;
        boolean found = false;
        WebElement deviceLabel = null;


        while (found == false) {




            deviceLabel = _driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/device_label"));
            String currentDeviceNameStart = deviceLabel.getText().toUpperCase();

            System.out.println("Value OF currentDeviceName is " + currentDeviceNameStart);
            System.out.println("Value OF searchedDeviceName is " + searchedDeviceName);

            if (currentDeviceNameStart.equals(searchedDeviceName) && deviceIsCentered.isDisplayed()) {
                found = true;


                System.out.println("The currentDeviceName has been found to match the name given in ScrollAndFindElement() method");
                System.out.println("There were " + swipeCount + " swipes made to find this element.");
                System.out.println("*                                                                            ");
                System.out.println("*                                                                            ");

                deviceIcon.click();


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


            WebDriverWait wait = new WebDriverWait(_driver, 100);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/device_gallery")));
        }
        String currentDeviceNameEnd= deviceLabel.getText().toUpperCase();
        System.out.println("* The current device name is " + currentDeviceNameEnd);
    }






            public FlyOutMenu accessFlyoutMenu (){

            flyoutMenu.click();
                System.out.println("accessFlyoutMenu() was just clicked. You should now see the flyout menu options.");

            WebDriverWait wait = new WebDriverWait(_driver, 5);

            wait.until(ExpectedConditions.visibilityOf(flyoutMenu));
            FlyOutMenu flyOut = new FlyOutMenu(_driver);

            return flyOut;
        }

    }

