package chapters.chapter4;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import pageObjects.browserIndependentFunctionalities.FramePage;
import pageObjects.browserIndependentFunctionalities.IframePage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationTest extends BaseTest {
    @Test
    public void should_open_and_close_new_tab() {
        driver.get(UrlProvider.APP);
        String initialHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(UrlProvider.WEB_FORM);

        assertThat(driver.getWindowHandles().size()).isEqualTo(2);
        assertThat(driver.getWindowHandle()).isNotEqualTo(initialHandle);

        driver.close();
        assertThat(driver.getWindowHandles().size()).isEqualTo(1);
    }

    @Test
    public void should_get_number_of_paragraphs_in_iframe() {
        driver.get(UrlProvider.IFRAME);

        IframePage iframePage = new IframePage(driver);
        iframePage.switchToIframe();
        iframePage.waitForParagraphs();

        assertThat(iframePage.getParagraphs()).hasSize(20);
    }

    @Test
    public void should_get_number_of_paragraphs_in_frame() {
        driver.get(UrlProvider.FRAME);

        FramePage framePage = new FramePage(driver);
        framePage.switchToFrame();

        assertThat(framePage.getParagraphs()).hasSize(20);
    }

}
