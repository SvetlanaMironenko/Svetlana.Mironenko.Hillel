package tests.lessonHillel23FileSelenide;

import com.codeborne.selenide.Configuration;
import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesForHillel.DynamicallyLoadedElementsPage;

import static com.codeborne.selenide.Selenide.*;

public class DynamicallyLoadedTestsSelenide {

    @Test
    public void DynamicallyLoadedElementsTest() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.savePageSource = false;

        Logger.step("1. Open page");
        open("dynamic_loading");

        DynamicallyLoadedElementsPage dynamicallyLoadedElementsPage = new DynamicallyLoadedElementsPage();
        Assert.assertEquals(dynamicallyLoadedElementsPage.getTitle(),
                "Dynamically Loaded Page Elements",
                "Check title on page");

        String[] expectedSubTexts = {"Example 1: Element on page that is hidden",
                "Example 2: Element rendered after the fact"};

        Logger.step("2. Click foreach link and check text");
        for (int i = 1; i <= dynamicallyLoadedElementsPage.getCountOfLinks(); i++) {

            dynamicallyLoadedElementsPage.clickOnCurLink(i);

            Assert.assertEquals(dynamicallyLoadedElementsPage.getSubTitle(),
                    expectedSubTexts[i - 1],
                    "Check subtitle on page after click on link # " + i);

            dynamicallyLoadedElementsPage.clickStartButton().checkLoadingAndFinish();

            Assert.assertEquals(dynamicallyLoadedElementsPage.checkTextFinish(),
                    "Hello World!",
                    "Check message on page");

            Logger.info("Open page again to check other link");
            open("dynamic_loading");
        }
    }

}
