package chapters.chapter3;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.webDriverFundamentals.MouseOverPage;
import providers.ImageName;
import providers.UrlProvider;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MouseOverTest extends BaseTest {
    @Test
    public void should_show_captions_under_images_when_mouse_over_image() {
        MouseOverPage mouseOverPage = new MouseOverPage(driver);

        driver.get(UrlProvider.MOUSE_OVER);

        for (ImageName imageName : ImageName.values()) {

            WebElement image = mouseOverPage.findImageNameCorrespondingToCaption(imageName.getValue());

            mouseOverPage.hoverOverImage(image);
            WebElement imageCaption = mouseOverPage.findImageCaption(image);

            log.debug("The caption for image {} is {}", imageName, imageCaption.getText());
            assertThat(imageCaption.getText()).isEqualToIgnoringCase(imageName.getValue());
        }
    }

}
