package com.itlearn.pages;

import com.itlearn.utility.BrowserFactory;
import com.itlearn.utility.ConfigDataProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public ConfigDataProvider config;

    @BeforeClass
    public void setup() {
        config = new ConfigDataProvider();
        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getSagingUrl());

    }
//
//    @AfterClass
//    public void tearDown() {
//        BrowserFactory.quitBrowser(driver);
//    }

    public void CaptureScreenShot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath = new File(".","//Screenshot//"+testName+".png");
        System.out.println("This is screenshot section");
        FileUtils.copyFile(src,srcpath);
    }
}