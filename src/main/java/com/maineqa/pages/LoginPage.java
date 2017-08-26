package com.maineqa.pages;

import com.maineqa.pageinterfaces.IFormAuthentication;
import com.maineqa.utilities.SleepUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage implements IFormAuthentication {

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button.radius")
    private WebElement submitButton;

    public static final By SCREEN_PRESENCE_LOCATOR = By.id("username");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginInformation(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
    }

    public void clickSubmitButton() {
        // Added in case an anti-virus secure input pop-up appears after tabbing from password.
        try {
            submitButton.click();
        } catch (WebDriverException e) {
            SleepUtils.sleep(5000);
            submitButton.click();
        }
    }

    public SecuredPage login(String usernameValue, String passwordValue) {
        enterLoginInformation(usernameValue, passwordValue);
        clickSubmitButton();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SecuredPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, SecuredPage.class);
    }

}