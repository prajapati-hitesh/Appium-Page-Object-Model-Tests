package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

/**
 * Created by crhoads on 3/22/16.
 */
public class RuleDisplayPage {

    private AndroidDriver _driver;

    public  RuleDisplayPage(AndroidDriver driver){

        PageFactory.initElements(driver, this);
      _driver = driver;
    }

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.ImageButton[1]")
    private WebElement menuButton;

    @FindBy(id = "com.chamberlain.myq.chamberlain:id/create_new_rule")
    private WebElement addRuleIcon;

    @FindBy(id = "xandroid:id/content")
    private WebElement ruleLayout;

    //@FindBy(id = "com.chamberlain.myq.chamberlain:id/RulesList_RowTextView")
    //private WebElement ruleName;




    public AddRuleChooseDevicePage clickAddRuleIconToChooseDeviceToCreateRuleFor(){
        try {

            addRuleIcon.click();

        }
                catch(NoSuchElementException a){

                    a.printStackTrace();
                }

        AddRuleChooseDevicePage chooseDevice  = new AddRuleChooseDevicePage(_driver);

        return chooseDevice;
    }

    public FlyOutMenu accessFlyoutMenu() {

        menuButton.click();

        FlyOutMenu flyOutMenu = new FlyOutMenu(_driver);

                return flyOutMenu;


    }


    public RuleCreationPage selectRuleToDelete(String ruleName){

        _driver.scrollTo(ruleName).click();


        RuleCreationPage editRulePage = new RuleCreationPage(_driver);


        return editRulePage;


    }



/*
    public RuleDisplayPage deleteAllImmediateRules(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content")));

        System.out.println("deleteAllImmediate Rules method has been entered. Rule list is now visible.");

        try {
            int rulesDeleted = 0;
            boolean found = false;

            System.out.println("deleteAllImmediateRules method has been entered. While loop beginning now with ScrollTo 'RULE'");

            while (found == false) {

                driver.scrollTo("Immediate Rule").click();
                RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);

                System.out.println("deleteRule() method is going to fire.");
                ruleCreationPage.deleteRule(driver);
                System.out.println("deleteRule has method has now EXITED.");


                rulesDeleted++;
                System.out.println("Number of Immediate Rules Deleted are " + rulesDeleted);



            }


        }catch(NoSuchElementException b){



            b.printStackTrace();

            }
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
        return  ruleDisplayPage;

        }

    */

    public RuleDisplayPage deleteAllRules(){

        List<WebElement> located_elements = _driver.findElements(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]"));

        int xpathCount = 0;


        for(WebElement located_element : located_elements){

            xpathCount++;
        }

        System.out.println("Xpath count is " + xpathCount);

        WebDriverWait wait = new WebDriverWait(_driver,90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content")));

        System.out.println("deleteAllRules method has been entered. Rule list is now visible.");

        try {



            int rulesDeleted = 0;
            boolean ruleLayout = false;


            System.out.println("deleteAll Rules method has been entered. For loop beginning now with ScrollTo 'Selenium Rule'");

            for (  int visibleRules = xpathCount; visibleRules > 0 ; xpathCount-- ) {
            {


                _driver.scrollTo(" Selenium Rule").click();
                RuleCreationPage ruleCreationPage = new RuleCreationPage(_driver);

                System.out.println("deleteRule() method is going to fire.");
                ruleCreationPage.deleteRule();
                System.out.println("deleteRule has method has now EXITED.");


                rulesDeleted++;
                System.out.println("Number of Rules Deleted are " + rulesDeleted);



            }

            }

        }catch(NoSuchElementException b){

            b.printStackTrace();

            RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);
            return  ruleDisplayPage;



        }
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(_driver);
        return  ruleDisplayPage;

    }



/*
    public RuleDisplayPage deleteAllScheduledRules(AndroidDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/content")));

        System.out.println("deleteAllScheduled Rules method has been entered. Rule list is now visible.");

        try {
            int rulesDeleted = 0;
            boolean found = false;

            System.out.println("deleteAllScheduled Rules method has been entered. While loop beginning now with ScrollTo 'RULE'");

            while (found == false) {

                driver.scrollTo("Scheduled Rule").click();
                RuleCreationPage ruleCreationPage = new RuleCreationPage(driver);

                System.out.println("deleteRule() method is going to fire.");
                ruleCreationPage.deleteRule(driver);
                System.out.println("deleteRule has method has now EXITED.");


                rulesDeleted++;
                System.out.println("Number of Scheduled Rules Deleted are " + rulesDeleted);



            }


        }catch(NoSuchElementException b){



            b.printStackTrace();

        }
        RuleDisplayPage ruleDisplayPage = new RuleDisplayPage(driver);
        return  ruleDisplayPage;

    }
*/





}


