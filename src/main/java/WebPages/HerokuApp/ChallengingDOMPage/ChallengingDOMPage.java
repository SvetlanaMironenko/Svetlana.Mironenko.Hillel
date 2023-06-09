package WebPages.HerokuApp.ChallengingDOMPage;

import common.BasePage;
import common.Project;
import hillel.lesson08.Logger;

public class ChallengingDOMPage extends BasePage {

    public ChallengingDOMPage(Project project) {
        super(project);
        locatorsList.put("CurButton","//*[contains(@class,'button')][#number#]");
        locatorsList.put("Buttons","//*[contains(@class,'button')]");
        locatorsList.put("CurTableElement","//tr[#number#]//td[4]");
        locatorsList.put("TableElements","//tr//td[4]");
    }

    public void clickButtons() {
        for (int i = 1; i <= countOfElements("Buttons"); i++) {
            String curLocator = getXpathLocator("CurButton").replace("#number#", String.valueOf(i));
            element(curLocator).click();
        }
    }

    public void displayTableElements() {
        for (int i = 1; i <= countOfElements("TableElements"); i++) {
            String curLocator = getXpathLocator("CurTableElement").replace("#number#", String.valueOf(i));
            String text = element(curLocator).getText();
            Logger.info(text);
        }
    }

}
