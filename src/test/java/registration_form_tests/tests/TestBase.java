package registration_form_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Link;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {

    public static File imageFolder = new File("src/test/resources/temp");
    public static final String allureSelenide = "allureSelenide";
    public static final String baseUrl = "https://demoqa.com";

    @BeforeAll
    @Link(name = "demoqa.com", value = baseUrl)
    @DisplayName("Подготавливаем тестовый стенд")
    public static void initTests() {
        step("Проверяем наличие папки (иначе создаем ее) для хранения временных изображений,", () -> {
            assert imageFolder.exists() || imageFolder.mkdirs();
        });
        step("Добавляем слушателя AllureSelenide", () -> SelenideLogger.addListener(allureSelenide, new AllureSelenide()));
        step("Выставляем базовый URL ", () -> {
            Configuration.baseUrl = baseUrl;
        });
//        step("Подключаем браузер на удаленном сервере с Selenoid", TestBase::addRemoteBrowser);
    }

    @BeforeEach
    @Link(name = "Registration Form", value = baseUrl + "/automation-practice-form")
    @DisplayName("Выполняем предварительные шаги")
    public void openPage() {
        step("Открываем страницу с формой регистрации", () -> open("/automation-practice-form"));
        step("Очищаем окно от рекламы с помощью JavaScript", () -> {
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('iframe').remove()");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('#close-fixedban').remove()");
            executeJavaScript("$('input').removeAttr('required')");
        });
    }

    @AfterAll
    @DisplayName("Приводим тестовый стенд в исходное состояние")
    public static void finishTests() {
        step("Удаляем все файлы из папки для хранения временных изображений", () -> {
            File[] files = imageFolder.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(File::delete);
            }
        });
        step("Закрываем webdriver", Selenide::closeWebDriver);
        step("Удаляем слушателя AllureSelenide", () -> {
            SelenideLogger.removeListener(allureSelenide);
        });
    }

    private static void addRemoteBrowser() {
        step("Выставляем URL сервера с Selenoid", () -> {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        });
        step("Выставляем параметры для работы с удаленным браузером", () -> {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setJavascriptEnabled(false);
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        });
    }
}

