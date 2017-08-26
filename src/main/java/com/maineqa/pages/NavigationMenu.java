package com.maineqa.pages;

import com.maineqa.pageinterfaces.INavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenu implements INavigation {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
    }


    public void loadNavigationMenu() {
        driver.get("http://localhost:9292");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Available Examples']")));
    }

    public FormAuthentication clickFormAuthentication() {
        formAuthenticationLink.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(FormAuthentication.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, FormAuthentication.class);
    }
}