package WebPages.HerokuApp.LoginPage;

import common.BasePage;
import common.Project;

public class LoginPage extends BasePage {

    public LoginPage(Project project) {
        super(project);
        locatorsList.put("Username","//*[@name='username']");
        locatorsList.put("Password","//*[@name='password']");
        locatorsList.put("LoginButton","//*[@type='submit']");
        locatorsList.put("LoginSuccessMessage","//*[@class='flash success']");
        locatorsList.put("LoginErrorMessage","//*[@class='flash error']");
    }

    public void fillCredentials(String username, String password) {
        element("Username").clear();
        element("Username").sendKeys(username);
        element("Password").clear();
        element("Password").sendKeys(password);
    }

    public void clickLogin() {
        element("LoginButton").click();
    }

    public String getLoginSuccessMessage() {
        return element("LoginSuccessMessage").getText()
                .replaceAll(".$", "").replaceAll("\\n$", "");
    }

    public String getLoginInvalidMessage() {
        return element("LoginErrorMessage").getText()
                .replaceAll(".$", "").replaceAll("\\n$", "");
    }

}
