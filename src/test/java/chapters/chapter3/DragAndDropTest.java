package chapters.chapter3;

import baseTest.BaseTest;
import helpers.ScreenshotHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;
import pageObjects.webDriverFundamentals.DraggablePage;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DragAndDropTest extends BaseTest {

    @Test
    public void should_drag_and_drop_element_to_target() {
        DraggablePage draggablePage = new DraggablePage(driver);

        driver.get(UrlProvider.DRAG_AND_DROP);

        Point panelLocation = draggablePage.getPanelLocation();
        Point targetLocation = draggablePage.getTargetLocation();
        log.debug("Initial panel location: " + panelLocation);
        log.debug("Target location: " + targetLocation);

        draggablePage.dragAndDropPanelOnTarget();
        Point updatedPanelLocation = draggablePage.getPanelLocation();
        log.debug("Panel moved to location: " + updatedPanelLocation);

        ScreenshotHelper.takeScreenshot(driver, "dragged_panel");

        assertThat(updatedPanelLocation).isEqualTo(targetLocation);
    }
}
