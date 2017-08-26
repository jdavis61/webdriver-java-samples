package com.maineqa.pageinterfaces;

public interface IJavaScriptAlertsPage {
    void clickJSAlertButton();
    void clickJSConfirmButton();
    void clickJSPromptButton();
    String getResult();
    void closeAlert();
    void enterTextIntoPrompt(String text);

}
