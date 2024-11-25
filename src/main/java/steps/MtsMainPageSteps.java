package steps;

import io.qameta.allure.Step;
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

    @Step("Выбор страницы «Услуги связи»")
    public void chooseCommunicationServiceButton() {
        mtsMainPage.choseElement(mtsMainPage.getCommunicationServiceButton());
    }

    @Step("Выбор страницы «Домашний интернет»")
    public void chooseHomeInternetButton() {
        mtsMainPage.choseElement(mtsMainPage.getHomeInternetButton());
    }

    @Step("Выбор страницы «Рассрочка»")
    public void chooseCreditButton() {
        mtsMainPage.choseElement(mtsMainPage.getCreditButton());
    }

    @Step("Выбор страницы «Задолженность»")
    public void chooseDebtButton() {
        mtsMainPage.choseElement(mtsMainPage.getDebtButton());
    }

    @Step("Получение списка плейсхолдеров")
    public List<String> getInputsPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement placeholder: mtsMainPage.getInputs()) {
            placeholders.add(placeholder.getAttribute("placeholder"));
        }
        return placeholders;
    }

    @Step("Ввод Данных")
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

    @Step("Получение данных отображения суммы")
    public String getIframeSumText(){
        return mtsMainPage.getIframeSumTextElement().getAttribute("innerHTML");
    }

    @Step("Получение данных отображения суммы на кнопке оплаты")
    public String getIframeSumButtonText(){
        return mtsMainPage.getIframeSumButtonElement().getAttribute("innerHTML");
    }

    @Step("Получение данных отображения номера телефона")
    public String getIframePhoneText() {
        return mtsMainPage.getIframePhoneText().getAttribute("innerHTML");
    }

    @Step("Получение списка плейсхолдеров во фрейме")
    public List<String> getIframeInputsPlaceholders() {
        List<String> iframePlaceholders = new ArrayList<>();
        for (WebElement iframePlaceholder: mtsMainPage.getIframeInputs()) {
            iframePlaceholders.add(iframePlaceholder.getText());
        }
        return iframePlaceholders;
    }

    @Step("Получение списка иконок платежных систем во фрейме")
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