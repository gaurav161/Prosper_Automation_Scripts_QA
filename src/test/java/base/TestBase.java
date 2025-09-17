package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    protected WebDriver driver;
    protected Properties config;

    @BeforeClass
    public void setUp() {
        loadConfig();

        // ✅ Set the Chrome driver path from config
        System.setProperty("webdriver.chrome.driver", config.getProperty("chrome.driver.path"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("base.url"));
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadConfig() {
        config = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }
}
