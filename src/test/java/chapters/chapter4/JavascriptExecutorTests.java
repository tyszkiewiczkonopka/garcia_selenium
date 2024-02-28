package chapters.chapter4;

import baseTest.BaseTest;
import helpers.JavascriptHelper;
import helpers.ScreenshotHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import providers.UrlProvider;

import java.time.Duration;


public class JavascriptExecutorTests extends BaseTest {
    @Test
    public void should_scroll_by_pixels() {
        driver.get(UrlProvider.LONG_PAGE);
        JavascriptHelper.scrollByPixels(driver, 1000);

        ScreenshotHelper.takeScreenshot(driver, "scrolled");
    }

    @Test
    public void should_scroll_into_view() {
        driver.get(UrlProvider.LONG_PAGE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p:last-child")));
        JavascriptHelper.scrollIntoView(driver, footer);

        ScreenshotHelper.takeScreenshot(driver, "footer");
    }

}
