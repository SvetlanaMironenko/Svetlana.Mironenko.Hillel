package WebPages.CrossBrowserTesting.HoverMenuPage;

import common.CommonPage;
import common.Project;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class HoverMenuPage extends CommonPage {


    public HoverMenuPage(Project project) {
        super(project);
        locatorsList.put("DropdownMenu","//*[@class='dropdown']");
        locatorsList.put("SecondaryDropdownMenu","//*[@class='dropdown-menu']//*[@class='secondary-dropdown']");
        locatorsList.put("SecondaryAction","//*[@class='dropdown-menu secondary']");
        locatorsList.put("TitleSecondaryPage","//*[@class='jumbotron secondary-clicked']/h1");
    }

    public void clickDropdownMenu() {
        Actions actions = new Actions(web.getDriver());
        actions.moveToElement(element("DropdownMenu")).pause(Duration.ofSeconds(1))
                .moveToElement(element("SecondaryDropdownMenu")).pause(Duration.ofSeconds(1))
                .moveToElement(element("SecondaryAction")).click().perform();
    }

    public String getTitleSecondaryPage() {
        return element("TitleSecondaryPage").getText();
    }

}
