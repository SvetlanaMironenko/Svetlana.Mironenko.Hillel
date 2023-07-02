package tests.lessonHillel23FileSelenide;

import com.codeborne.selenide.Configuration;
import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesForHillel.DownloadPageSelenide;
import pagesForHillel.MainPageSelenide;
import pagesForHillel.UploadPageSelenide;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DownloadAndUploadTestsSelenide {

    @Test
    public void DownloadAndUploadFileTest() throws IOException {
        Configuration.downloadsFolder = "target/downloads";
        Configuration.savePageSource = false;

        Logger.step("1. Open page");
        open("https://the-internet.herokuapp.com/");

        MainPageSelenide mainPageSelenide = new MainPageSelenide();

        Logger.step("2. Open page Download");
        DownloadPageSelenide downloadPageSelenide = mainPageSelenide.fileDownload();

        Logger.step("3. Click linc text Read existing file" +
                "4. Write values to given file");
        List<String> linesToAdd = new ArrayList<>();
        linesToAdd.add("My new line");
        linesToAdd.add("My second line");
        File file = downloadPageSelenide.clickLincText();
        System.out.println(file);

        readExistingFile(file);
        addMultipleTextLinesToFile(file, linesToAdd);

        Logger.step("5. Open page Upload");
        open("https://the-internet.herokuapp.com/");

        UploadPageSelenide uploadPageSelenide = mainPageSelenide.fileUpload();

        Logger.step("6. Setup file to upload" +
                "7. Upload file");
        uploadPageSelenide.uploadedFilePathElement(file);
        uploadPageSelenide.clickUploadFile();

        Logger.step("8. Check file upload");
        Assert.assertEquals(uploadPageSelenide.getTitle(),
                "File Uploaded!",
                "Wrong page title is displayed");
        Assert.assertEquals(uploadPageSelenide.checkUploadedFile(),
                "some-file.txt",
                "Check file upload");

        Logger.step("9. Delete the file if it exists");
        Files.deleteIfExists(file.toPath());
    }

    private void readExistingFile(File file) throws IOException {
        Logger.wait(2, "wait for load");
        System.out.println(Files.readAllLines(file.toPath()));
    }

    private void addMultipleTextLinesToFile(File file, List<String> linesToAdd) throws IOException {
        Files.write(file.toPath(), linesToAdd, StandardOpenOption.APPEND);
        System.out.println(Files.readAllLines(file.toPath()));
    }

}
