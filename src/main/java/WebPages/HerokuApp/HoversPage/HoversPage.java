package WebPages.HerokuApp.HoversPage;

import common.CommonPage;
import common.Project;
import hillel.lesson08.Logger;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HoversPage extends CommonPage {


    public HoversPage(Project project) {
        super(project);
        locatorsList.put("CurUser","//*[@class='figure'][#number#]");
        locatorsList.put("Users","//*[@class='figure']");
        locatorsList.put("CurNameUser","//*[@class='figure'][#number#]//*[@class='figcaption']/h5");
    }

    public void scrollToUsersAndGetName() {
        Actions actions = new Actions(web.getDriver());
        for (int i = 1; i <= countOfElements("Users"); i++) {
            String curUser = getXpathLocator("CurUser").replace("#number#", String.valueOf(i));
            actions.moveToElement(element(curUser)).pause(Duration.ofSeconds(1)).perform();
            String curNameUser = getXpathLocator("CurNameUser").replace("#number#", String.valueOf(i));
            String text = element(curNameUser).getText();
            Logger.info(text);
        }
    }

}
