package com.maineqa.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class WebDriverFactory {

    public static WebDriver createLocalChromeDriverInstance() {

        Properties properties = PropertiesUtils.configurationProperties();
        String pathToChrome = System.getProperty("user.dir") + properties.getProperty("path.to.chrome.executable");
        System.setProperty("webdriver.chrome.driver", pathToChrome);

        GetPredefinedBrowserCapabilties dc = new GetPredefinedBrowserCapabilties();
        WebDriver driver = new ChromeDriver(dc.getChromeDesiredCapabilities());
        driver.manage().window().maximize();
        return driver;
    }
}
