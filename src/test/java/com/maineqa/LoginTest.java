package com.maineqa;

import com.maineqa.pages.FormAuthentication;
import com.maineqa.pages.NavigationMenu;
import com.maineqa.pages.SecuredPage;
import com.maineqa.utilities.WebDriverFactory;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

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
    public void loginTest() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        String subheading = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";

        FormAuthentication formAuthentication = navigationMenu.clickFormAuthentication();
        Assert.assertEquals(formAuthentication.getFooterText(), "Powered by Elemental Selenium");
        Assert.assertEquals(formAuthentication.getPageSubHeader(), subheading);
        Assert.assertEquals(formAuthentication.getPageHeader(), "Login Page");

        SecuredPage securedPage = formAuthentication.login(username, password);
        Assert.assertEquals(securedPage.getPageHeader(), "Secure Area");
        Assert.assertEquals(securedPage.getFooterText(), "Powered by Elemental Selenium");
    }

    @Test(description = "Validation Message Test")
    public void validationMessageTest() {
        String username = "tomsmith";
        String incorrectUsername = "timsmith";
        String incorrectPassword = "qwerty100";
        String usernameErrorMessage = "Your username is invalid!";
        String passwordErrorMessage = "Your password is invalid!";

        FormAuthentication formAuthentication = navigationMenu.clickFormAuthentication();

        // enter incorrect username
        formAuthentication.username.sendKeys(incorrectUsername);
        formAuthentication.clickSubmitButton();
        Assert.assertEquals(formAuthentication.getPageMessage(), usernameErrorMessage);

        // enter incorrect password
        formAuthentication.username.sendKeys(username);
        formAuthentication.password.sendKeys(incorrectPassword);
        formAuthentication.clickSubmitButton();
        Assert.assertEquals(formAuthentication.getPageMessage(), passwordErrorMessage);

        // submit blank password
        formAuthentication.enterLoginInformation("", "");
        formAuthentication.clickSubmitButton();
        Assert.assertEquals(formAuthentication.getPageMessage(), usernameErrorMessage);
    }

    @Test(description = "Validation Message Test")
    public void closeValidationMessageTest() {
        String incorrectUsername = "timsmith";
        String incorrectPassword = "qwerty100";
        String usernameErrorMessage = "Your username is invalid!";

        FormAuthentication formAuthentication = navigationMenu.clickFormAuthentication();
        formAuthentication.enterLoginInformation(incorrectUsername, incorrectPassword);
        formAuthentication.clickSubmitButton();
        Assert.assertEquals(formAuthentication.getPageMessage(), usernameErrorMessage);
        formAuthentication.closePageMessage();

        boolean isCloseButtonClicked = false;
        try {
            formAuthentication.closePageMessage();
            isCloseButtonClicked = true;
        } catch (NoSuchElementException e) {
            Assert.assertEquals(isCloseButtonClicked, false);
        }


    }
}

