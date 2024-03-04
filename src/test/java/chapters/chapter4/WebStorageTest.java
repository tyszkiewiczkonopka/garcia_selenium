package chapters.chapter4;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import providers.UrlProvider;

@Slf4j
public class WebStorageTest extends BaseTest {
    @Test
    public void should_set_and_retrieve_data_from_storage() {
        driver.get(UrlProvider.WEB_STORAGE);

        RemoteWebStorage webStorage = (RemoteWebStorage) driver;

        LocalStorage localStorage = webStorage.getLocalStorage();
        SessionStorage sessionStorage = webStorage.getSessionStorage();

        localStorage.setItem("username", "john_doe");
        sessionStorage.setItem("temporary_data", "some_value");

        log.info("Local storage elements: " + localStorage.size());
        log.info(localStorage.getItem("username"));
        log.info(sessionStorage.getItem("temporary_data"));

        localStorage.clear();
        sessionStorage.clear();
    }

    @Test
    public void should_set_and_retrieve_data_from_storage_with_javasriptexecutor() {
        driver.get(UrlProvider.WEB_STORAGE);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("localStorage.setItem('username', 'john_doe')");
        js.executeScript("sessionStorage.setItem('temporary_data', 'some_value')");

        String username = (String) js.executeScript("return localStorage.getItem('username')");
        String temporaryData = (String) js.executeScript("return sessionStorage.getItem('temporary_data')");

        log.info("Local storage elements: " + js.executeScript("return localStorage.length"));
        log.info(username);
        log.info(temporaryData);

        js.executeScript("localStorage.clear()");
        js.executeScript("sessionStorage.clear()");
    }


}
