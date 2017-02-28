package com.MyQApp.PageObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by crhoads on 3/21/16.
 */
public class EnvironmentListPage {

    public EnvironmentListPage(AndroidDriver driver) {


        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//android.widget.TextView[@text = 'PP: myqexternal-pp.myqdevice.com']")
    //@FindBy(partialLinkText = "PP: myqexternal-pp.myqdevice")
    //@FindBy(linkText = "PP: myqexternal-pp.myqdevice.com") //for some reason link text will not locate the PP environment selector
   private WebElement ppPicker;



    public LoginPage userSelectsPreProd(AndroidDriver driver) {
        WebElement envPicker = driver.findElementById("com.chamberlain.myq.chamberlain:id/version_name");

    //Selects the environment picker
    TouchAction touchAction = new TouchAction(driver);


    touchAction.longPress(envPicker).perform();
    ppPicker.click();


        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }
}
