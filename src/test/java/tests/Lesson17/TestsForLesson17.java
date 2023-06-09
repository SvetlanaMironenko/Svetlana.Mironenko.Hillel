package tests.Lesson17;

import common.CommonTest;
import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsForLesson17 extends CommonTest {

    @Test
    public void testClickEachButtonChallengingDOM() {
        Logger.step("1. Open page challenging");
        web.open("https://the-internet.herokuapp.com/challenging_dom");
        Logger.wait(1, "wait for load");

        Logger.step("2. Click on buttons");
        pages.herokuApp.challengingDOMPage.clickButtons();

        Logger.step("3. Display table elements");
        pages.herokuApp.challengingDOMPage.displayTableElements();
    }

    @Test
    public void testPositiveLogin() {
        Logger.step("1. Open page login");
        web.open("https://the-internet.herokuapp.com/login");
        Logger.wait(1, "wait for load");

        Logger.step("2. Fill login and password");
        pages.herokuApp.loginPage.fillCredentials("tomsmith", "SuperSecretPassword!");

        Logger.step("3. Click login");
        pages.herokuApp.loginPage.clickLogin();

        Logger.step("4. Check login success message");
        Assert.assertEquals(pages.herokuApp.loginPage.getLoginSuccessMessage(),
                "You logged into a secure area!",
                "Check login success message");
    }

    @Test
    public void testNegativeLogin() {
        Logger.step("1. Open page login");
        web.open("https://the-internet.herokuapp.com/login");
        Logger.wait(1, "wait for load");

        Logger.step("2. Fill login and password");
        pages.herokuApp.loginPage.fillCredentials("Sveta", "Sveta");

        Logger.step("3. Click login");
        pages.herokuApp.loginPage.clickLogin();

        Logger.step("4. Check login invalid message");
        Assert.assertEquals(pages.herokuApp.loginPage.getLoginInvalidMessage(),
                "Your username is invalid!",
                "Check login invalid message");
    }

    @Test
    public void testWithCheckboxes() {
        Logger.step("1. Open page Checkboxes");
        web.open("https://the-internet.herokuapp.com/checkboxes");
        Logger.wait(1, "wait for load");

        Logger.step("2. Display default checkboxes status");
        pages.herokuApp.checkBoxesPage.displayDefaultCheckboxesStatus();

        Logger.step("3. Select all checkboxes");
        pages.herokuApp.checkBoxesPage.selectAllCheckboxes();
    }

}
