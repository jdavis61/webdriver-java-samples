package com.maineqa.pages;

import com.maineqa.pageinterfaces.ISecuredPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecuredPage extends BasePage implements ISecuredPage {

    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector("a.radius");

    public SecuredPage(WebDriver driver) {
        super(driver);
    }
}
