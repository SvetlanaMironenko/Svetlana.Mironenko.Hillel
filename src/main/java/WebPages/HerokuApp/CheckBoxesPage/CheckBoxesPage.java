package WebPages.HerokuApp.CheckBoxesPage;

import common.BasePage;
import common.Project;
import hillel.lesson08.Logger;

public class CheckBoxesPage extends BasePage {

    public CheckBoxesPage(Project project) {
        super(project);
        locatorsList.put("Checkboxes","//*[@type='checkbox']");
        locatorsList.put("CurCheckbox","//*[@type='checkbox'][#number#]");
    }

    public void displayDefaultCheckboxesStatus() {
        for (int i = 1; i <= countOfElements("Checkboxes"); i++) {
            String curLocator = getXpathLocator("CurCheckbox").replace("#number#", String.valueOf(i));
            Logger.info("Is checkbox #" + i + " selected? -> " + element(curLocator).isSelected());
        }
    }

    public void selectAllCheckboxes() {
        for (int i = 1; i <= countOfElements("Checkboxes"); i++) {
            String curLocator = getXpathLocator("CurCheckbox").replace("#number#", String.valueOf(i));
            if (!element(curLocator).isSelected()) {
                Logger.info("Clicking on checkbox #" + i);
                element(curLocator).click();
            }
        }
    }

}
