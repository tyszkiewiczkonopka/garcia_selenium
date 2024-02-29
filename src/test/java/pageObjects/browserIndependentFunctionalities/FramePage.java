package pageObjects.browserIndependentFunctionalities;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.base.BasePage;

import java.time.Duration;
import java.util.List;
@Getter
public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "frame-body")
    private WebElement frame;
    @FindBy(tagName = "p")
    private List<WebElement> paragraphs;

    public void switchToFrame(){
        defaultWait.until(ExpectedConditions.presenceOfElementLocated(By.name("frame-body")));
        driver.switchTo().frame(frame);
    }
    public void waitForParagraphs(){
        defaultWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("p"),0));
    }

}
