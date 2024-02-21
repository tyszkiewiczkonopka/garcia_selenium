package chapters.chapter3;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SliderTest extends BaseTest {

    @Test
    public void should_move_slider_with_javascriptexecutor() throws InterruptedException {
        driver.get(UrlProvider.WEB_FORM);
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        String initialSliderValue = slider.getDomAttribute("value");
        log.debug("Initial slider value is: " + initialSliderValue);
        Thread.sleep(3000);

        changeSliderValue(7, slider);

        String newSliderValue = slider.getDomAttribute("value");
        log.debug("New slider value is: " + newSliderValue);

        assertThat(initialSliderValue).isNotEqualTo(newSliderValue);
    }

    @Test
    public void should_move_slider_with_arrow() throws InterruptedException {
        driver.get(UrlProvider.WEB_FORM);
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        String initialSliderValue = slider.getDomAttribute("value");
        log.debug("Initial slider value is: " + initialSliderValue);
        Thread.sleep(3000);

        moveSliderWithArrowBy(2, slider);

        String newSliderValue = slider.getDomAttribute("value");
        log.debug("New slider value is: " + newSliderValue);

        assertThat(initialSliderValue).isNotEqualTo(newSliderValue);

    }

    private void changeSliderValue(int newValue, WebElement slider) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + newValue + "'", slider);
    }

    private void moveSliderWithArrowBy(int numberOfMoves, WebElement slider){
        for(int i = 0; i < numberOfMoves; i++){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

}
