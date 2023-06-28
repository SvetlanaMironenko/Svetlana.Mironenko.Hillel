package pagesForHillel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@name='username']")
    private WebElement usernameElement;

    @FindBy(xpath = "//*[@name='password']")
    private WebElement passwordElement;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButtonElement;

    @FindBy(xpath = "//*[@class='flash error']")
    private WebElement loginErrorMessage;

    public LoginPage() {
        super();
        PageFactory.initElements(web.getDriver(), this);
    }

    public LoginPage fillCredentials(String username, String password) {
        setFieldValue(usernameElement, username);
        setFieldValue(passwordElement, password);
        return this;
    }

    public SecurePage clickLoginButton() {
        clickButton(loginButtonElement);
        return new SecurePage();
    }

    public LoginPage loginWithInvalidCreed() {
        clickButton(loginButtonElement);
        return this;
    }

    public String getLoginInvalidMessage() {
        return loginErrorMessage.getText();
    }

}
