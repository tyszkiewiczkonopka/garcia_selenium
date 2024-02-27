package chapters.chapter3;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import pageObjects.webDriverFundamentals.WebFormPage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
public class CopyPasteTest extends BaseTest {
    @Test
    public void should_copy_paste_using_keyboard() {
        WebFormPage webFormPage = new WebFormPage(driver);

        driver.get(UrlProvider.WEB_FORM);
        String text = "blablabla";

        webFormPage
                .writeTextInInput(text)
                .copyTextFromTextInput()
                .pasteTextToTextarea();

        assertThat(webFormPage.getTextFromTextarea()).isEqualTo(text);

    }
}
