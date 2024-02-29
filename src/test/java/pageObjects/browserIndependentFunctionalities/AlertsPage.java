package pageObjects.browserIndependentFunctionalities;

import lombok.Getter;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.base.BasePage;

import java.time.Duration;

@Getter
public class AlertsPage extends BasePage {
    @FindBy(id = "my-alert")
    private WebElement okAlert;
    @FindBy(id = "my-confirm")
    private WebElement confirmAlert;
    @FindBy(id = "my-prompt")
    private WebElement promptAlert;
    @FindBy(id = "prompt-text")
    private WebElement textFromPrompt;
    @FindBy(id = "my-modal")
    private WebElement modal;
    @FindBy(css = "#example-modal button:first-of-type")
    private WebElement closeModalButton;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void openAlert(WebElement alertType) {
        alertType.click();
        defaultWait.until(ExpectedConditions.alertIsPresent());
    }


    public String switchToAndAcceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public String switchToAndDismissAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        return alertText;
    }

    public void switchToAndWriteInPrompt(String promptText) {
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(promptText);
        prompt.accept();
    }

    public String getPromptText() {
        return textFromPrompt.getText();
    }
}
