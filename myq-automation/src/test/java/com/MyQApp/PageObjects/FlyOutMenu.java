package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by crhoads on 3/18/16.
 */
public class FlyOutMenu {



    public  FlyOutMenu(AndroidDriver driver){

        PageFactory.initElements(driver, this);

    }

    int placesPageFlyOutMenuClickCount = 0;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")
    private WebElement places;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]/android.widget.ImageView[1]")
    private WebElement account;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]/android.widget.ImageView[1]")
    private WebElement alerts;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[4]/android.widget.ImageView[1]")
    private WebElement schedules;


    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[5]/android.widget.ImageView[1]")
    private WebElement history;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[6]/android.widget.ImageView[1]")
    private WebElement help;


    public PlacesPage clickPlacesOptionOnPlacesFlyoutMenu(AndroidDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")));

        try {

            places.click();
            placesPageFlyOutMenuClickCount++;

            System.out.println("Places was just clicked on the flyOutMenu and will now return the places page");
            System.out.println("Places menu has been clicked " + placesPageFlyOutMenuClickCount + " times");

        }catch(NoSuchElementException a){

            System.out.println("Places was clicked but not loaded as a 'NoSuchElementException' was thrown and caught.");
            a.printStackTrace();

        }
        PlacesPage placesPage = new PlacesPage(driver);

        return placesPage;
    }


    public AccountPage clickAccountOptionOnPlacesFlyoutMenu(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(account));

        account.click();
        System.out.println("Account was just clicked on the flyOutMenu and will now return the account page");

        AccountPage accountPage = new AccountPage(driver);

        return accountPage;
    }



    public RuleDisplayPage clickRuleOptionOnPlacesFlyoutMenu(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(alerts));

        alerts.click();
        System.out.println("Rules menu option just clicked on the flyOutMenu and will now return the RuleDisplayPage elements.");


        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
        return ruleDisplayPage;
    }

    public HistoryPage clickHistoryOptionOnPlacesFlyoutMenu(AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(history));

        history.click();
        System.out.println("History was just clicked on the flyOutMenu and will now return the history page");
        HistoryPage historyPage = new HistoryPage(driver);



        return historyPage;

    }

    public HelpPage clickHelpOptionOnPlacesFlyoutMenu(AndroidDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.elementToBeClickable(help));

        help.click();
        System.out.println("HELP was just clicked on the flyOutMenu and will now return the help page");

        HelpPage helpPage = new HelpPage(driver);

        return helpPage;

    }


}
