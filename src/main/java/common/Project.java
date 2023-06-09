package common;

import hillel.lesson08.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project {

    static private WebDriver driver = null;

    public Project() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void open(String url) {
        //ToDo: Add using of short names for urls
        Logger.debug("Opening url" + url);
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
