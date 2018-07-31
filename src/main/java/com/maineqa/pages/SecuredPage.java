package com.maineqa.pages;

import com.maineqa.pageinterfaces.ISecuredPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecuredPage extends BasePage implements ISecuredPage {

    @FindBy(css = ".radius > .icon-signout")
    public WebElement logoutButton;

    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector("a.radius");

    public SecuredPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage clickLogout() {
        logoutButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
