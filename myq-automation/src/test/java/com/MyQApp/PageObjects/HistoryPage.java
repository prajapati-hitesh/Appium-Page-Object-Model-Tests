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
 * Created by crhoads on 3/21/16.
 */
public class HistoryPage {



    private AndroidDriver _driver;



    public  HistoryPage(AndroidDriver driver) {

        PageFactory.initElements(driver, this);

        _driver = driver;

    }

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EventsTab_TextView_EmptyList")
    private WebElement noHistMsg;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/clear_event_history")
    private WebElement deleteHistoryButton;

    @FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[2]")
    private WebElement deleteContinueButton;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")
                    //"//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]"
    private WebElement flyoutButton;



    public FlyOutMenu accessFlyOutMenu(){

        WebDriverWait wait = new WebDriverWait(_driver, 15);

        flyoutButton.click();

        FlyOutMenu flyOutMenu = new FlyOutMenu(_driver);

        return flyOutMenu;

    }


    public void validateHistoryExists() {
        System.out.println("System is determining if there is a history being displayed.");

        try {
            WebDriverWait wait = new WebDriverWait(_driver, 35);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/EventsTab_TextView_EmptyList")));
            System.out.println("Triggered rules are being tracked in History panel");
        } catch (TimeoutException e) {

            e.printStackTrace();
            System.out.println("History of events could not be found");
        }
    }





    public void deleteHistory(){
        WebDriverWait wait = new WebDriverWait(_driver, 35);

        try {
            deleteHistoryButton.click();
            System.out.println("Delete History Button Has Been Clicked.");


            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[1]")));



        deleteContinueButton.click();
        System.out.println("Waiting for history to disappear.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/EventsTab_TextView_EmptyList")));

        System.out.println("Rule history has been successfully deleted");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")));

        }catch (TimeoutException f){

            f.printStackTrace();
            System.out.println("History could not be deleted.");
        }
    }




}
