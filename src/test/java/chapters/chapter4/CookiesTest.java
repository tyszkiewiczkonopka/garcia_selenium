package chapters.chapter4;

import baseTest.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import providers.UrlProvider;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CookiesTest extends BaseTest {
    @Test
    public void should_read_username_from_cookies() {
        driver.get(UrlProvider.COOKIES);
        Cookie username = driver.manage().getCookieNamed("username");

        assertThat(username.getValue()).isEqualTo("John Doe");
    }

    @Test
    public void should_add_new_cookie() {
        driver.get(UrlProvider.COOKIES);
        Cookie cookie = new Cookie("cookie-name", "cookie-value");
        driver.manage().addCookie(cookie);
        String newCookieValue = cookie.getValue();

        assertThat(cookie.getValue()).isEqualTo(newCookieValue);
    }

    @Test
    public void should_edit_new_cookie() {
        //todo: nie rozumiem co tu się zadziało, które cookie jest które

        driver.get(UrlProvider.COOKIES);
        Cookie usernameCookie = driver.manage().getCookieNamed("username");
        log.debug("Cookies initial size: " + driver.manage().getCookies().size());
        log.debug("Username from cookie: " + usernameCookie);

        Cookie editedUsernameCookie = new Cookie(usernameCookie.getName(), "Magdalena");
        driver.manage().addCookie(editedUsernameCookie);

        Cookie readCookie = driver.manage().getCookieNamed(usernameCookie.getName());
        log.debug("Cookies new size: " + driver.manage().getCookies().size());
        log.debug("Username from cookie after editing: " + readCookie);

        assertThat(editedUsernameCookie).isEqualTo(readCookie);

    }

    @Test
    public void should_delete_cookie() {
        driver.get(UrlProvider.COOKIES);
        int initialCookieSize = driver.manage().getCookies().size();
        log.debug("Initial cookies size: " + initialCookieSize);

        Cookie usernameCookie = driver.manage().getCookieNamed("username");
        driver.manage().deleteCookie(usernameCookie);
        int updatedCookieSize = driver.manage().getCookies().size();
        log.debug("Cookies size after deleting " + updatedCookieSize);

        assertThat(updatedCookieSize).isNotEqualTo(initialCookieSize);
    }


}
