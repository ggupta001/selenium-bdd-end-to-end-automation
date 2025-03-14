package org.stepcampus.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

/**
 * The type Web driver manager.
 */
public class WebDriverManagerUtils {
    protected static WebDriver driver;
    protected static Properties configProperties;

    // Static instance initializations
    private static final WebDriverManager chromedriver = WebDriverManager.chromedriver();
    private static final WebDriverManager edgedriver = WebDriverManager.edgedriver();
    private static final WebDriverManager firefoxdriver = WebDriverManager.firefoxdriver();
    private static final WebDriverManager iedriver = WebDriverManager.iedriver();

    String path = System.getProperty("user.dir") + "//resource//config.properties";

    public WebDriverManagerUtils() throws IOException {
        configProperties = new Properties();
        FileInputStream fs = new FileInputStream(path);
        configProperties.load(fs);
    }

    public static void initilization() {
        String browsername = configProperties.getProperty("browser-name");

        if (browsername.equalsIgnoreCase("chrome")) {
            // Configuring WebDriverManager for Chrome
            chromedriver.setup();
                driver = new ChromeDriver();
            }
         else if (browsername.equalsIgnoreCase("edge")) {
            // Configuring WebDriverManager for Edge
            edgedriver.setup();
            driver = new EdgeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            // Configuring WebDriverManager for Firefox
            firefoxdriver.setup();
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("ie")) {
            // Configuring WebDriverManager for Internet Explorer
            iedriver.setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browsername);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}