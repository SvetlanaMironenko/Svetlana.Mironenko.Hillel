package WebPages.HerokuApp;

import WebPages.HerokuApp.ChallengingDOMPage.ChallengingDOMPage;
import WebPages.HerokuApp.CheckBoxesPage.CheckBoxesPage;
import WebPages.HerokuApp.HoversPage.HoversPage;
import WebPages.HerokuApp.LoginPage.LoginPage;
import common.CommonContainer;
import common.Project;

public class ContainerHerokuApp extends CommonContainer {

    public ContainerHerokuApp(Project project) {
        super(project);
    }

    public ChallengingDOMPage challengingDOMPage = new ChallengingDOMPage(project);

    public LoginPage loginPage = new LoginPage(project);

    public CheckBoxesPage checkBoxesPage = new CheckBoxesPage(project);

    public HoversPage hoversPage = new HoversPage(project);

}
