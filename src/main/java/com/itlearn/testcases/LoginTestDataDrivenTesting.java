package com.itlearn.testcases;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.LoginPage;
import com.itlearn.utility.ReadExcel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestDataDrivenTesting extends BaseTest { // Assuming BaseTest initializes the WebDriver

    String fileName = System.getProperty("user.dir") + "\\testData\\Book1.xlsx";

    @Test(priority = 1, dataProvider = "LoginDataProvider")
    public void verifyLogin(String userEmail, String userPwd) throws IOException {
        // Assuming LoginPage is a valid class
        LoginPage lp = new LoginPage(driver); // Ensure 'driver' is initialized in BaseTest

        // Use the provided userEmail and userPwd to log in
        lp.loginPortal(userEmail, userPwd);

        if (userEmail.equals("sharma123ronit@gmail.com")&&userPwd.equals("Ronit@123"))
        {
            System.out.println("Test Passed");
            Assert.assertTrue(true);
            lp.logout();

        }
        else
        {
            CaptureScreenShot(driver,"verifyLogin");
            Assert.assertTrue(false);
        }
    }

    @DataProvider(name = "LoginDataProvider")
    public Object[][] LoginDataProvider() throws IOException {
        // Read row and column counts from the Excel file
        int ttlRows = ReadExcel.getRowCount(fileName, "Sheet1");
        int ttlColumns = ReadExcel.getColCount(fileName, "Sheet1");

        // Initialize the data array
        String[][] data = new String[ttlRows - 1][ttlColumns];

        // Fill the data array with values from the Excel file
        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                data[i - 1][j] = ReadExcel.getCellValue(fileName, "Sheet1", i, j);
            }
        }

        return data;
    }
}