package common;

import hillel.lesson08.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", new File("target/downloads").getAbsolutePath());
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
    }

    public void closeDriver() {
        getInstance().driver.quit();
        driver = null;
    }
}
