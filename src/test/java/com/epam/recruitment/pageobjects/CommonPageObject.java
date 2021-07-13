package com.epam.recruitment.pageobjects;

import com.epam.recruitment.factory.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.recruitment.config.TestConfig.PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS;

public class CommonPageObject {

    private final WebDriverFactory factory;

    public CommonPageObject(final WebDriverFactory factory) {
        PageFactory.initElements(factory.getWebDriver(), this);
        this.factory = factory;
    }

    public WebDriver getWebDriverFromFactory() {
        return factory.getWebDriver();
    }

    protected void navigateToUrl(final String url) {
        getWebDriverFromFactory().get(url);
    }

    public void deleteAllCookies() {
        getWebDriverFromFactory().manage().deleteAllCookies();
    }

    public void waitForElementToLoad(String mainSelector) {
        new WebDriverWait(getWebDriverFromFactory(), PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className(mainSelector)));
    }

    public void waitForElementToBeClickable(final WebElement webElement) {
        new WebDriverWait(getWebDriverFromFactory(), PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitForElementTextToBeUpdated(String elementText, WebElement webElement) {
        new WebDriverWait(getWebDriverFromFactory(), PAGE_OR_ELEMENT_LOAD_WAIT_SECONDS)
                .ignoring(NoSuchElementException.class)
                .until((ExpectedCondition<Boolean>) driver -> elementText.equals(webElement.getText()));
    }
}
