package pageObjects.webDriverFundamentals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pageObjects.base.BasePage;

@Getter
@Slf4j
public class WebFormPage extends BasePage {
    Keys ctrl = SystemUtils.IS_OS_MAC ? Keys.COMMAND : Keys.CONTROL;


    @FindBy(css = "input[type='range']")
    private WebElement slider;
    @FindBy(id = "my-text-id")
    private WebElement textInput;
    @FindBy(css = "textarea[class='form-control']")
    private WebElement textarea;
    @FindBy(css = ".form-select")
    private WebElement dropdownSelect;
    @FindBy(name = "my-datalist")
    private WebElement datalist;


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
        textInput.sendKeys(ctrl, "a");
        textInput.sendKeys(ctrl, "c");
        String textValue = textInput.getAttribute("value");
        log.debug("Copied text: " + textValue);
        return this;
    }

    public WebFormPage pasteTextToTextarea() {
        textarea.sendKeys(ctrl, "v");
        log.debug("Pasted text: " + getTextFromTextarea());
        return this;
    }

    public String getTextFromTextarea() {
        return textarea.getAttribute("value");
    }



}
