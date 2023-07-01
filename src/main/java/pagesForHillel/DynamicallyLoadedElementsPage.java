package pagesForHillel;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class DynamicallyLoadedElementsPage {

    private SelenideElement titleElement = $x("//h3");

    private SelenideElement subTitleElement = $x("//h4");

    private ElementsCollection linksElements = $$x("//*[contains(text(),'Example')]");

    private SelenideElement loadingElement = $x("//*[@id='loading']");

    private SelenideElement finishElement = $x("//*[@id='finish']/h4");

    private SelenideElement startButtonElement = $x("//button");

    public String getTitle() {
        return titleElement.shouldHave(Condition.visible)
                .shouldHave(Condition.text("Dynamically Loaded Page Elements")).text();
    }

    public DynamicallyLoadedElementsPage clickStartButton() {
        startButtonElement.click();
        return this;
    }

    public String getSubTitle() {
        return subTitleElement.getText();
    }

    public DynamicallyLoadedElementsPage clickOnCurLink(int linkNumber) {
        String curButtonLocator = "//*[contains(text(),'Example #number#')]"
                .replaceAll("#number#", String.valueOf(linkNumber));
        $x(curButtonLocator).click();
        return this;
    }

    public int getCountOfLinks() {
        return linksElements.size();
    }

    public DynamicallyLoadedElementsPage checkLoadingAndFinish() {
        loadingElement.shouldNot(Condition.visible, Duration.ofSeconds(30));
        return this;
    }

    public String checkTextFinish() {
        return finishElement.shouldHave(Condition.visible)
                .shouldHave(Condition.text("Hello World!")).text();
    }

}
