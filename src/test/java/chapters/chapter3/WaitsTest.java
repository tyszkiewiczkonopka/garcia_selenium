package chapters.chapter3;

import baseTest.BaseTest;
import helpers.ScreenshotHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import providers.UrlProvider;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class WaitsTest extends BaseTest {

    @Test
    public void should_wait_for_elements_using_implicit_wait() {
        driver.get(UrlProvider.LOADING_IMAGES);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement imageLandscape = driver.findElement(By.id("landscape"));

        assertThat(imageLandscape.getDomAttribute("src")).containsIgnoringCase("landscape");
    }

    @Test
    public void should_wait_for_elements_using_explicit_wait() {
        driver.get(UrlProvider.LOADING_IMAGES);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement imageLandscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        wait.until(ExpectedConditions.visibilityOf(imageLandscape));

        assertThat(imageLandscape.isDisplayed()).isTrue();
        ScreenshotHelper.takeScreenshot(driver,"landscape_visible");
    }
    @Test
    public void should_wait_for_elements_using_fluent_wait() {
        driver.get(UrlProvider.LOADING_IMAGES);
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement imageLandscape = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        wait.until(ExpectedConditions.visibilityOf(imageLandscape));

        assertThat(imageLandscape.isDisplayed()).isTrue();
    }

}
