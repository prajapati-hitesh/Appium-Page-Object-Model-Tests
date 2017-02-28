package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by crhoads on 3/18/16.
 */
public class RuleCreationPage {

    private AndroidDriver _driver;


    @FindBy (id = "com.chamberlain.myq.chamberlain:id/add_new_rule")
    private WebElement ruleButton;

    @FindBy( id = "com.chamberlain.myq.chamberlain:id/EditRuleFragment_TextView_DeviceName")
    private WebElement deviceName;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRuleFragment_EditText_RuleName")
    private WebElement ruleName;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertOnOpen")
    private WebElement alertOnOpen;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertOffClosed")
    private WebElement alertOnClose;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_SendPush")
    private WebElement sendPushAlert;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_SendEmail")
    private WebElement sendEmailAlert;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/right_button")
    private WebElement saveButton;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertAlways")
    private WebElement allTimesOfDays;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/longer_than_duration_row")
    private WebElement selectLongerThan;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/EditRule_Toggle_AlertInstantly")
    private WebElement asSoonAsItHappens;

    @FindBy(id = "android:id/minutes")
    private WebElement radialPicker;

    @FindBy(xpath = "//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.TimePicker[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.widget.RadialTimePickerView.RadialPickerTouchHelper[2]")
    private WebElement minuteCommit;

    @FindBy(id = "android:id/button1")
    private WebElement radialPickerOkButton;


    @FindBy(id = "com.chamberlain.myq.chamberlain:id/delete_rule")
    private WebElement trashCanButton;

    @FindBy(id = "android:id/content")
    private WebElement deleteConfirmation;

    @FindBy(id = "android:id/button1")
    private WebElement deleteConfirmationYESbutton;

    public RuleCreationPage(AndroidDriver driver){


        PageFactory.initElements(driver, this);

        _driver = driver;


    }

    public  RuleDisplayPage deleteRule(){
        System.out.println("deleteRule method has entered. Waiting on the add new rule icon to become invisible.");

        WebDriverWait wait = new WebDriverWait(_driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/add_new_rule")));
        String ruleNameTitle = ruleName.getText();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.chamberlain.myq.chamberlain:id/delete_rule")));

        trashCanButton.click();

        System.out.println("Trashcan button just clicked, waiting on deleteConfirmation to display.");


        wait.until(ExpectedConditions.visibilityOf(deleteConfirmation));

        System.out.println("deleteConfirmation is displayed, yes button will be clicked.");

        deleteConfirmationYESbutton.click();

        System.out.println("Yes button clicked, returning back to RulesDisplayPage.");
        System.out.println("");
        System.out.println("Appium just deleted the  " + ruleNameTitle);



        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);

        return ruleDisplayPage;

    }


    public RuleDisplayPage createImmediateRule(AndroidDriver driver){
        String currentDevice = deviceName.getText();

        System.out.println("Creating an Immediate rule has initiated for " + currentDevice);

        //Enters rule name

        ruleName.clear();
        ruleName.click();
        ruleName.sendKeys( deviceName.getText() + " Immediate Selenium Rule #" + " " );



        //Removes the softkeyboard from display
        _driver.navigate().back();

        //Selects Door Open
        alertOnOpen.click();

        //Selects Door Closed
        alertOnClose.click();

        //Scrolls to bottom to view more options
        _driver.scrollTo("Push");

        //Selects Push Notification
        sendPushAlert.click();

        //Scrolls to bottom to view more options
        _driver.scrollTo("Alert Enable");


        //Selects Email Notification
        sendEmailAlert.click();
        //Clicks the Save button
        saveButton.click();
        //ruleCount++;



        System.out.println("Immediate Rule Completed Successfully for " +currentDevice);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);

        return ruleDisplayPage;
    }


    public RuleDisplayPage createScheduledRule(AndroidDriver driver){

        String currentDevice = deviceName.getText();

        System.out.println("Creating a Scheduled rule has initiated for " +currentDevice);

        //Enters rule name

        //ruleName.clear();
        ruleName.click();
        ruleName.sendKeys( deviceName.getText() + " Scheduled Selenium Rule" + " " );

        //Removes the softkeyboard from display
        _driver.navigate().back();

        //Selects Door Open
        alertOnOpen.click();

        //Selects Door Closed
        alertOnClose.click();

        //Scrolls to bottom to view more options
        _driver.scrollTo("Push");


        //Selects All Times and days
        allTimesOfDays.click();

        //Scrolls to bottom to view more options
        _driver.scrollTo("Alert enable");

        //Selects Push Notification
        sendPushAlert.click();

        //Selects Email Notification
        sendEmailAlert.click();

        //Clicks the Save button
        saveButton.click();
        //ruleCount++;


        System.out.println("Scheduled Rule Completed Successfully for " + currentDevice);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");


        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);

        return ruleDisplayPage;



    }



    public RuleDisplayPage createDelayedRule(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(_driver, 20);
        String currentDevice = deviceName.getText();

        System.out.println("Creating a delayed rule has initiated for " + currentDevice);



        //Enters rule name
        //ruleName.clear();
        ruleName.click();
        ruleName.sendKeys( deviceName.getText() + " Delayed Selenium Rule" + " " );

        //Removes the softkeyboard from display
        _driver.navigate().back();

        //Selects Door Open
        alertOnOpen.click();
        //Selects Door Closed
        alertOnClose.click();
        //Selects As Soon as it happens to reveal the duration of minutes under "For Longer Than"

        //Scrolls to bottom to view more options
        _driver.scrollTo("Alert Enable");

        //Selects As Soon As It Happens to reveal the minute delay
        asSoonAsItHappens.click();

        //clicks on the For Longer THan minute bar revealing the time picker
        selectLongerThan.click();
        System.out.println("Picker is visible and changing to minute selection is being attempted");



        //Selects radial time picker and changes to minutes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/radial_picker")));
        System.out.println("Appium has clicked the radial picker to expose the minutes.");
        radialPicker.click();


        //Selects the 5 min delay

        minuteCommit.click();
        System.out.println("5 minute delay has been selected.");

        //Clicks ok button on radial dial picker
        radialPickerOkButton.click();


        _driver.scrollTo("Alert Enable");


        //Selects Push Notification
        sendPushAlert.click();

        //Selects Email Notification
        sendEmailAlert.click();

        //Clicks the Save button
        saveButton.click();
        //ruleCount++;


        System.out.println("Delayed Rule Completed Successfully for " +currentDevice);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);

        return ruleDisplayPage;
    }

}
