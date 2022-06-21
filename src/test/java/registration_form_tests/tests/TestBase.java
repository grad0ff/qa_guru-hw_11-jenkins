package registration_form_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static File imageFolder = new File("src/test/resources/temp");

    @BeforeAll
    public static void initTests() {
        Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("allure", new AllureSelenide());
        assert imageFolder.exists() || imageFolder.mkdir();
    }

    @BeforeEach
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");
        executeJavaScript("$('input').removeAttr('required')");
    }

    @AfterAll
    public static void finishTests() {
        File[] files = imageFolder.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(File::delete);
            closeWebDriver();
        }
        SelenideLogger.removeListener("allure");
    }

}

