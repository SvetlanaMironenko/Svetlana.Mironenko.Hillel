package tests.lessonHillel20;

import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesForHillel.*;
import tests.BaseTest;

public class TestsForLesson20 extends BaseTest {

    @Test
    public void testPositiveLoginNew() {
        Logger.step("1. Open page login");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("2. Fill login and password " +
                "3. Click login");
        MainPage mainPage = new MainPage();
        SecurePage securePage = mainPage.clickToOpenFormAuthenticationPage()
                .fillCredentials("tomsmith", "SuperSecretPassword!")
                .clickLoginButton();

        Logger.step("4. Check title and login success message");
        Assert.assertEquals(securePage.getTitle(),
                "Secure Area",
                "Wrong page title is displayed");
        Assert.assertEquals(securePage.getLoginSuccessMessage(),
                "You logged into a secure area!",
                "Check login invalid message");
    }

    @Test
    public void testNegativeLoginNew() {
        Logger.step("1. Open page login");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("2. Fill login and password" +
                "3. Click login");
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.clickToOpenFormAuthenticationPage()
                .fillCredentials("tom", "SuperSecretPassword!")
                .loginWithInvalidCreed();

        Logger.step("4. Check login invalid message");
        Assert.assertTrue(loginPage.getLoginInvalidMessage().contains("Your username is invalid!"));
    }

    @Test
    public void testClickEachButtonChallengingDOMNew() {
        Logger.step("1. Open page challenging");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("2. Click on buttons" +
                "3. Display table elements");
        MainPage mainPage = new MainPage();
        mainPage.clickToOpenChallengingDOMPage()
                .clickButtons()
                .displayTableElements();
    }

    @Test
    public void testWithCheckboxesNew() {
        Logger.step("1. Open page Checkboxes");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("2.1. Display default checkboxes status" +
                "2.2. Select all checkboxes");
        MainPage mainPage = new MainPage();
        mainPage.clickToOpenCheckBoxesPage()
                .displayDefaultCheckboxesStatus()
                .selectAllCheckboxes();
    }

    @Test
    public void testHoversNameUserNew() {
        Logger.step("1. Open page");
        web.open("https://the-internet.herokuapp.com/");
        Logger.wait(1, "wait for load");

        Logger.step("2. Click dropdown menu");
        MainPage mainPage = new MainPage();
        mainPage.clickToOpenHoversPage().scrollToUsersAndGetName();
    }
}
