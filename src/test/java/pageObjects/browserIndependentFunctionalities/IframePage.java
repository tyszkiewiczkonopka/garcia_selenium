package pageObjects.browserIndependentFunctionalities;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.base.BasePage;

import java.util.List;

@Getter
public class IframePage extends BasePage {
    public IframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "my-iframe")
    private WebElement iframe;
    @FindBy(tagName = "p")
    private List<WebElement> paragraphs;

    public void switchToIframe(){
        defaultWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
    public void waitForParagraphs(){
        defaultWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("p"),0));
    }
}
