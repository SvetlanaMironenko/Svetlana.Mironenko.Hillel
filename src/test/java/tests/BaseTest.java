package tests;

import common.Project;
import hillel.lesson08.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    static protected Project web = null;

    @BeforeSuite
    public void beforeSuite() {
        web = Project.getInstance();
    }

    @BeforeClass
    public void setUp() {
        web.initDriver();
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        web.closeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Logger.wait(2, "Wait 2 sec at finish to see browser");
    }

}
