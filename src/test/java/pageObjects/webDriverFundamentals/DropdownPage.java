package pageObjects.webDriverFundamentals;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.base.BasePage;

@Getter
public class DropdownPage extends BasePage {

    @FindBy(id = "my-dropdown-1")
    private WebElement dropdown_1;
    @FindBy(id = "my-dropdown-2")
    private WebElement dropdown_2;
    @FindBy(id = "my-dropdown-3")
    private WebElement dropdown_3;
    @FindBy(css = "#my-dropdown-1+ul")
    private WebElement dropdown_1_menu;
    @FindBy(id = "context-menu-2")
    private WebElement dropdown_2_menu;
    @FindBy(id = "context-menu-3")
    private WebElement dropdown_3_menu;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnDropdown(WebElement dropdown) {
        dropdown.click();
    }

    public void contextClickOnDropdown(WebElement dropdown) {
        actions.contextClick(dropdown).perform();
    }

    public void doubleClickOnDropdown(WebElement dropdown) {
        actions.doubleClick(dropdown).perform();
    }
}
