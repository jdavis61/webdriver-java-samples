package com.maineqa.pageinterfaces;

import com.maineqa.pages.SecuredPage;

public interface IFormAuthentication {
    void enterLoginInformation(String usernameValue, String passwordValue);
    SecuredPage login(String usernameValue, String passwordValue);
}
