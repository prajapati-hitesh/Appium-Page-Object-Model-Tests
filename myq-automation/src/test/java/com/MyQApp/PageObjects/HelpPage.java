package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by crhoads on 3/21/16.
 */
public class HelpPage {

    public HelpPage(AndroidDriver driver){

        PageFactory.initElements(driver, this);

    }
}
