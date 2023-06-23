package common;

import WebPages.ContainerOfPages;
import hillel.lesson08.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonTest {

    static protected Project web = null;
    static protected ContainerOfPages pages = null;

    public CommonTest() {
        initProject();
    }

    @BeforeSuite
    public void beforeSuite() {
        initPages();
    }

    @AfterSuite
    public void afterSuite() {
        web.getDriver().quit();
    }

    @AfterMethod
    public void afterMethod() {
        Logger.wait(2, "Wait 2 sec at finish to see browser");
    }

    private void initProject() {
        web = Project.getInstance();
    }

    private void initPages() {
        if (pages == null) {
            pages = new ContainerOfPages(web);
        }
    }


}
