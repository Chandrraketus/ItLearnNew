package com.itlearn.testcases;

import com.itlearn.pages.BaseTest;
import com.itlearn.pages.DashBoardPage;
import com.itlearn.pages.LoginPage;
import com.itlearn.pages.PaymentPage;
import com.itlearn.utility.ReadExcel;
import org.testng.annotations.Test;

import java.io.IOException;

public class PaymentTestCase extends BaseTest {
    String fileName = System.getProperty("user.dir") + "\\testData\\Book1.xlsx";

    @Test
    public void DashBoardTest() throws IOException {
        // Create instance of LoginPage and login using credentials from Excel
        LoginPage lp = new LoginPage(driver);
        String username = ReadExcel.getCellValue(fileName, "Sheet1", 1, 0);
        String password = ReadExcel.getCellValue(fileName, "Sheet1", 1, 1);
        lp.loginPortal(username, password);

        // Navigate to Dashboard
        DashBoardPage dp = new DashBoardPage(driver);
        dp.dashboardclick();

        // Create instance of PaymentPage and proceed with payment
        PaymentPage pg = new PaymentPage(driver);
        String cardnumber = ReadExcel.getCellValue(fileName, "CardDetails", 0, 0);
        String exp = ReadExcel.getCellValue(fileName, "CardDetails", 0, 1);
        String cvc = ReadExcel.getCellValue(fileName, "CardDetails", 0, 2);
        String pstlcode = ReadExcel.getCellValue(fileName, "CardDetails", 0, 3);

        pg.paymentOptions(cardnumber, exp,cvc,pstlcode);
    }
}
