package chapters.chapter3;

import baseTest.BaseTest;
import helpers.ScreenshotHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pageObjects.webDriverFundamentals.WebFormPage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SliderTest extends BaseTest {

    @Test
    public void should_move_slider_with_javascriptexecutor() {
        driver.get(UrlProvider.WEB_FORM);

        WebFormPage webFormPage = new WebFormPage(driver);
        String initialSliderValue = webFormPage.getSlider().getDomAttribute("value");
        log.debug("Initial slider value is: " + initialSliderValue);

        int newValue = 7;
        webFormPage.changeSliderValue(newValue, webFormPage.getSlider());
        String newSliderValue = webFormPage.getSlider().getDomAttribute("value");
        log.debug("Expected slider value: " + newValue);
        log.debug("Actual slider value: " + newSliderValue);

        ScreenshotHelper.takeScreenshot(driver, "slider_js");
        ScreenshotHelper.takeElementScreenshot(webFormPage.getSlider(), "slider_js_element");

        assertThat(initialSliderValue).isNotEqualTo(newSliderValue);
    }

    @Test
    public void should_move_slider_with_arrow() {
        WebFormPage webFormPage = new WebFormPage(driver);

        driver.get(UrlProvider.WEB_FORM);
        String initialSliderValue = webFormPage.getSlider().getDomAttribute("value");
        log.debug("Initial slider value is: " + initialSliderValue);

        webFormPage.moveSliderWithArrowBy(2, webFormPage.getSlider());
        String newSliderValue = webFormPage.getSlider().getDomAttribute("value");
        log.debug("New slider value is: " + newSliderValue);

        ScreenshotHelper.takeScreenshot(driver, "slider_arrow");
        ScreenshotHelper.takeElementScreenshot(webFormPage.getSlider(), "slider_arrow_element");

        assertThat(initialSliderValue).isNotEqualTo(newSliderValue);
    }

}
