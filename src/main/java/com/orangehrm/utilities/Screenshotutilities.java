
	
package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutilities {
    public static String Capture(WebDriver driver, String screenshotName) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        File dest = new File(path);
        FileUtils.copyFile(src, dest);
        return path;
    }
}

