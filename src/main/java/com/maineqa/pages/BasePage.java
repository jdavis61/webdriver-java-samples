package com.maineqa.pages;

import com.maineqa.pageinterfaces.IBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements IBasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    private int defaultTimeout = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
    }


    public String getPageHeader() {
        return null;
    }

    public String getPageSubHeader() {
        return null;
    }

    public String getFooter() {
        return null;
    }

}
