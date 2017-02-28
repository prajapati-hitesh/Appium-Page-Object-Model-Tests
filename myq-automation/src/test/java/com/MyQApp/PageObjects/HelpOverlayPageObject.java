package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by crhoads on 3/18/16.
 */
public class HelpOverlayPageObject {



    public PlacesPage clearOverlay(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement helpScreen = driver.findElement(By.id("com.chamberlain.myq.chamberlain:id/imageView"));

        //checks for and clears Help Overlay
        if (helpScreen.isDisplayed()) {
            helpScreen.click();
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/device_gallery")));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/scroll_position")));

        System.out.println("Login button was clicked. MyQ Devices should now be visible. ");
        System.out.println("                                     ");

        PlacesPage deviceList = new PlacesPage(driver);

        return deviceList;

    }



}
