package com.epam.recruitment.stepdefinitions;

import com.epam.recruitment.pageobjects.CommunitiesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CommunitiesStepDefs {

    private final CommunitiesPage communitiesPage;

    public CommunitiesStepDefs(CommunitiesPage communitiesPage) {
        this.communitiesPage = communitiesPage;
    }

    @And("the community page is opened")
    public void theCommunityPageIsOpened() {
        communitiesPage.waitForCommunityPageToLoadFully();
    }

    @And("the community card page is opened")
    public void theCommunityCardPageIsOpened() {
        communitiesPage.waitForCommunityCardPageToLoadFully();
    }

    @When("the {string} is clicked on communities page")
    public void theElementIsClickedOnCommunitiesPage(String elementName) {
        communitiesPage.clickOnElement(elementName);
    }

    @And("the {string} is filled with {string}")
    public void theElementFilledWithStringOnCommunitiesPage(String elementName, String searchText) {
        communitiesPage.getElement(elementName).sendKeys(searchText);
    }

    @Then("first community card text should be {string}")
    public void firstCommunityCardTextShouldBeExpected(String expectedElementText) {
        communitiesPage.firstCommunityCardTextShouldBeExpected(expectedElementText);
    }

    @And("the {string} should be shown")
    public void theElementShouldBeShown(String elementName) {
        Assert.assertTrue(communitiesPage.getElement(elementName).isDisplayed());
    }

    @And("there are one or more communities")
    public void thereAreOneOrMoreCommunities() {
        Assert.assertTrue(communitiesPage.getAllCards().size() > 0);
    }

    @And("the {string} is contains the {string}")
    public void theActualIsContainsTheExpectedOnCommunitiesPage(String elementName, String expected) {
        String actual = communitiesPage.getElement(elementName).getText();
        Assert.assertTrue(actual.contains(expected));
    }
}
