package chapters.chapter4.listener;

import helpers.ScreenshotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class MyCustomEventListener implements WebDriverListener {

    @Override
    public void afterGet(WebDriver driver, String url) {
        ScreenshotHelper.takeScreenshot(driver, "listener_after_get");
    }

    @Override
    public void beforeQuit(WebDriver driver) {
        ScreenshotHelper.takeScreenshot(driver, "listener_before_quit");
    }
}
