package com.maineqa.pages;

import com.maineqa.pageinterfaces.IHoversPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HoversPage extends BasePage implements IHoversPage {

    @FindBy(className = "figure")
    private List<WebElement> icons;

    @FindBy(className = "figcaption")
    private List<WebElement> figureCaptions;


    public static final By SCREEN_PRESENCE_LOCATOR = By.cssSelector(".figure");
    private Actions actions;

    public HoversPage(WebDriver driver) {
        super(driver);
        this.actions = new Actions(driver);

    }

    @Override
    public void hoverOverImage(int position) {
        actions.moveToElement(icons.get(position)).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOf(figureCaptions.get(position)));
    }

    @Override
    public String getUserName(int position) {
        hoverOverImage(position);
        return figureCaptions.get(position).findElement(By.tagName("h5")).getText().replaceAll("name: ", "");
    }
}
