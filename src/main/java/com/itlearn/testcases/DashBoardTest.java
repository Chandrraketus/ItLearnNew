package com.itlearn.testcases;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcel;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashBoardTest extends BaseTest {
    String fileName = System.getProperty("user.dir") + "\\testData\\Book1.xlsx";

    @Test
    public void DashBoardTest() throws IOException {
        LoginPage lp = new LoginPage(driver);
        String username = ReadExcel.getCellValue(fileName, "Sheet1", 1, 0);
        String password = ReadExcel.getCellValue(fileName, "Sheet1", 1, 1);
        lp.loginPortal(username, password);

        DashBoardPage dp = new DashBoardPage(driver);
        dp.dashboardclick();
    }
}