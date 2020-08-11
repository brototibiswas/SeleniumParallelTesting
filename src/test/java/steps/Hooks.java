package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

public class Hooks {
    public static WebDriver driver;

    /**
     * Set driver to browser
     * Default browser: Chrome
     */
    @Before
    public void setDriver() {
        String browser = System.getProperty("browser","chrome");

        switch(browser) {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Close all the tabs and quit browser
     */
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
