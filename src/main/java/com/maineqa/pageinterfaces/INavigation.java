package com.maineqa.pageinterfaces;

import com.maineqa.pages.JavaScriptAlertsPage;
import com.maineqa.pages.LoginPage;

public interface INavigation {

    LoginPage clickFormAuthentication();
    JavaScriptAlertsPage clickJavaScriptAlertsPage();
}
