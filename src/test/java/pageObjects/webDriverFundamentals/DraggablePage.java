package pageObjects.webDriverFundamentals;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.base.BasePage;

@Slf4j
public class DraggablePage extends BasePage {
    public DraggablePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "target")
    private WebElement target;
    @FindBy(id = "draggable")
    private WebElement draggablePanel;
    public Point getTargetLocation(){
      return target.getLocation();
    }
    public Point getPanelLocation(){
        return draggablePanel.getLocation();
    }

    public void dragAndDropPanelOnTarget(){
        actions.dragAndDrop(draggablePanel,target).perform();
    }


}
