package tests;

import common.Project;
import hillel.lesson08.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    static protected Project web = null;

    @BeforeClass
    public void setUp() {
        if (web == null) {
            web = new Project();
        }
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        web.getDriver().quit();
    }

    @AfterMethod
    public void afterMethod() {
        Logger.wait(2, "Wait 2 sec at finish to see browser");
    }

}
