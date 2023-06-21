package pagesForHillel;

import common.Project;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    static protected Project web = null;
    protected WebDriverWait webDriverWait;
    protected Actions actions;
    protected JavascriptExecutor javascriptExecutor;


    public BasePage(Project project) {
        web = project;
        webDriverWait = new WebDriverWait(web.getDriver(), Duration.ofSeconds(5));
        actions = new Actions(web.getDriver());
        javascriptExecutor = (JavascriptExecutor)web.getDriver();
    }

    protected void setFieldValue(WebElement curElement, String value) {
        curElement.clear();
        curElement.sendKeys(value);
    }

    protected void clickButton(WebElement button) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }


}
