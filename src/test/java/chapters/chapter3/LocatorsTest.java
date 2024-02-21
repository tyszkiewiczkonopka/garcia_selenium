package chapters.chapter3;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import providers.UrlProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

@Slf4j
public class LocatorsTest extends BaseTest {
    @Test
    public void test_by_tagname() {
        driver.get(UrlProvider.WEB_FORM);
        WebElement textarea = driver.findElement(By.tagName("textarea"));

        assertThat(textarea.getDomAttribute("rows")).isEqualTo("3");
    }

    @Test
    public void by_html_attribute() {
        driver.get(UrlProvider.WEB_FORM);
        WebElement textByName = driver.findElement(By.name("my-text"));
        assertThat(textByName.isEnabled()).isTrue();

        // ID
        WebElement textById = driver.findElement(By.id("my-text-id"));

        assertThat(textById.getAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomAttribute("type")).isEqualTo("text");
        assertThat(textById.getDomProperty("type")).isEqualTo("text");

        // CLASS
        List<WebElement> byClassName = driver.findElements(By.className("form-control"));

        assertThat(byClassName.size()).isPositive();
        assertThat(byClassName.get(0).getAttribute("name")).isEqualTo("my-text");
    }

    @Test
    public void by_Css() {
        driver.get(UrlProvider.WEB_FORM);

        // ATRIBUTE VALUE
        WebElement hiddenInput = driver.findElement(By.cssSelector("input[type=hidden]"));
        assertThat(hiddenInput.isDisplayed()).isFalse(); // check if the input is not displayed, as it should be with [type=hidden]

        // PARTIAL VALUE
        WebElement readonlyInput = driver.findElement(By.cssSelector("input[value~=input]"));
        String readonlyInputClass = readonlyInput.getDomAttribute("class");
        assertThat(readonlyInputClass).contains("form-control");

        // IS EQUAL OR STARTS WITH
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[id|='my-check']"));
        assertThat(checkboxes.size()).isEqualTo(2);

        // STARTS WITH
        List<WebElement> myElements = driver.findElements(By.cssSelector("input[name^='my']"));
        boolean isMyFilePresent = myElements.stream()
                .anyMatch(element -> element.getDomAttribute("name").equals("my-file"));
        assertTrue(isMyFilePresent);

        // ENDS WITH
        WebElement pngFile = driver.findElement(By.cssSelector("[src$='png']"));
        assertThat(pngFile.getCssValue("cursor")).isEqualTo("pointer");

        // CONTAINS A STRING
        List<WebElement> garciaLinks = driver.findElements(By.cssSelector("a[href*='garcia']"));
        WebElement secondColumn = driver.findElement(By.cssSelector(".text-muted"));
        assertThat(secondColumn.findElements(By.tagName("a")))
                .filteredOn(WebElement::isDisplayed)
                .contains(garciaLinks.get(1));
    }

    @Test
    public void advanced_classes() {
        driver.get(UrlProvider.WEB_FORM);

        // BY ID OR NAME
        WebElement element = driver.findElement(new ByIdOrName("my-check"));
        assertThat(element.getDomAttribute("name")).isEqualTo("my-check");

        // BY ALL, COMBINE LOCATORS
        List<WebElement> allTextElements = driver.findElements(new ByAll(By.cssSelector("[type=text]"), By.cssSelector("[name*='text']")));
        for (WebElement textElement : allTextElements) {
            String tagName = textElement.getTagName();
            String text = textElement.getText();
            String attributeValue = textElement.getAttribute("name");

            log.debug("Text Element - Tag: {}, Text: {}, Name Attribute: {}", tagName, text, attributeValue);
        }
        assertThat(allTextElements.size()).isEqualTo(6);
    }

    @Test
    public void relative_locators() {
        driver.get(UrlProvider.WEB_FORM);

        // ABOVE
        WebElement passwordInput = driver.findElement(By.name("my-password"));
        WebElement textInput = driver.findElement(with(By.name("my-text")).above(passwordInput));
        textInput.sendKeys("bla");

        // TO THE RIGHT
        WebElement datalist = driver.findElement(with(By.name("my-datalist")).toRightOf(passwordInput));
        datalist.sendKeys("e");

    }
}
