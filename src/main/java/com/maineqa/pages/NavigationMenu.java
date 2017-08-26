package com.maineqa.pages;

import com.maineqa.pageinterfaces.INavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Navigation implements INavigation {

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }


    public FormAuthentication clickFormAuthentication() {

        return PageFactory.initElements(driver, FormAuthentication.class);
    }
}
