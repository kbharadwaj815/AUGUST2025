package com.orangehrm.tests;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.Base.BaseTest;
import com.orangehrm.pages.Loginpage;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.Screenshotutilities;

public class LoginOrangeHRM extends BaseTest {

    static String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "logindata")
    public void verifylogin(String username, String password) throws IOException, ParserConfigurationException, SAXException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        test = extent.createTest("Login with the user: " + username);

        Loginpage obj = new Loginpage(driver);  // constructor throws checked exceptions, so declare or catch
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();

        if (obj.dashisdisplayed()) {
            test.pass("Login is successful for user: " + username);
        } else {
            test.fail("Login unsuccessful for user: " + username)
                .addScreenCaptureFromPath(Screenshotutilities.Capture(driver, "Verify_login_" + username));
        }

        if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
            test.pass("Title matched");
        } else {
            test.fail("Title did not match")
                .addScreenCaptureFromPath(Screenshotutilities.Capture(driver, "Verify_login_title_" + username));
        }
    }

    @DataProvider
    public Object[][] logindata() throws IOException {
        return ExcelUtilities.getdata(projectpath + "C:\\Users\\kesha\\eclipse-workspace\\CGI_AUG2025\\src\\test\\resources\\Orangehrm_testdata\\data.xlsx", "Sheet1");
    }
}
