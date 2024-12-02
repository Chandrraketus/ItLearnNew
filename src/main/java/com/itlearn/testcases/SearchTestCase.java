package com.itlearn.testcases;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.Searchpages;
import com.itlearn.utility.ReadExcel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SearchTestCase extends BaseTest {
    String fileName = System.getProperty("user.dir") + "\\testData\\Book1.xlsx";
@Test
     public void SearchTestCase() throws IOException {
        LoginPage lp = new LoginPage(driver);
        String username = ReadExcel.getCellValue(fileName,"Sheet1",1,0);
        String password = ReadExcel.getCellValue(fileName,"Sheet1",1,1);
        lp.loginPortal(username,password);

    Searchpages sp = new Searchpages(driver);
    String SearchCourse = ReadExcel.getCellValue(fileName,"SearchCourse",0,0);
    sp.searchCourse(SearchCourse);



    }

}