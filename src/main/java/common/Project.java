package common;

import hillel.lesson08.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project {

    private static Project instance = null;

    private static WebDriver driver = null;

    private Project() {
    }

    public static Project getInstance() {
        if (instance == null) {
            instance = new Project();
        }
        return instance;
    }

    public void open(String url) {
        //ToDo: Add using of short names for urls
        Logger.debug("Opening url" + url);
        getInstance().driver.get(url);
    }

    public static WebDriver getDriver() {
        return getInstance().driver;
    }

    public void initDriver() {
        if (getInstance().driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void closeDriver() {
        getInstance().driver.quit();
        driver = null;
    }
}
