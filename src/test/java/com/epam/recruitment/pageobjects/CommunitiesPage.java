package com.epam.recruitment.pageobjects;

import com.epam.recruitment.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CommunitiesPage extends CommonPageObject {

    @FindBy(css = "div.evnt-filters-heading-cell.cell-2 > div > input")
    private WebElement searchBox;

    @FindBy(css = ".evnt-communities-column:nth-child(1)")
    private WebElement firstCommunityCard;

    @FindBy(css = ".evnt-communities-column:nth-child(1) h1 span")
    private WebElement firstCommunityCardText;

    @FindBy(className = "evnt-search-clear")
    private WebElement searchClearButton;

    @FindBy(id = "filter_location")
    private WebElement filterLocationDropdown;

    @FindBy(css = ".evnt-dropdown-filter.show .evnt-search")
    private WebElement locationSearchBox;

    @FindBy(css = ".evnt-dropdown-filter.show .evnt-filter-item:nth-child(1) label")
    private WebElement firstDropdownCheckBox;

    @FindBy(css = ".evnt-tag.evnt-filters-tags:nth-child(1) > label")
    private WebElement firstFilterLabel;

    @FindBy(css = ".evnt-info-cell .location span")
    private WebElement communityLocation;

    @FindBy(css = ".evnt-dropdown-filter.show .evnt-clear-button")
    private WebElement locationClearAllButton;

    @FindBy(className = "evnt-communities-column")
    private List<WebElement> allCards;

    private final Map<String, WebElement> communitiesElementMap1 = Map.of(
            "search box", searchBox,
            "first community card", firstCommunityCard,
            "first community card text", firstCommunityCardText,
            "search clear button", searchClearButton,
            "filter location dropdown", filterLocationDropdown,
            "location search box", locationSearchBox,
            "first dropdown check box", firstDropdownCheckBox,
            "first filter label", firstFilterLabel,
            "community location", communityLocation,
            "location clear all button", locationClearAllButton
    );

    public CommunitiesPage(final WebDriverFactory factory) {
        super(factory);
    }

    public void clickOnElement(String elementName) {
        WebElement element = communitiesElementMap1.get(elementName);

        waitForElementToBeClickable(element);
        element.click();
    }

    public WebElement getElement(String elementName) {
        return communitiesElementMap1.get(elementName);
    }

    public List<WebElement> getAllCards() {
        return allCards;
    }

    public void waitForCommunityPageToLoadFully() {
        waitForElementToLoad("evnt-communities-wrapper");
    }

    public void waitForCommunityCardPageToLoadFully() {
        waitForElementToLoad("evnt-panel-wrapper");
    }

    public void firstCommunityCardTextShouldBeExpected(String elementText) {
        waitForElementTextToBeUpdated(elementText, firstCommunityCardText);
    }
}
