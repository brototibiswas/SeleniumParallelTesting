package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement searchBar;
    WebElement searchBtn;

    public Homepage(String url) {
        this.driver = Hooks.driver;
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
            searchBar = driver.findElement(By.name("q"));
            searchBtn = driver.findElement(By.name("btnK"));
        }
        else if(url.toLowerCase().contains("youtube")) {
            searchBar = driver.findElement(By.name("search_query"));
            searchBtn = driver.findElement(By.id("search-icon-legacy"));
        }
    }
}
