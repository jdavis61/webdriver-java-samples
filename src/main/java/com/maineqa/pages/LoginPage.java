package com.maineqa.pages;

import com.maineqa.pageinterfaces.ILogin;
import com.maineqa.utilities.SleepUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage implements ILogin {

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
        // Added in case an anti-virus secure input pop-up appears after tabbing from password which blocks the submit button.
        try {
            submitButton.click();
        } catch (WebDriverException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", submitButton);
        }
    }

    public SecuredPage login(String usernameValue, String passwordValue) {
        enterLoginInformation(usernameValue, passwordValue);
        clickSubmitButton();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(SecuredPage.SCREEN_PRESENCE_LOCATOR));
        return PageFactory.initElements(driver, SecuredPage.class);
    }

}
