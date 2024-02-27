package helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ConditionsHelper {
    public static ExpectedCondition<Boolean> elementHasAttribute(WebElement element, String attributeName) {
        return driver -> {
            String attributeValue = element.getAttribute(attributeName);
            return attributeValue != null && !attributeValue.isEmpty();
        };
    }


}
