package com.maineqa;

import com.maineqa.pageinterfaces.ITestSetupTeardown;
import com.maineqa.pages.HoversPage;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.pages.challengingdom.ChallengingDomPage;
import com.maineqa.pages.challengingdom.ChallengingDomRow;
import com.maineqa.pages.challengingdom.ChallengingDomTable;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengingDomIT implements ITestSetupTeardown {

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
        ChallengingDomPage challengingDomPage = navigationMenu.clickChallengingDomPage();
        Assert.assertEquals(challengingDomPage.getPageHeader(), "Challenging DOM");

        ChallengingDomTable table = challengingDomPage.getTable();
        ChallengingDomRow row = table.getRow(0);

        Assert.assertEquals(row.getLorem(), "Iuvaret0");
        Assert.assertEquals(row.getIpsum(), "Apeirian0");
        Assert.assertEquals(row.getDolor(), "Adipisci0");
        Assert.assertEquals(row.getSit(), "Definiebas0");
        Assert.assertEquals(row.getAmet(), "Consequuntur0");
        Assert.assertEquals(row.getDiceret(), "Phaedrum0");

        row = table.getRow(9);
        Assert.assertEquals(row.getLorem(), "Iuvaret9");
        Assert.assertEquals(row.getIpsum(), "Apeirian9");
        Assert.assertEquals(row.getDolor(), "Adipisci9");
        Assert.assertEquals(row.getSit(), "Definiebas9");
        Assert.assertEquals(row.getAmet(), "Consequuntur9");
        Assert.assertEquals(row.getDiceret(), "Phaedrum9");
    }

}
