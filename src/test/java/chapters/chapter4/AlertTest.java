package chapters.chapter4;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.browserIndependentFunctionalities.AlertsPage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertTest extends BaseTest {

    @Test
    public void should_accept_alert() {
        driver.get(UrlProvider.DIALOG_BOXES);

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlert(alertsPage.getOkAlert());
        String alertText = alertsPage.switchToAndAcceptAlert();

        assertThat(alertText).isEqualTo("Hello world!");

    }

    @Test
    public void should_dismiss_alert() {
        driver.get(UrlProvider.DIALOG_BOXES);

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlert(alertsPage.getConfirmAlert());
        String alertText = alertsPage.switchToAndDismissAlert();

        assertThat(alertText).isEqualTo("Is this correct?");

    }

    @Test
    public void should_show_text_that_was_typed_by_user_in_prompt() {
        driver.get(UrlProvider.DIALOG_BOXES);
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.openAlert(alertsPage.getPromptAlert());

        String promptText = "Magda";
        alertsPage.switchToAndWriteInPrompt(promptText);

        assertThat(alertsPage.getPromptText()).contains(promptText);

    }
    //todo: finish
    @Test
    public void should_blur_page_under_modal(){
        driver.get(UrlProvider.DIALOG_BOXES);
        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.getModal().click();

        assertThat(alertsPage.getModal()
                .getDomAttribute("style"))
                .contains("block");
       // alertsPage.getCloseModalButton().click();
    }
}
