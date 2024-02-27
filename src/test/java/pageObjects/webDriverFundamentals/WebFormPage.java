package pageObjects.webDriverFundamentals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.base.BasePage;

@Getter
@Slf4j
public class WebFormPage extends BasePage {

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "my-text-id")
    private WebElement textInput;
    @FindBy(css = "textarea[class='form-control']")
    private WebElement textarea;

    public WebFormPage(WebDriver driver) {
        super(driver);
    }

    public void changeSliderValue(int newValue, WebElement slider) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + newValue + "'", slider);
    }

    public void moveSliderWithArrowBy(int numberOfMoves, WebElement slider) {
        for (int i = 0; i < numberOfMoves; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public WebFormPage writeTextInInput(String text) {
        textInput.sendKeys(text);
        return this;
    }

    public WebFormPage copyTextFromTextInput() {
        textInput.sendKeys(Keys.COMMAND, "a");
        textInput.sendKeys(Keys.COMMAND, "c");
        String textValue = textInput.getAttribute("value");
        log.debug("Copied text: " + textValue);
        return this;
    }

    public WebFormPage pasteTextToTextarea(){
        textarea.sendKeys(Keys.COMMAND, "v");
        log.debug("Pasted text: " + getTextFromTextarea());
        return this;
    }
    public String getTextFromTextarea(){
        return textarea.getAttribute("value");
    }

}
