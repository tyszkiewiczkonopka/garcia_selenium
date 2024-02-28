package chapters.chapter4;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class ShadowDOMTest extends BaseTest {
    @Test
    public void should_interact_with_shadow_dom(){
        driver.get(UrlProvider.SHADOW_DOM);

        WebElement shadowHost = driver.findElement(By.id("content"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement shadowParagraph = shadowRoot.findElement(By.cssSelector("p"));

        assertThat(shadowParagraph.getText()).contains("Hello Shadow DOM");
    }
}
