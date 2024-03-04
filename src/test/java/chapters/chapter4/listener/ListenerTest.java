package chapters.chapter4.listener;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ListenerTest extends BaseTest {
    private WebDriver decoratedDriver;

    @BeforeEach
    void listenerSetup() {
        MyCustomEventListener listener = new MyCustomEventListener();
        decoratedDriver = new EventFiringDecorator<>(listener).decorate(driver);
    }
    @AfterEach
    void listenerTeardown(){
        decoratedDriver.quit();
    }

    @Test
    public void should_include_custom_listener_methods() {
        decoratedDriver.get(UrlProvider.APP);
        assertThat(decoratedDriver.getTitle()).isEqualTo("Hands-On Selenium WebDriver with Java");
        decoratedDriver.findElement(By.linkText("Web form")).click();
    }
}
