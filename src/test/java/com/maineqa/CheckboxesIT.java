package com.maineqa;

import com.maineqa.pageinterfaces.ITestSetupTeardown;
import com.maineqa.pages.CheckboxesPage;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxesIT implements ITestSetupTeardown {

    private WebDriver driver;
    private NavigationMenu navigationMenu;

    @Override
    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = WebDriverFactory.createLocalChromeDriverInstance();
        this.navigationMenu = PageFactory.initElements(driver, NavigationMenu.class);
    }

    @Override
    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkboxesTest() {
        navigationMenu.loadNavigationMenu();
        CheckboxesPage checkboxesPage = navigationMenu.clickCheckboxesPage();
        Assert.assertEquals(checkboxesPage.checkboxOne().isSelected(), false);
        Assert.assertEquals(checkboxesPage.checkboxTwo().isSelected(), true);

        checkboxesPage.checkboxOne().click();
        checkboxesPage.checkboxTwo().click();

        Assert.assertEquals(checkboxesPage.checkboxOne().isSelected(), true);
        Assert.assertEquals(checkboxesPage.checkboxTwo().isSelected(), false);

        checkboxesPage.checkboxOne().click();
        Assert.assertEquals(checkboxesPage.checkboxOne().isSelected(), false);
        Assert.assertEquals(checkboxesPage.checkboxTwo().isSelected(), false);

        checkboxesPage.checkboxOne().click();
        checkboxesPage.checkboxTwo().click();

        Assert.assertEquals(checkboxesPage.checkboxOne().isSelected(), true);
        Assert.assertEquals(checkboxesPage.checkboxTwo().isSelected(), true);
    }
}
