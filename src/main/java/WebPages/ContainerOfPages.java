package WebPages;

import WebPages.CrossBrowserTesting.ContainerCrossBrowserTesting;
import WebPages.HerokuApp.ContainerHerokuApp;
import common.BaseContainer;
import common.Project;

public class ContainerOfPages extends BaseContainer {

    public ContainerOfPages(Project project) {
        super(project);
    }

    public ContainerHerokuApp herokuApp = new ContainerHerokuApp(project);

    public ContainerCrossBrowserTesting crossBrowserTesting = new ContainerCrossBrowserTesting(project);

}
