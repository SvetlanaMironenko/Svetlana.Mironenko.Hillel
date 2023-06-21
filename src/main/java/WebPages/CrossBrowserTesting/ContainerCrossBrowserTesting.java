package WebPages.CrossBrowserTesting;

import WebPages.CrossBrowserTesting.HoverMenuPage.HoverMenuPage;
import WebPages.CrossBrowserTesting.MoveElementPage.DragAndDropPage;
import common.CommonContainer;
import common.Project;

public class ContainerCrossBrowserTesting extends CommonContainer {

    public ContainerCrossBrowserTesting(Project project) {
        super(project);
    }

    public DragAndDropPage dragAndDropPage = new DragAndDropPage(project);

    public HoverMenuPage hoverMenuPage = new HoverMenuPage(project);

}
