package com.maineqa.pages;

import com.maineqa.pageinterfaces.IJavaScriptAlertsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptAlertsPage extends BasePage implements IJavaScriptAlertsPage {

    @FindBy(css = "button[onclick='jsAlert()']")
    private WebElement jsAlertButton;

    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement jsConfirmButton;

    @FindBy(css = "button[onclick='jsPrompt()']")
    private WebElement jsPromptButton;

    @FindBy(id = "result")
    private WebElement result;

    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector("button[onclick='jsConfirm()']");

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickJSAlertButton() {
        jsAlertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @Override
    public void clickJSConfirmButton() {
        jsConfirmButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @Override
    public void clickJSPromptButton() {
        jsPromptButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    @Override
    public String getResult() {
        return result.getText().trim();
    }

    @Override
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }

    @Override
    public void enterTextIntoPrompt(String text) {
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }


}
