package WebPages;

import WebPages.HerokuApp.ContainerHerokuApp;
import common.BaseContainer;
import common.Project;

public class ContainerOfPages extends BaseContainer {

    public ContainerOfPages(Project project) {
        super(project);
    }

    public ContainerHerokuApp herokuApp = new ContainerHerokuApp(project);

}
