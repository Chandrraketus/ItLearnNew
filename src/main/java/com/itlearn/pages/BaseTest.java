package com.itlearn.pages;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public ConfigDataProvider config;

    @BeforeClass
    public void setup()
    {
        config = new ConfigDataProvider();
        driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getSagingUrl());

    }

    @AfterClass
    public void tearDown()
    {
        BrowserFactory.quitBrowser(driver);
    }
}