import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.MtsMainPageSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static steps.DriverInstance.*;

public class MtsTest {

    private MtsMainPageSteps steps;

    @BeforeEach
    public void setUp() {
        driver = getInstance();
        steps = new MtsMainPageSteps(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        WebElement acceptCookieButton = driver.findElement(By.id("cookie-agree"));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()){
            acceptCookieButton.click();
        }
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    @Test
    @DisplayName("Сhecking placeholders on the \"communication services\" page")
    public void checkTestCommunicationServicesPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseCommunicationServiceButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Сhecking placeholders on the \"home internet\" page")
    public void checkTestHomeInternetPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseHomeInternetButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }


    @Test
    @DisplayName("Сhecking placeholders on the \"credit\" page")
    public void checkTestCreditPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseCreditButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }


    @Test
    @DisplayName("Сhecking placeholders on the \"debt\" page")
    public void checkTestDebtPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(
                Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека")
        );
        steps.chooseDebtButton();
        List<String> placeholders = steps.getInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Checking the correctness of the amount display")
    public void testIframeSumText() {
        steps.sendInputs();
        String iframeSumText = steps.getIframeSumText();
        assertEquals("20.00 BYN", iframeSumText);
    }

    @Test
    @DisplayName("Checking that the amount on the button is displayed correctly")
    public void testIframeSumButtonText() {
        steps.sendInputs();
        String iframeSumButtonText = steps.getIframeSumButtonText();
        assertEquals(" Оплатить  20.00 BYN <!---->", iframeSumButtonText);
    }

    @Test
    @DisplayName("Сhecking whether the phone number is displayed correctly")
    public void testIframePhoneNumberText() {
        steps.sendInputs();
        String iframePhoneText = steps.getIframePhoneText();
        assertEquals("Оплата: Услуги связи\nНомер:375336319034", iframePhoneText);
    }

    @Test
    @DisplayName("Сhecking placeholders on the iframe \"communication services\" page")
    public void testIframeCommunicationServicesPlaceholders() {
        List<String> expectedPlaceholders = new ArrayList<>(Arrays.asList(
                        "Номер карты", "Имя держателя (как на карте)", "Срок действия", "CVC"
                ));
        steps.sendInputs();
        List<String> placeholders = steps.getIframeInputsPlaceholders();
        assertIterableEquals(expectedPlaceholders, placeholders);
    }

    @Test
    @DisplayName("Сhecking icons on the iframe \"communication services\" page")
    public void testIframeCommunicationServicesIcons() {
        List<String> expectedIcons = new ArrayList<>(Arrays.asList(
                "visa-system", "mastercard-system", "belkart-system"
        ));
        steps.sendInputs();
        List<String> icons = steps.getIframeIconsName();
        assertIterableEquals(expectedIcons, icons);
    }
}

