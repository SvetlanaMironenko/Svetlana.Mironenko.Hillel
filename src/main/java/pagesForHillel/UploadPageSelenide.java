package pagesForHillel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;
import static com.codeborne.selenide.Selenide.$x;

public class UploadPageSelenide {

    private SelenideElement fileUploadButtonElement = $x("//*[@class='button']");

    private SelenideElement titleUploadElement = $x("//*[contains(text(),'Uploaded!')]");

    private SelenideElement uploadedFileElement = $x("//*[@id ='uploaded-files']");

    private SelenideElement uploadedFilePathElement = $x("//*[@id='file-upload']");

    public UploadPageSelenide clickUploadFile() {
        fileUploadButtonElement.click();
        return this;
    }

    public File uploadedFilePathElement(File file) {
        return uploadedFilePathElement.uploadFile(file);
    }

    public String getTitle() {
        return titleUploadElement.shouldHave(Condition.visible).shouldHave(Condition.text("File Uploaded!")).text();
    }

    public String checkUploadedFile() {
        return uploadedFileElement.shouldHave(Condition.visible).shouldHave(Condition.text("some-file.txt")).text();
    }

}
