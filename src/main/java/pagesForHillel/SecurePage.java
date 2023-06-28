package pagesForHillel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {

    @FindBy(xpath = "//*[@class='flash success']")
    private WebElement loginSuccessMessage;

    @FindBy(xpath = "//h2")
    private WebElement title;

    public SecurePage() {
        super();
        PageFactory.initElements(web.getDriver(), this);
    }

    public String getLoginSuccessMessage() {
        return loginSuccessMessage.getText()
                .replaceAll(".$", "").replaceAll("\\n$", "");
    }

    public String getTitle() {
        return title.getText();
    }

}
