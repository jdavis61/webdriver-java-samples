package com.maineqa.utilities;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetPredefinedBrowserCapabilties {

    public DesiredCapabilities getChromeDesiredCapabilities() {
        ChromeOptions options = new ChromeOptions();

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        dc.setCapability(ChromeOptions.CAPABILITY,options);
        dc.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return dc;
    }
}
