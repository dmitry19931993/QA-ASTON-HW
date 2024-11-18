package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        element.click();
    }

    public List<WebElement> getInputs() {
        return driver.findElements(inputs);
    }

}
