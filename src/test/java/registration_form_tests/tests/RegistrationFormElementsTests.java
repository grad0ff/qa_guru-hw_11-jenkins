package registration_form_tests.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import registration_form_tests.pages.StudentsRegistrationFormPage;
import registration_form_tests.tests.test_data.enums.Genders;
import registration_form_tests.tests.test_data.enums.Hobbies;
import registration_form_tests.tests.test_data.enums.StatesCities;
import registration_form_tests.tests.test_data.enums.Subjects;

import java.io.File;

import static com.codeborne.selenide.Condition.text;

@Disabled
@Owner("a_gradov")
@Severity(SeverityLevel.NORMAL)
@Feature("Регистрация студента через форму")
@DisplayName("Форма регистрации. Проверки отдельных элементов. Позитивные тесты")
class RegistrationFormElementsTests extends TestBase {

    StudentsRegistrationFormPage registrationFormPage = new StudentsRegistrationFormPage();

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#firstNameData")
    @Story("Пользователь указывает свое имя")
    @Description("Проверяется наличие введенных в поле First Name данных в таблице с результатами")
    @DisplayName("Проверяем поле First Name")
    void firstNameFieldTest(String firstName) {
        registrationFormPage.setFirstName(firstName);
        registrationFormPage.pressSubmitButton();
        checkInResult(firstName);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"Wade", "Dave", "Seth", "Ivan", "Riley", "Gilbert", "Jorge", "Dan", "Brian", "Roberto"})
    @Disabled("Duplicated")
    @Description("Проверяется наличие введенных в поле First Name данных в таблице с результатами")
    @Story("Пользователь указывает свое имя")
    @DisplayName("Проверяем поле First Name")
    void firstNameFieldTestValueSource(String strings) {
        registrationFormPage.setFirstName(strings);
        registrationFormPage.pressSubmitButton();
        checkInResult(strings);
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#lastNameData")
    @Story("Пользователь указывает свою фамилию")
    @Description("Проверяется наличие введенных в поле Last Name данных в таблице с результатами")
    @DisplayName("Проверяем поле Last Name")
    void lastNameFieldTest(String lastName) {
        registrationFormPage.setLastName(lastName);
        registrationFormPage.pressSubmitButton();
        checkInResult(lastName);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"Williams", "Harris", "Thomas", "Robinson", "Walker",
            "Scott", "Nelson", "Mitchell", "Morgan", "Cooper"})
    @Disabled("Duplicated")
    @Story("Пользователь указывает свою фамилию")
    @Description("Проверяется наличие введенных в поле Last Name данных в таблице с результатами")
    @DisplayName("Проверяем поле Last Name")
    void lastNameFieldTestValueSource(String lastName) {
        registrationFormPage.setLastName(lastName);
        registrationFormPage.pressSubmitButton();
        checkInResult(lastName);
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#emailAddressData")
    @Story("Пользователь указывает свой Email")
    @Description("Проверяется наличие введенных в поле Email данных в таблице с результатами")
    @DisplayName("Проверяем поле Email")
    void emailFieldTest(String email) {
        registrationFormPage.setUserEmail(email);
        registrationFormPage.pressSubmitButton();
        checkInResult(email);
    }

    @ParameterizedTest()
    @EnumSource(Genders.class)
    @Story("Пользователь указывает свой пол")
    @Description("Проверяется наличие названия радиобаттона из Gender в таблице с результатами")
    @DisplayName("Проверяем радиобаттоны Gender")
    void genderRadioButtonGenderTest(@NotNull Genders enumerate) {
        String gender = enumerate.nameToCapitalize();
        registrationFormPage.selectGender(gender);
        registrationFormPage.pressSubmitButton();
        checkInResult(gender);
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#phoneNumberData")
    @Story("Пользователь указывает свой номер телефона")
    @Description("Проверяется наличие введенных в поле Mobile данных в таблице с результатами")
    @DisplayName("Проверяем поле Mobile")
    void phoneNumberFieldTest(String number) {
        registrationFormPage.setPhoneNumber(number);
        registrationFormPage.pressSubmitButton();
        checkInResult(number);
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#dateOfBirthData")
    @Story("Пользователь указывает свою дату рождения")
    @Description("Проверяется наличие введенных в поле DateOfBirth данных в таблице с результатами")
    @DisplayName("Проверяем поле DateOfBirth")
    void dateOfBirthFieldTest(String @NotNull [] date) {
        registrationFormPage.setDateOfBirth(date);
        registrationFormPage.pressSubmitButton();
        String dateForAssert = date[0] + ' ' + date[1] + ',' + date[2];
        checkInResult(dateForAssert);
    }

    @ParameterizedTest()
    @EnumSource(Subjects.class)
    @Story("Пользователь указывает список предметов, выбирая из предложенных вариантов")
    @Description("Проверяется наличие введенных в поле Subjects данных в таблице с результатами")
    @DisplayName("Проверяем поле Subjects")
    void subjectsFieldTest(@NotNull Subjects enumerate) {
        String subject = enumerate.nameToCapitalize();
        registrationFormPage.selectSubjects(subject);
        registrationFormPage.pressSubmitButton();
        checkInResult(subject);
    }

    @ParameterizedTest()
    @EnumSource(Hobbies.class)
    @Story("Пользователь указывает свое хобби, выбирая из предложенных вариантов")
    @Description("Проверяется наличие названия выбранного чекбокса из Hobbies в таблице с результатами")
    @DisplayName("Проверяем чекбоксы в Hobbies")
    void hobbiesCheckboxTest(@NotNull Hobbies enumerate) {
        String hobby = enumerate.nameToCapitalize();
        registrationFormPage.selectHobby(hobby);
        registrationFormPage.pressSubmitButton();
        checkInResult(hobby);
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#imageFileData")
    @Story("Пользователь загружает свою фотографию")
    @Description("Проверяется наличие названия загруженного изображения в таблице с результатами")
    @DisplayName("Проверяем загрузку файла изображения через форму")
    void uploadPictureTest(File file) {
        registrationFormPage.uploadPicture(file);
        registrationFormPage.pressSubmitButton();
        checkInResult(file.getName());
    }

    @ParameterizedTest()
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#addressData")
    @Story("Пользователь указывает свой адрес")
    @Description("Проверяется наличие введенных в поле Address данных в таблице с результатами")
    @DisplayName("Проверяем поле Address")
    void addressFieldTest(String address) {
        registrationFormPage.setAddress(address);
        registrationFormPage.pressSubmitButton();
        checkInResult(address);
    }

    @ParameterizedTest()
    @EnumSource(StatesCities.class)
    @Story("Пользователь указывает штат и город откуда он приехал")
    @Description("Проверяется наличие названий выбранных State и City в таблице с результатами")
    @DisplayName("Проверяем выпадающие списки State и City")
    void stateAndCityComboboxTest(@NotNull StatesCities enumerate) {
        String state = enumerate.state();
        String city = enumerate.city();
        registrationFormPage.selectStateCity(state, city);
        registrationFormPage.pressSubmitButton();
        checkInResult(state);
    }

    @Step("Выполняем проверку в таблице с результатами")
    private void checkInResult(String @NotNull ... keys) {
        SelenideElement resultTable = registrationFormPage.getResultForm();
        for (String key : keys) {
            resultTable.shouldHave(text(key));
        }
    }
}

