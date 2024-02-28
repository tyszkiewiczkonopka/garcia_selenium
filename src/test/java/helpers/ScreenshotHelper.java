package helpers;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Slf4j
public class ScreenshotHelper {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotPath = "src/test/resources/filesDownloaded/" + fileName + ".png";
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            log.info("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            log.error("Error taking screenshot: " + e.getMessage());
        }
    }

    public static void takeElementScreenshot(WebElement element, String fileName) {
        File screenshotFile = element.getScreenshotAs(OutputType.FILE);

        try {
            String screenshotPath = "src/test/resources/filesDownloaded/" + fileName + ".png";
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            log.info("Screenshot saved at: " + screenshotPath);
        } catch (IOException e) {
            log.error("Error taking screenshot: " + e.getMessage());
        }
    }
}
