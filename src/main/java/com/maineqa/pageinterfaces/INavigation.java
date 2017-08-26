package com.maineqa.pageinterfaces;

import com.maineqa.pages.CheckboxesPage;
import com.maineqa.pages.JavaScriptAlertsPage;
import com.maineqa.pages.LoginPage;
import com.maineqa.pages.challengingdom.ChallengingDomPage;

public interface INavigation {

    LoginPage clickFormAuthentication();
    JavaScriptAlertsPage clickJavaScriptAlertsPage();
    ChallengingDomPage clickChallengingDomPage();
    CheckboxesPage clickCheckboxesPage();
}
