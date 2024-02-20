package chapters.chapter3;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import providers.UrlProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFormTest extends BaseTest {
    @Test
    public void test_by_tagname() {
        driver.get(UrlProvider.WEB_FORM);
        WebElement textarea = driver.findElement(By.tagName("textarea"));

        assertThat(textarea.getDomAttribute("rows")).isEqualTo("3");
    }

    @Test
    public void test_by_html_attribute(){
        driver.get(UrlProvider.WEB_FORM);
        WebElement textByName = driver.findElement(By.name("my-text"));
        assertThat(textByName.isEnabled()).isTrue();

        // Na podstawie identyfikatora id
        WebElement textById = driver.findElement(By.id("my-text-id"));
        assertThat(textById.getAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomProperty("type")).isEqualTo("text");

        assertThat(textById.getAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomAttribute("myprop")).isEqualTo("myvalue");
        assertThat(textById.getDomProperty("myprop")).isNull();

        // Na podstawie nazwy klasy
        List<WebElement> byClassName = driver
                .findElements(By.className("form-control"));
        assertThat(byClassName.size()).isPositive();
        assertThat(byClassName.get(0).getAttribute("name"))
                .isEqualTo("my-text");
    }

}
