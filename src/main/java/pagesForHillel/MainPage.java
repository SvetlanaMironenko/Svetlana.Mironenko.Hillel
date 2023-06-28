package pagesForHillel;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public LoginPage clickToOpenFormAuthenticationPage() {
        web.getDriver().findElement(By.linkText("Form Authentication")).click();
        return new LoginPage();
    }

    public ChallengingDOMPage clickToOpenChallengingDOMPage() {
        web.getDriver().findElement(By.linkText("Challenging DOM")).click();
        return new ChallengingDOMPage();
    }

    public CheckBoxesPage clickToOpenCheckBoxesPage() {
        web.getDriver().findElement(By.linkText("Checkboxes")).click();
        return new CheckBoxesPage();
    }

    public HoversPage clickToOpenHoversPage() {
        web.getDriver().findElement(By.linkText("Hovers")).click();
        return new HoversPage();
    }

    public DownloadPage clickToOpenDownloadPage() {
        web.getDriver().findElement(By.linkText("File Download")).click();
        return new DownloadPage();
    }

    public UploadPage clickToOpenUploadPage() {
        web.getDriver().findElement(By.linkText("File Upload")).click();
        return new UploadPage();
    }

}
