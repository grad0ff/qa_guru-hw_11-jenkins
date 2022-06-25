package registration_form_tests.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import registration_form_tests.pages.StudentsRegistrationFormPage;
import registration_form_tests.tests.test_data.TestSimpleData;

import static com.codeborne.selenide.Condition.text;

@Tag("smoke")
@Owner("a_gradov")
@Severity(SeverityLevel.CRITICAL)
@Feature("Регистрация студента через форму")
@DisplayName("Форма регистрации. Проверка всех элементов. Позитивный тест")
public class RegistrationFormSmokeTest extends TestBase {

    StudentsRegistrationFormPage registrationFormPage = new StudentsRegistrationFormPage();

    @Test
    @Description("За один тест проверяются все поля формы. " +
            "Проверяется наличие всех введенных данных в таблице с результатами")
    @Story("Пользователь регистрируется через форму")
    @DisplayName("Проверяем все поля формы")
    void allFieldsTest() {
        registrationFormPage.setFirstName(TestSimpleData.FIRST_NAME);
        registrationFormPage.setLastName(TestSimpleData.LAST_NAME);
        registrationFormPage.setUserEmail(TestSimpleData.EMAIL);
        registrationFormPage.selectGender(TestSimpleData.GENDER);
        registrationFormPage.setPhoneNumber(TestSimpleData.PHONE_NUMBER);
        registrationFormPage.setDateOfBirth(TestSimpleData.FULL_DATE);
        registrationFormPage.selectSubjects(TestSimpleData.SUBJECT);
        registrationFormPage.selectHobby(TestSimpleData.HOBBIES);
        registrationFormPage.uploadPicture(TestSimpleData.filePhoto);
        registrationFormPage.setAddress(TestSimpleData.ADDRESS);
        registrationFormPage.selectStateCity(TestSimpleData.STATE, TestSimpleData.CITY);
        registrationFormPage.pressSubmitButton();

        checkInResult(
                TestSimpleData.FIRST_NAME,
                TestSimpleData.LAST_NAME,
                TestSimpleData.EMAIL,
                TestSimpleData.GENDER,
                TestSimpleData.PHONE_NUMBER,
                TestSimpleData.DATE_FOR_ASSERT,
                TestSimpleData.SUBJECT,
                TestSimpleData.HOBBIES,
                TestSimpleData.filePhoto.getName(),
                TestSimpleData.ADDRESS,
                TestSimpleData.STATE,
                TestSimpleData.CITY);
    }

    @Step("Выполняем проверку в таблице с результатами")
    private void checkInResult(String @NotNull ... keys) {
        SelenideElement resultTable = registrationFormPage.getResultForm();
        for (String key : keys) {
            resultTable.shouldHave(text(key));
        }
    }
}
