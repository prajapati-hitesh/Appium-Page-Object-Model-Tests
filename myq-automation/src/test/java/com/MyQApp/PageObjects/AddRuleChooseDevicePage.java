package com.MyQApp.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by crhoads on 3/22/16.
 */
public class AddRuleChooseDevicePage {

    public AddRuleChooseDevicePage(AndroidDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")
    private WebElement WGDO;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]")
    private WebElement CDO;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")
    private WebElement GATE;

    @FindBy( xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[4]")
    private WebElement LIGHT;


    public RuleCreationPage clickWGDO(AndroidDriver driver) {

        WGDO.click();



        RuleCreationPage createRule = new RuleCreationPage(driver);
        return createRule ;
    }

    public RuleCreationPage clickCDO(AndroidDriver driver) {

        CDO.click();



        RuleCreationPage createRule = new RuleCreationPage(driver);
        return createRule ;
    }

    public RuleCreationPage clickGATE(AndroidDriver driver) {

        GATE.click();



        RuleCreationPage createRule = new RuleCreationPage(driver);
        return createRule ;
    }

    public RuleCreationPage clickLIGHT(AndroidDriver driver) {

        LIGHT.click();



        RuleCreationPage createRule = new RuleCreationPage(driver);
        return createRule ;
    }


}
