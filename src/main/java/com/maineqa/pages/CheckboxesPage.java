package com.maineqa.pages;

import com.maineqa.pageinterfaces.ICheckboxesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage implements ICheckboxesPage {

    @FindBy(tagName = "input")
    List<WebElement> checkboxes;

    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector("#checkboxes");

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement checkboxOne() {
        return checkboxes.get(0);
    }

    @Override
    public WebElement checkboxTwo() {
        return checkboxes.get(1);
    }


}
