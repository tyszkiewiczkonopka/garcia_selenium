import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class HelloWorld {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void test() {
        String url = "https://bonigarcia.dev/selenium-webdriver-java/";
        driver.get(url);
        String pageTitle = driver.getTitle();

        log.debug("The title of {} is {}", url, pageTitle);

        assertThat(pageTitle).isEqualTo("Hands-On Selenium WebDriver with Java");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
