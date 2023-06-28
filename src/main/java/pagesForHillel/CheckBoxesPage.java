package pagesForHillel;

import hillel.lesson08.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesPage extends BasePage {

    private String checkboxes = "//*[@type='checkbox']";
    private String curCheckbox = "//*[@type='checkbox'][#number#]";

    public CheckBoxesPage displayDefaultCheckboxesStatus() {
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(checkboxes));
        for (int i = 1; i <= myElements.size(); i++) {
            String curLocator = curCheckbox.replace("#number#", String.valueOf(i));
            Logger.info("Is checkbox #" + i + " selected? -> " + web.getDriver()
                    .findElement(By.xpath(curLocator)).isSelected());
        }
        return this;
    }

    public CheckBoxesPage selectAllCheckboxes() {
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(checkboxes));
        for (int i = 1; i <= myElements.size(); i++) {
            String curLocator = curCheckbox.replace("#number#", String.valueOf(i));
            if (!web.getDriver().findElement(By.xpath(curLocator)).isSelected()) {
                Logger.info("Clicking on checkbox #" + i);
                web.getDriver().findElement(By.xpath(curLocator)).click();
            }
        }
        return this;
    }



}
