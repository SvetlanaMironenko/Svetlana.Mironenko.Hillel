package pagesForHillel;

import org.openqa.selenium.By;

import java.io.File;

public class UploadPage extends BasePage {

    private String fileInput = "//*[@id='file-upload']";

    private String fileUploadButton = "//*[@class='button']";

    private String titleUpload = "//*[contains(text(),'Uploaded!')]";

    private String uploadedFile = "//*[@id ='uploaded-files']";

    public UploadPage setupFileToUpload(File file) {
        web.getDriver().findElement(By.xpath(fileInput)).sendKeys(file.getAbsolutePath());
        return this;
    }

    public UploadPage uploadFile() {
        web.getDriver().findElement(By.xpath(fileUploadButton)).click();
        return this;
    }

    public String getTitle() {
        return web.getDriver().findElement(By.xpath(titleUpload)).getText();
    }

    public String checkUploadedFile() {
        return web.getDriver().findElement(By.xpath(uploadedFile)).getText();
    }


}
