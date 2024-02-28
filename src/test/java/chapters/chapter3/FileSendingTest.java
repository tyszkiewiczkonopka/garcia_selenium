package chapters.chapter3;

import baseTest.BaseTest;
import helpers.ScreenshotHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import providers.UrlProvider;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
public class FileSendingTest extends BaseTest {
    @Test
    public void should_upload_file() {
        String initialUrl = UrlProvider.WEB_FORM;
        driver.get(UrlProvider.WEB_FORM);
        String relativePath = "src/test/resources/filesForUpload/websockets.png";
        String absolutePath = new File(relativePath).getAbsolutePath();

        WebElement fileInput = driver.findElement(By.name("my-file"));
        fileInput.sendKeys(absolutePath);
        driver.findElement(By.tagName("form")).submit();

        log.debug("Initial URL was {}", initialUrl);
        log.debug("Current URL is {}", driver.getCurrentUrl());

        assertThat(driver.getCurrentUrl()).isNotEqualTo(initialUrl);
    }
}
