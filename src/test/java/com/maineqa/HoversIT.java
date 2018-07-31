package com.maineqa;

import com.maineqa.pageinterfaces.ITestSetupTeardown;
import com.maineqa.pages.HoversPage;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.utilities.SleepUtils;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoversTest implements ITestSetupTeardown {

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
    public void hoverTest() {
        navigationMenu.loadNavigationMenu();
        HoversPage hoversPage = navigationMenu.clickHoversPage();
        Assert.assertEquals(hoversPage.getPageHeader(), "Hovers");

        for (int i=0; i<3; i++) {
            hoversPage.hoverOverImageOne();
            Assert.assertEquals(hoversPage.getUserName(i), "user" + (i+1));
            hoversPage.clickViewProfile(i);
            hoversPage.returnToHoversPage();
        }
    }

}
