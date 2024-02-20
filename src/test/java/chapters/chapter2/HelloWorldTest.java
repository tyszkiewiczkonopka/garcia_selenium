package chapters.chapter2;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HelloWorldTest extends BaseTest {

    @Test
    public void test_website_title() {
        String url = UrlProvider.APP;
        driver.get(url);
        String pageTitle = driver.getTitle();
        log.debug("The title of {} is {}", url, pageTitle);

        assertThat(pageTitle).isEqualTo("Hands-On Selenium WebDriver with Java");
    }



}
