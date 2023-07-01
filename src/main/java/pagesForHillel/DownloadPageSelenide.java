package pagesForHillel;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$x;

public class DownloadPageSelenide {

    private SelenideElement linkTextElement = $x("//*[contains(text(),'some-file.txt')]");

    public File clickLincText() throws FileNotFoundException {
        return linkTextElement.download();
    }

}
