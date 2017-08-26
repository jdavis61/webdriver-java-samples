package com.maineqa;

import com.maineqa.pages.FormAuthentication;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.pages.SecuredPage;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;
    private NavigationMenu navigationMenu;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = WebDriverFactory.createLocalChromeDriverInstance();
        this.navigationMenu = PageFactory.initElements(driver, NavigationMenu.class);
        this.navigationMenu.loadNavigationMenu();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Login Test")
    public void loginTest() throws InterruptedException {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        FormAuthentication formAuthentication = navigationMenu.clickFormAuthentication();

        SecuredPage securedPage = formAuthentication.login(username, password);

        Thread.sleep(5000);

    }
}

