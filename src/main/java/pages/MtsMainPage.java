package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class MtsMainPage extends BasePage {
    private final By upButton = By.xpath(
            "//span[@class = 'select__arrow']"
    );

    private final By communicationServiceButton = By.xpath(
            "//p[@class='select__option' and text()='Услуги связи']"
    );

    private final By homeInternetButton = By.xpath(
            "//p[@class='select__option' and text()='Домашний интернет']"
    );

    private final By creditButton = By.xpath(
            "//p[@class='select__option' and text()='Рассрочка']"
    );

    private final By debtButton = By.xpath(
            "//p[@class='select__option' and text()='Задолженность']"
    );

    private final By inputs = By.xpath(
            "//form[@class ='pay-form opened']//input"
    );

    private final By continueButton = By.xpath(
            "//form[@class = \"pay-form opened\"]" +
                    "//button[@class = \"button button__default \"]"
    );

    private final By iframeCommunicationServices = By.xpath(
            "//iframe[@class = \"bepaid-iframe\"]"
    );

    private final By iframeSumText = By.xpath(
            "//div[@class = 'pay-description__cost']//span"
    );

    private final By iframeSumButton = By.xpath(
            "//button[@type='submit' and contains(@class, 'colored')]"
    );

    private final By iframePhoneText = By.xpath(
            "//div[@class = 'pay-description__text']//span"
    );

    private final By iframeCardNumber = By.xpath(
            "//label[@class = 'ng-tns-c46-1 ng-star-inserted']"
    );

    private final By iframeHolderName = By.xpath(
            "//label[@class = 'ng-tns-c46-3 ng-star-inserted']"
    );

    private final By iframeValidityPeriod = By.xpath(
            "//label[@class = 'ng-tns-c46-4 ng-star-inserted']"
    );

    private final By iframeCvc = By.xpath(
            "//label[@class = 'ng-tns-c46-5 ng-star-inserted']"
    );

    private final By iframeIcon = By.xpath(
            "//img[@class = 'ng-tns-c61-0 ng-star-inserted']"
    );

    public MtsMainPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUpButton() {
        return driver.findElement(upButton);
    }

    public WebElement getCommunicationServiceButton() {
        return driver.findElement(communicationServiceButton);
    }

    public WebElement getHomeInternetButton() {
        return driver.findElement(homeInternetButton);
    }

    public WebElement getCreditButton() {
        return driver.findElement(creditButton);
    }

    public WebElement getDebtButton() {
        return driver.findElement(debtButton);
    }

    public void choseElement(WebElement element) {
        getUpButton().click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public List<WebElement> getInputs() {
        return driver.findElements(inputs);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public WebElement getIframeCommunicationServices() {
        return driver.findElement(iframeCommunicationServices);
    }

    public void switchIframeCommunicationServices() {
        driver.switchTo().frame(getIframeCommunicationServices());
    }

    public WebElement getIframeSumTextElement() {
        return driver.findElement(iframeSumText);
    }

    public WebElement getIframeSumButtonElement() {
        return driver.findElement(iframeSumButton);
    }

    public WebElement getIframePhoneText() {
        return driver.findElement(iframePhoneText);
    }

    public List<WebElement> getIframeInputs() {
        List<WebElement> getIframeIputsElements = new ArrayList<WebElement>();
        getIframeIputsElements.add(driver.findElement(iframeCardNumber));
        getIframeIputsElements.add(driver.findElement(iframeHolderName));
        getIframeIputsElements.add(driver.findElement(iframeValidityPeriod));
        getIframeIputsElements.add(driver.findElement(iframeCvc));
        return getIframeIputsElements;
    }

    public List<WebElement> getIfraneIcons() {
        return driver.findElements(iframeIcon);
    }

}
