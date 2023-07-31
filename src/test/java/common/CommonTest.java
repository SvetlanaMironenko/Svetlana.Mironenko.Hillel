package common;

import WebPages.ContainerOfPages;
import hillel.lesson08.Logger;
import listeners.CustomExtentReportListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({CustomExtentReportListener.class})
public class CommonTest {

    static protected Project web = null;
    static protected ContainerOfPages pages = null;

    public CommonTest() {
        web = Project.getInstance();
    }

    @BeforeSuite
    public void beforeSuite() {
        web.initDriver();
        initPages();
    }

    @AfterSuite
    public void afterSuite() {
        web.closeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        Logger.wait(2, "Wait 2 sec at finish to see browser");
    }

    private void initPages() {
        if (pages == null) {
            pages = new ContainerOfPages(web);
        }
    }


}
