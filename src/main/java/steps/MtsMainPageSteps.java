package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MtsMainPage;

import java.util.ArrayList;
import java.util.List;

public class MtsMainPageSteps {

    private final MtsMainPage mtsMainPage;

    public MtsMainPageSteps(WebDriver driver) {
        this.mtsMainPage = new MtsMainPage(driver);
    }

    public void chooseCommunicationServiceButton() {
        mtsMainPage.choseElement(mtsMainPage.getCommunicationServiceButton());
    }

    public void chooseHomeInternetButton() {
        mtsMainPage.choseElement(mtsMainPage.getHomeInternetButton());
    }

    public void chooseCreditButton() {
        mtsMainPage.choseElement(mtsMainPage.getCreditButton());
    }

    public void chooseDebtButton() {
        mtsMainPage.choseElement(mtsMainPage.getDebtButton());
    }

    public List<String> getInputsPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder: mtsMainPage.getInputs()) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }
}