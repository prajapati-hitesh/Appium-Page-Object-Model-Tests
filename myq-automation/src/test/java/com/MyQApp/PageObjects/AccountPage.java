package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
/**
 * Created by crhoads on 3/21/16.
 */
public class AccountPage {

    private AndroidDriver _driver;

    public  AccountPage(AndroidDriver driver) {

        PageFactory.initElements(driver, this);
        _driver = driver;
    }

    @FindBy(id = "android:id/button1")
    private WebElement logoutButton;


    public void userLogsOut(){
        System.out.println("userLogsOut() method has just entered.");

        WebDriverWait wait = new WebDriverWait(_driver, 15);

        System.out.println("Appium is now searching for Logout button.");

        _driver.scrollTo("Logout").click();

        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        System.out.println("Logout 'Ok' button has been targeted");

        logoutButton.click();

        System.out.println("Logout 'Ok' button has been clicked.");



        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/account_logout")));

        System.out.println("User successfully logged out.");
    }


}
