package com.maineqa;

import com.maineqa.pageinterfaces.ITestSetupTeardown;
import com.maineqa.pages.JavaScriptAlertsPage;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.utilities.SleepUtils;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlertIT implements ITestSetupTeardown {

    private WebDriver driver;
    private NavigationMenu navigationMenu;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = WebDriverFactory.createLocalChromeDriverInstance();
        this.navigationMenu = PageFactory.initElements(driver, NavigationMenu.class);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test
    public void clickJavaScriptAlert() {
        navigationMenu.loadNavigationMenu();
        JavaScriptAlertsPage javaScriptAlertsPage = navigationMenu.clickJavaScriptAlertsPage();
        Assert.assertEquals(javaScriptAlertsPage.getPageHeader(), "JavaScript Alerts");
        javaScriptAlertsPage.clickJSAlertButton();
        javaScriptAlertsPage.closeAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResult(), "You successfuly clicked an alert");
    }

    @Test
    public void clickJavaScriptConfirm() {
        navigationMenu.loadNavigationMenu();
        JavaScriptAlertsPage javaScriptAlertsPage = navigationMenu.clickJavaScriptAlertsPage();
        javaScriptAlertsPage.clickJSConfirmButton();
        javaScriptAlertsPage.closeAlert();
        Assert.assertEquals(javaScriptAlertsPage.getResult(), "You clicked: Ok");
    }

    @Test
    public void clickJavaScriptPrompt() {
        String text = "QA";
        navigationMenu.loadNavigationMenu();
        JavaScriptAlertsPage javaScriptAlertsPage = navigationMenu.clickJavaScriptAlertsPage();
        javaScriptAlertsPage.clickJSPromptButton();
        javaScriptAlertsPage.enterTextIntoPrompt(text);
        Assert.assertEquals(javaScriptAlertsPage.getResult(), "You entered: " + text);
    }

}
