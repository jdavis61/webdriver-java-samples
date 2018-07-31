package com.maineqa;

import com.maineqa.pageinterfaces.ITestSetupTeardown;
import com.maineqa.pages.LoginPage;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.pages.SecuredPage;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest implements ITestSetupTeardown {

    private WebDriver driver;
    private NavigationMenu navigationMenu;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        this.driver = WebDriverFactory.createLocalChromeDriverInstance();
        this.navigationMenu = PageFactory.initElements(driver, NavigationMenu.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void loadNavigationMenu() {
        navigationMenu.loadNavigationMenu();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @Test(description = "Login Test")
    public void loginLogoutTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String subheading = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

        LoginPage loginPage = navigationMenu.clickFormAuthentication();
        Assert.assertEquals(loginPage.getFooterText(), "Powered by Elemental Selenium");
        Assert.assertEquals(loginPage.getPageSubHeader(), subheading);
        Assert.assertEquals(loginPage.getPageHeader(), "Login Page");

        SecuredPage securedPage = loginPage.login(username, password);
        Assert.assertEquals(securedPage.getPageMessage(), "You logged into a secure area!");
        Assert.assertEquals(securedPage.getPageHeader(), "Secure Area");
        Assert.assertEquals(securedPage.getFooterText(), "Powered by Elemental Selenium");

        securedPage.clickLogout();
        Assert.assertNotEquals(securedPage.getPageHeader(), "Secure Area");
        Assert.assertEquals(loginPage.getPageMessage(), "You logged out of the secure area!");

    }

    @Test(description = "Validation Message Test")
    public void validationMessageTest() {
        String username = "tomsmith";
        String incorrectUsername = "timsmith";
        String incorrectPassword = "qwerty100";
        String usernameErrorMessage = "Your username is invalid!";
        String passwordErrorMessage = "Your password is invalid!";

        LoginPage loginPage = navigationMenu.clickFormAuthentication();

        // enter incorrect username
        loginPage.username.sendKeys(incorrectUsername);
        loginPage.clickSubmitButton();
        Assert.assertEquals(loginPage.getPageMessage(), usernameErrorMessage);

        // enter incorrect password
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(incorrectPassword);
        loginPage.clickSubmitButton();
        Assert.assertEquals(loginPage.getPageMessage(), passwordErrorMessage);

        // submit blank password
        loginPage.enterLoginInformation("", "");
        loginPage.clickSubmitButton();
        Assert.assertEquals(loginPage.getPageMessage(), usernameErrorMessage);
    }

    @Test(description = "Validation Message Test")
    public void closeValidationMessageTest() {
        String incorrectUsername = "timsmith";
        String incorrectPassword = "qwerty100";
        String usernameErrorMessage = "Your username is invalid!";

        LoginPage loginPage = navigationMenu.clickFormAuthentication();
        loginPage.enterLoginInformation(incorrectUsername, incorrectPassword);
        loginPage.clickSubmitButton();
        Assert.assertEquals(loginPage.getPageMessage(), usernameErrorMessage);
        loginPage.closePageMessage();

        boolean isCloseButtonClicked = false;
        try {
            loginPage.closePageMessage();
            isCloseButtonClicked = true;
        } catch (NoSuchElementException e) {
            Assert.assertEquals(isCloseButtonClicked, false);
        }


    }
}

