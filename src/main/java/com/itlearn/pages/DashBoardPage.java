package com.itlearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;

    public DashBoardPage(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class = \"lg_button\"]")
    WebElement Dashboard;
    @FindBy(xpath = "//a[contains(text(),'Offered Academies')]")
    WebElement offerAcadics;
    @FindBy(xpath = "(//button[contains(text(),'Subscribe Now')])[2]")
    WebElement Subnow;

    public void dashboardclick()
        {
            Dashboard.click();
            offerAcadics.click();
            Subnow.click();
        }
}
