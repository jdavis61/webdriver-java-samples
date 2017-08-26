package com.maineqa.pages.challengingdom;

import com.maineqa.pageinterfaces.challeningdom.IChallengingDomPage;
import com.maineqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChallengingDomPage extends BasePage implements IChallengingDomPage {

    private ChallengingDomTable challengingDomTable;
    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector("#canvas");

    public ChallengingDomPage(WebDriver driver) {
        super(driver);
    }

    public ChallengingDomTable getTable() {
        if (this.challengingDomTable == null) {
            // scrape the table html, parse into a List<ChallengingDomRow> object.
            WebElement table = driver.findElement(By.className("large-10"));
            String html = table.getAttribute("outerHTML");
            this.challengingDomTable = new ChallengingDomTable(html);
        }
        return challengingDomTable;
    }
}
