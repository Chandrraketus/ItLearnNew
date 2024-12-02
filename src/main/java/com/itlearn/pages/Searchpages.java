package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpages {
    WebDriver driver;
    public Searchpages(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver,this);
    }


    @FindBy(name = "search_course")
    WebElement searchinput;

    @FindBy(xpath = "//nav[@role='navigation']//button")
    WebElement searchbutton;

    public void searchCourse(String courseName)
    {
        searchinput.sendKeys(courseName);
        searchbutton.click();
    }





}
