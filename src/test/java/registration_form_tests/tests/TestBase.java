package registration_form_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.Link;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestBase {

    private static final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public static File imageFolder = new File("src/test/resources/temp");
    public static final String allureSelenide = "allureSelenide";
    public static final String baseUrl = "https://demoqa.com";

    @BeforeAll
    @Link(name = "demoqa.com", value = baseUrl)
    @DisplayName("Подготавливаем тестовый стенд")
    public static void initTests() {
        step(
                "Выставляем браузер для выполнения тестов",
                () -> Configuration.browser = System.getProperty("browser", "chrome")
        );
        step(
                "Подключаем удаленный сервер с Selenoid",
                TestBase::addRemoteBrowser
        );
        step(
                "Выставляем базовый URL ",
                () -> Configuration.baseUrl = baseUrl
        );
        step(
                "Добавляем слушателя AllureSelenide",
                () -> SelenideLogger.addListener(allureSelenide, new AllureSelenide())
        );
        step(
                "Проверяем наличие папки (иначе создаем ее) для хранения временных изображений,",
                () -> {
                    assert imageFolder.exists() || imageFolder.mkdirs();
                }
        );
    }

    @BeforeEach
    @Link(name = "Registration Form", value = baseUrl + "/automation-practice-form")
    @DisplayName("Выполняем предварительные шаги")
    public void openPage() {
        step(
                "Открываем страницу с формой регистрации",
                () -> open("/automation-practice-form")
        );
        step(
                "Очищаем окно от рекламы с помощью JavaScript",
                () -> {
                    executeJavaScript("$('footer').remove()");
                    executeJavaScript("$('iframe').remove()");
                    executeJavaScript("$('#fixedban').remove()");
                    executeJavaScript("$('#close-fixedban').remove()");
                    executeJavaScript("$('input').removeAttr('required')");
                }
        );
    }

    @AfterEach
    void addAttachs() {
        step(
                "Добавляем аттачи",
                () -> {
                    Attach.addConsoleLog("Log");
                    Attach.addScreenshot("Screenshot");
                    Attach.addPageSource();
                    Attach.addVideo();
                }
        );
    }

    @AfterAll
    @DisplayName("Приводим тестовый стенд в исходное состояние")
    public static void finishTests() {
        step(
                "Удаляем все файлы из папки для хранения временных изображений",
                () -> {
                    File[] files = imageFolder.listFiles();
                    if (files != null) Arrays.stream(files).forEach(File::delete);
                }
        );
        step(
                "Закрываем webdriver",
                Selenide::closeWebDriver
        );
        step(
                "Удаляем слушателя AllureSelenide",
                () -> SelenideLogger.removeListener(allureSelenide)
        );
    }

    private static void addRemoteBrowser() {
        String login = config.login();
        String password = config.password();

        step(
                "Выставляем URL сервера",
                () -> Configuration.remote = String.format(
                        "https://%s:%s@selenoid.autotests.cloud/wd/hub", login, password
                )
        );
        step(
                "Выставляем параметры для работы с удаленным браузером",
                () -> {
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setCapability("enableVNC", true);
                    capabilities.setCapability("enableVideo", true);
                    Configuration.browserCapabilities = capabilities;
                }
        );
    }
}

