package com.itlearn.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Watchable;
import java.time.Duration;
import java.util.List;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='payment_method_stripe']")
    WebElement paystipe;

    @FindBy(xpath ="//DIV[@class='place-order-action']")
    WebElement placeOrder;


    //WebElement placeOrder;




    @FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe")
    WebElement frameelement;


    @FindBy(name = "cardnumber")
    WebElement cardnum;

    @FindBy(name = "exp-date")
    WebElement expdate;

    @FindBy(name = "cvc")
    WebElement CVC;

    @FindBy(name = "postal")
    WebElement postalcode;

    @FindBy(xpath = "//button[@id='payment-button']")
    WebElement paybtn;


    public void paymentOptions(String cardnumber,String exp,String cvc,String pstlcode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", placeOrder);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder)).click();
        ;
        {
            paystipe.click();
            placeOrder.click();

        driver.switchTo().frame(frameelement);
        cardnum.sendKeys(cardnumber);
        expdate.sendKeys(exp);
        CVC.sendKeys(cvc);
        postalcode.sendKeys(pstlcode);

        driver.switchTo().defaultContent();
        paybtn.click();
        }

    }
}
