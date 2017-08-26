package com.maineqa.pages;

import com.maineqa.pageinterfaces.IBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage implements IBasePage {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @FindBy(className = "subheader")
    private WebElement subheader;

    @FindBy(id = "page-footer")
    private WebElement footerText;

    @FindBy(className = "flash")
    private WebElement pageMessage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
    }


    public String getPageHeader() {

        // The header is either an h2 or h3 element.
        String h2Selector = "div.example h2";
        String h3Selector = "div.example h3";
        if (driver.findElements(By.cssSelector(h2Selector)).size() > 0) {
            return driver.findElement(By.cssSelector(h2Selector)).getText().trim();
        } else {
            return driver.findElement(By.cssSelector(h3Selector)).getText().trim();
        }

    }

    public String getPageSubHeader() {
        return subheader.getText();
    }

    public String getFooterText() {
        return footerText.getText().trim();
    }

    public String getPageMessage() {
        webDriverWait.until(ExpectedConditions.visibilityOf(pageMessage));
        // Get rid of trailing rendered close button character!
        return pageMessage.getText().split("\\r?\\n")[0].trim();
    }

}
