package com.epam.recruitment.stepdefinitions;

import com.epam.recruitment.config.TestConfig;
import com.epam.recruitment.pageobjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class HomePageStepDefs {

    private final HomePage homePage;

    public HomePageStepDefs(HomePage homePage) {
        this.homePage = homePage;
    }

    @After
    public void deleteCookies() {
        homePage.deleteAllCookies();
    }

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.navigateToHomePage();
        homePage.waitForHomePageToLoadFully();
    }

    @And("the {string} is clicked on home page")
    public void theElementIsClickedOnHomePage(String elementName) {
        homePage.clickOnElement(elementName);
    }
}
