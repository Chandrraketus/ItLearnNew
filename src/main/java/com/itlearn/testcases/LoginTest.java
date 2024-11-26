package com.itlearn.testcases;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    void verifyLogin()
    {
        LoginPage lp = new LoginPage(driver);

        String username = "sharma123ronit@gmai.com";
        String password ="Ronit@123";
        lp.loginPortal(username,password);


    }

}