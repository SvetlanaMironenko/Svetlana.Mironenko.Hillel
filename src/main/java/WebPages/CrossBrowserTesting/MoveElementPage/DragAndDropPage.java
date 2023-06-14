package WebPages.CrossBrowserTesting.MoveElementPage;

import common.BasePage;
import common.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {


    public DragAndDropPage(Project project) {
        super(project);
        locatorsList.put("DragFrom","//*[@id='draggable']");
        locatorsList.put("DropTo","//*[@id='droppable']");
        locatorsList.put("Dropped","//*[@id='droppable']/p");
    }

    public void moveElement() {
        Actions actions = new Actions(web.getDriver());
        WebElement dragFrom = element("DragFrom");
        WebElement dropTo = element("DropTo");
        actions.moveToElement(dragFrom).clickAndHold(dragFrom)
                .moveToElement(dropTo).release().perform();
    }

    public String getTextDropped() {
        return element("Dropped").getText();
    }

}
