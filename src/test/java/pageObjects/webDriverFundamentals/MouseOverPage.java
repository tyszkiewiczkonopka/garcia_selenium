package pageObjects.webDriverFundamentals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;
import pageObjects.base.BasePage;
import providers.ImageName;

import java.util.List;

public class MouseOverPage extends BasePage {

    public MouseOverPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverImage(WebElement image) {
        actions.moveToElement(image).perform();
    }


    public WebElement findImageCaption(WebElement image) {
        return driver.findElement(RelativeLocator.with(By.tagName("div")).near(image));
    }


    public WebElement findImageNameCorrespondingToCaption(String imageName) {
        return driver.findElement(By.cssSelector(
                String.format("img[src='img/%s.png']", imageName)
        ));
    }
}
