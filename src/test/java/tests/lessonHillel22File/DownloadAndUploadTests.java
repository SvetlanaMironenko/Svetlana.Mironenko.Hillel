package tests.lessonHillel22File;

import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesForHillel.DownloadPage;
import pagesForHillel.MainPage;
import pagesForHillel.UploadPage;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class DownloadAndUploadTests extends BaseTest {

    @Test
    public void DownloadAndUploadFileTest() throws IOException {
        Logger.step("1. Open page");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("1. Open page Download");
        MainPage mainPage = new MainPage();
        DownloadPage downloadPage = mainPage.clickToOpenDownloadPage();

        File file = new File("target/downloads/some-file.txt");

        Logger.step("2. Click linc text Read existing file" +
                "3. Write values to given file");
        List<String> linesToAdd = new ArrayList<>();
        linesToAdd.add("My new line");
        linesToAdd.add("My second line");
        downloadPage.clickLincText();

        readExistingFile(file);
        addMultipleTextLinesToFile(file, linesToAdd);

        Logger.step("4. Open page Upload");
        web.open("https://the-internet.herokuapp.com/");
        UploadPage uploadPage = mainPage.clickToOpenUploadPage();

        Logger.step("5. Setup file to upload" +
                        "6. Upload file");
        uploadPage.setupFileToUpload(file).uploadFile();

        Logger.step("7. Check file upload");
        Assert.assertEquals(uploadPage.getTitle(),
                "File Uploaded!",
                "Wrong page title is displayed");
        Assert.assertEquals(uploadPage.checkUploadedFile(),
                "some-file.txt",
                "Check file upload");

        Logger.step("8. Delete the file if it exists");
        Files.deleteIfExists(file.toPath());
    }

    private void readExistingFile(File file) throws IOException {
        Logger.wait(2, "wait for load");
        file.equals(true);
        System.out.println(Files.readAllLines(file.toPath()));
    }

    private void addMultipleTextLinesToFile(File file, List<String> linesToAdd) throws IOException {
        Files.write(file.toPath(), linesToAdd, StandardOpenOption.APPEND);
        System.out.println(Files.readAllLines(file.toPath()));
    }

}
