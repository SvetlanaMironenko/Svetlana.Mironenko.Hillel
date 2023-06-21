package common;

import hillel.lesson08.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonPage {

    static protected Project web = null;

    protected Map<String, String> locatorsList = new HashMap<>();

    public CommonPage(Project project) {
        web = project;
    }

    public String getXpathLocator(String name) {
        String value = locatorsList.get(name);
        if (value == null) {
            Logger.fail("Locator with name '" + name + "' not found at page locators list");
        }
        return value;
    }

    public WebElement element(String nameOrLocator) {
        String xPath;
        if (nameOrLocator.contains("/")) {
            xPath = nameOrLocator;
        } else {
            xPath = getXpathLocator(nameOrLocator);
        }
        //ToDo: add later wait for element with timeout
        WebElement myElement = web.getDriver().findElement(By.xpath(xPath));
        Logger.debug("Found element " + nameOrLocator);
        highLightElementBorder(myElement);
        return myElement;
    }

    public int countOfElements(String nameOrLocator) {
        String xPath;
        if (nameOrLocator.contains("/")) {
            xPath = nameOrLocator;
        } else {
            xPath = getXpathLocator(nameOrLocator);
        }
        List<WebElement> myElements = web.getDriver().findElements(By.xpath(xPath));
        return myElements.size();
    }

    private void highLightElementBorder(WebElement curElement) {
        String originalStyle = curElement.getAttribute("style");

        JavascriptExecutor js = (JavascriptExecutor) web.getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", curElement, "style", originalStyle + "border: 2px solid darkorange;padding: 1px;");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Reset style
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", curElement, "style", originalStyle);
    }

}
