package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObjects.Homepage;

import java.sql.Driver;

public class Stepdefs {
    WebDriver driver;
    Homepage homepage;

    public Stepdefs() {
        driver = Hooks.getDriver();
    }

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        homepage = new Homepage(driver);
        homepage.openBrowser(url);
        System.out.println("Thread ID - "+Thread.currentThread().getId());
    }

    @And("Searches for a {string}")
    public void searchesForA(String term) {
        System.out.println("search");
        homepage.search(term);
    }

    @Then("User clicks on the third result")
    public void userClicksOnTheThirdResult() {
        homepage.openThirdResult();
    }

    @And("User should be able to open in a new tab")
    public void userShouldBeAbleToOpenInANewTab() {
        homepage.openInNewTab();
    }
}
