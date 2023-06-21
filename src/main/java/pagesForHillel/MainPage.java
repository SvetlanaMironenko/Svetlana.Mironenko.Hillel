package pagesForHillel;

import common.Project;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public MainPage(Project project) {
        super(project);
    }

    public LoginPage clickToOpenFormAuthenticationPage() {
        web.getDriver().findElement(By.linkText("Form Authentication")).click();
        return new LoginPage(web);
    }

    public ChallengingDOMPage clickToOpenChallengingDOMPage() {
        web.getDriver().findElement(By.linkText("Challenging DOM")).click();
        return new ChallengingDOMPage(web);
    }

    public CheckBoxesPage clickToOpenCheckBoxesPage() {
        web.getDriver().findElement(By.linkText("Checkboxes")).click();
        return new CheckBoxesPage(web);
    }

    public HoversPage clickToOpenHoversPage() {
        web.getDriver().findElement(By.linkText("Hovers")).click();
        return new HoversPage(web);
    }

}
