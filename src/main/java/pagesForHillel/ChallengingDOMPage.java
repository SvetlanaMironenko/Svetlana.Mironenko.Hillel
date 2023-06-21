package pagesForHillel;

import common.Project;
import hillel.lesson08.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChallengingDOMPage extends BasePage {

    private String curButton = "//*[contains(@class,'button')][#number#]";
    private String buttons = "//*[contains(@class,'button')]";
    private String curTableElement = "//tr[#number#]//td[4]";
    private String tableElements = "//tr//td[4]";

    public ChallengingDOMPage(Project project) {
        super(project);
    }

    public ChallengingDOMPage clickButtons() {
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(buttons));
        for (int i = 1; i <= myElements.size(); i++) {
            String curLocator = curButton.replace("#number#", String.valueOf(i));
            web.getDriver().findElement(By.xpath(curLocator)).click();
        }
        return this;
    }

    public ChallengingDOMPage displayTableElements() {
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(tableElements));
        for (int i = 1; i <= myElements.size(); i++) {
            String curLocator = curTableElement.replace("#number#", String.valueOf(i));
            String text = web.getDriver().findElement(By.xpath(curLocator)).getText();
            Logger.info(text);
        }
        return this;
    }

}
