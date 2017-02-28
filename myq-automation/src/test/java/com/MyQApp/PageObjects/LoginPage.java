package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by crhoads on 3/18/16.
 */
public class LoginPage {


    //Sign In
    @FindBy(id = "com.chamberlain.myq.chamberlain:id/username")
    private WebElement username;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/password")
    private WebElement password;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/login_button")
    private WebElement loginButton;



    public  LoginPage(AndroidDriver driver) {

        PageFactory.initElements(driver, this);

    }


    public PlacesPage existingUserSignsInToPreProd(AndroidDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Enters the username

        username.clear();
        username.sendKeys("ranorextestbench+1@gmail.com");

        //Enters the password

        password.clear();
        password.sendKeys("Test123a");

        //Removes the softkeyboard from display
        driver.navigate().back();

        EnvironmentListPage envList = new EnvironmentListPage(driver);
        envList.userSelectsPreProd(driver);


        //Clicks the login button

        loginButton.click();

        //HelpOverlayPageObject overlay = new HelpOverlayPageObject();
        //PlacesPage deviceList = overlay.clearOverlay(driver);
        PlacesPage deviceList = new PlacesPage(driver);
        return deviceList;

    }
}
