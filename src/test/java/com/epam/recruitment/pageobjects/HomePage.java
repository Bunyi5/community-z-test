package com.epam.recruitment.pageobjects;

import com.epam.recruitment.factory.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HomePage extends CommonPageObject {

    private static final String HOME_PAGE_URL = "https://community-z.com/";

    @FindBy(css = "li.nav-item.communities-icon > a")
    private WebElement communitiesNavbarLink;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieAcceptButton;

    private final Map<String, WebElement> homePageElementMap = Map.of(
            "communities navbar link", communitiesNavbarLink,
            "cookie accept button", cookieAcceptButton
    );

    public HomePage(final WebDriverFactory factory) {
        super(factory);
    }

    public void navigateToHomePage() {
        navigateToUrl(HOME_PAGE_URL);
    }

    public void waitForHomePageToLoadFully() {
        waitForElementToLoad("evnt-welcome-communities-panel");
    }

    public void clickOnElement(String elementName) {
        WebElement element = homePageElementMap.get(elementName);

        waitForElementToBeClickable(element);
        element.click();
    }
}
