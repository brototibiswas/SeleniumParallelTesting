package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.Homepage;

public class Stepdefs {
    Homepage homepage;

    @Given("User navigates to {string}")
    public void userNavigatesTo(String url) {
        homepage = new Homepage(url);
        homepage.openBrowser(url);
    }

    @And("Searches for a {string}")
    public void searchesForA(String term) {
        System.out.println("search");
        homepage.search(term);
    }

    @Then("User clicks on the third result")
    public void userClicksOnTheThirdResult() {
        System.out.println("third");
    }

    @And("User should be able to open in a new tab")
    public void userShouldBeAbleToOpenInANewTab() {
        System.out.println("new tab");
    }
}
