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

    public void sendInputs() {
        WebElement connectionPhone = mtsMainPage.getInputs().get(0);
        connectionPhone.sendKeys("336319034");
        WebElement connectionSum = mtsMainPage.getInputs().get(1);
        connectionSum.sendKeys("20");
        WebElement connectionEmail = mtsMainPage.getInputs().get(2);
        connectionEmail.sendKeys("mts@mail.ru");
        mtsMainPage.getContinueButton().click();
        mtsMainPage.switchIframeCommunicationServices();
    }

    public String getIframeSumText(){
        return mtsMainPage.getIframeSumTextElement().getAttribute("innerHTML");
    }

    public String getIframeSumButtonText(){
        return mtsMainPage.getIframeSumButtonElement().getAttribute("innerHTML");
    }

    public String getIframePhoneText() {
        return mtsMainPage.getIframePhoneText().getAttribute("innerHTML");
    }

    public List<String> getIframeInputsPlaceholders() {
        List<String> iframePlaceholders = new ArrayList<>();
        for (WebElement iframePlaceholder: mtsMainPage.getIframeInputs()) {
            iframePlaceholders.add(iframePlaceholder.getText());
        }
        return iframePlaceholders;
    }

    public List<String> getIframeIconsName() {
        List<String> iframeIcons = new ArrayList<>();
        for (WebElement iframeIcon: mtsMainPage.getIfraneIcons()) {
            String url = iframeIcon.getAttribute("src");
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            String nameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
            iframeIcons.add(nameWithoutExtension);
        }
        return iframeIcons;
    }


}