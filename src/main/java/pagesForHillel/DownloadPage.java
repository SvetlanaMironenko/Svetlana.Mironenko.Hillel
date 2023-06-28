package pagesForHillel;

import org.openqa.selenium.By;

public class DownloadPage extends BasePage {

    private String lincText = "//*[contains(text(),'some-file.txt')]";

    public DownloadPage clickLincText() {
        web.getDriver().findElement(By.xpath(lincText)).click();
        return this;
    }

}
