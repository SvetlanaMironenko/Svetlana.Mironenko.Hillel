package pagesForHillel;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSelenide {

    public DownloadPageSelenide fileDownload() {
        $(By.linkText("File Download")).click();
        return new DownloadPageSelenide();
    }

    public UploadPageSelenide fileUpload() {
        $(By.linkText("File Upload")).click();
        return new UploadPageSelenide();
    }




}
