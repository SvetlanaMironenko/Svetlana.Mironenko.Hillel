package pagesForHillel;

import hillel.lesson08.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HoversPage extends BasePage {

    private String curUserLocator = "//*[@class='figure'][#number#]";
    private String usersLocator = "//*[@class='figure']";
    private String curNameUserLocator = "//*[@class='figure'][#number#]//*[@class='figcaption']/h5";

    public HoversPage scrollToUsersAndGetName() {
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(usersLocator));
        Actions actions = new Actions(web.getDriver());
        for (int i = 1; i <= myElements.size(); i++) {
            String curUser = curUserLocator.replace("#number#", String.valueOf(i));
            actions.moveToElement(web.getDriver().findElement(By.xpath(curUser))).pause(Duration.ofSeconds(1)).perform();
            String curNameUser = curNameUserLocator.replace("#number#", String.valueOf(i));
            String text = web.getDriver().findElement(By.xpath(curNameUser)).getText();
            Logger.info(text);
        }
        return this;
    }

}
