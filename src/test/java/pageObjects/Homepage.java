package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class Homepage {
    public WebDriver driver;
    WebDriverWait wait;
    WebElement searchBar;
    WebElement searchBtn;
    String domain;
    WebElement result;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    /**
     * Navigate to specified url
     */
    public void openBrowser(String url) {
        driver.get(url);
        setPageObjects(url);
    }

    /**
     * Search for given term
     * Input term in searchbar and click search button
     */
    public void search(String term) {
        wait.until(ExpectedConditions.visibilityOf(searchBar));
        searchBar.sendKeys(term);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    /**
     * Set searchbar and search button to it's locator based on domain
     */
    private void setPageObjects(String url) {
        if(url.toLowerCase().contains("google")) {
            domain = "google";
            searchBar = driver.findElement(By.name("q"));
            searchBtn = driver.findElement(By.name("btnK"));
        }
        else if(url.toLowerCase().contains("youtube")) {
            domain = "youtube";
            searchBar = driver.findElement(By.name("search_query"));
            searchBtn = driver.findElement(By.id("search-icon-legacy"));
        }
    }

    public void openThirdResult() {
        if(domain.equals("google")) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rso")));
            result = driver.findElement(By.xpath("//div[contains(@class,'g')][3]/div[contains(@class,'rc')]/div[contains(@class,'r')]/a"));
        }
        else if(domain.equals("youtube")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("contents")));
            result = driver.findElement(By.xpath("(//a[@id='video-title'])[3]"));
        }
    }

    public void openInNewTab() {
        Actions action = new Actions(driver);

        //Get OS name.
        String OS = System.getProperty("os.name").toLowerCase();

        //for mac
        if(OS.contains("mac")) {
            action.keyDown(Keys.COMMAND)
                    .click(result)
                    .keyUp(Keys.COMMAND)
                    .build()
                    .perform();
        }
        //for windows and linux
        else {
            action.keyDown(Keys.CONTROL)
                    .click(result)
                    .keyUp(Keys.CONTROL)
                    .build()
                    .perform();
        }
    }

}
