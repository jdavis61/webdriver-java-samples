package com.maineqa.pages;

import com.maineqa.pageinterfaces.IJavaScriptAlertsPage;
import com.maineqa.pageinterfaces.INavigation;
import com.maineqa.pages.challengingdom.ChallengingDomPage;
import com.maineqa.utilities.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class NavigationMenu implements INavigation {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    private String basePage;
    Properties properties = PropertiesUtils.configurationProperties();

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        this.basePage = properties.getProperty("base.page.url");
    }


    public void loadNavigationMenu() {
        driver.get(basePage);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Available Examples']")));
    }

    public LoginPage clickFormAuthentication() {
        driver.get(basePage + "/login");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsPage() {
        // Cannot use page factory, for some reason Chromedriver will not scroll to element using Chrome 61. Latest
        // chromedriver does not support 61, hopefully an update really soon!
        driver.get(basePage + "/javascript_alerts");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(JavaScriptAlertsPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, JavaScriptAlertsPage.class);
    }

    public HoversPage clickHoversPage() {
        driver.get(basePage + "/hovers");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(HoversPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, HoversPage.class);
    }

    @Override
    public ChallengingDomPage clickChallengingDomPage() {
        driver.get(basePage + "/challenging_dom");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ChallengingDomPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, ChallengingDomPage.class);
    }

    @Override
    public CheckboxesPage clickCheckboxesPage() {
        driver.get(basePage + "/checkboxes");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CheckboxesPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, CheckboxesPage.class);
    }


}
