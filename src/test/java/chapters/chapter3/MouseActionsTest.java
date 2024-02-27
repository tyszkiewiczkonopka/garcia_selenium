package chapters.chapter3;

import baseTest.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.webDriverFundamentals.DropdownPage;
import providers.UrlProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MouseActionsTest extends BaseTest {

    @Test
    public void click_test() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        driver.get(UrlProvider.DROPDOWN_MENU);

        dropdownPage.contextClickOnDropdown(dropdownPage.getDropdown_2());
        dropdownPage.doubleClickOnDropdown(dropdownPage.getDropdown_3());
        dropdownPage.clickOnDropdown(dropdownPage.getDropdown_1());// if the dropdown is clicked as the first one, other clicks close it and
        // assertion is always false

        assertThat(List.of(dropdownPage.getDropdown_1_menu(), dropdownPage.getDropdown_2_menu(), dropdownPage.getDropdown_3_menu()))
                .allSatisfy(menu -> assertThat(menu.isDisplayed()).isTrue());
    }
}
