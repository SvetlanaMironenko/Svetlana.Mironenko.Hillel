package tests.Lesson18;

import common.CommonTest;
import hillel.lesson08.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsForLesson18 extends CommonTest {

    @Test
    public void testDragAndDrop() {
        Logger.step("1. Open page");
        web.open("https://crossbrowsertesting.github.io/drag-and-drop.html");
        Logger.wait(1, "wait for load");

        Logger.step("2. Move element");
        pages.crossBrowserTesting.dragAndDropPage.moveElement();
        Assert.assertEquals(pages.crossBrowserTesting.dragAndDropPage.getTextDropped(),
                "Dropped!",
                "Check text 'Dropped!'");
    }

    @Test
    public void testHoverMenu() {
        Logger.step("1. Open page");
        web.open("https://crossbrowsertesting.github.io/hover-menu.html");
        Logger.wait(1, "wait for load");

        Logger.step("2. Click dropdown menu");
        pages.crossBrowserTesting.hoverMenuPage.clickDropdownMenu();
        Assert.assertEquals(pages.crossBrowserTesting.hoverMenuPage.getTitleSecondaryPage(),
                "Secondary Page",
                "Check title 'Secondary Page'");
    }

    @Test
    public void testHoversNameUser() {
        Logger.step("1. Open page");
        web.open("https://the-internet.herokuapp.com/hovers");
        Logger.wait(1, "wait for load");

        Logger.step("2. Click dropdown menu");
        pages.herokuApp.hoversPage.scrollToUsersAndGetName();
    }
}
