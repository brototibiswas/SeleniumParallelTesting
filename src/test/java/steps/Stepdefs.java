package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Stepdefs {
    WebDriver driver;

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {

    }

    @And("Searches for a {string}")
    public void searchesForA(String term) {
        
    }

    @Then("User clicks on the third result")
    public void userClicksOnTheThirdResult() {

    }

    @And("User should be able to open in a new tab")
    public void userShouldBeAbleToOpenInANewTab() {
    }
}
