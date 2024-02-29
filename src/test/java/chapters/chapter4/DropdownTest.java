package chapters.chapter4;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.webDriverFundamentals.WebFormPage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DropdownTest extends BaseTest {
    @Test
    public void should_select_by_visible_text_from_dropdown() {
        WebFormPage webFormPage = new WebFormPage(driver);
        driver.get(UrlProvider.WEB_FORM);

        Select select = new Select(webFormPage.getDropdownSelect());
        String optionText = "Two";
        select.selectByVisibleText(optionText);

        assertThat(select.getFirstSelectedOption().getText()).isEqualTo(optionText);
        assertThat(select.isMultiple()).isFalse();
    }

    @Test
    public void should_select_by_value_from_datalist() {
        WebFormPage webFormPage = new WebFormPage(driver);
        driver.get(UrlProvider.WEB_FORM);

        WebElement datalist = webFormPage.getDatalist();
        datalist.click();
        int optionNumber = 2;
        WebElement option = driver.findElement(By.cssSelector("datalist option:nth-of-type(" + optionNumber + ")"));
        String optionValue = option.getAttribute("value");
        datalist.sendKeys(optionValue);
        assertThat(optionValue).isEqualTo("New York");
    }

}
