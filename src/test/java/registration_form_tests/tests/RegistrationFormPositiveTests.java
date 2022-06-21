package registration_form_tests.tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import registration_form_tests.pages.StudentsRegistrationFormPage;
import registration_form_tests.tests.test_data.TestSimpleData;
import registration_form_tests.tests.test_data.enums.Genders;
import registration_form_tests.tests.test_data.enums.Hobbies;
import registration_form_tests.tests.test_data.enums.StatesCities;
import registration_form_tests.tests.test_data.enums.Subjects;

import java.io.File;

import static com.codeborne.selenide.Condition.text;

class RegistrationFormPositiveTests extends TestBase {

    StudentsRegistrationFormPage registrationFormPage = new StudentsRegistrationFormPage();

    @Test
    @DisplayName("Testing All Fields of Registration Form")
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

    @ParameterizedTest(name = "FirstName field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#firstNameData")
    void firstNameFieldTest(String firstName) {
        registrationFormPage.setFirstName(firstName);
        registrationFormPage.pressSubmitButton();
        checkInResult(firstName);
    }

    @ParameterizedTest(name = "FirstName field tests via Value Sourse with: {0}")
    @ValueSource(strings = {"Wade", "Dave", "Seth", "Ivan", "Riley", "Gilbert", "Jorge", "Dan", "Brian", "Roberto"})
    void firstNameFieldTestValueSource(String strings) {
        registrationFormPage.setFirstName(strings);
        registrationFormPage.pressSubmitButton();
        checkInResult(strings);
    }

    @ParameterizedTest(name = "LastName field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#lastNameData")
    void lastNameFieldTest(String lastName) {
        registrationFormPage.setLastName(lastName);
        registrationFormPage.pressSubmitButton();
        checkInResult(lastName);
    }

    @ParameterizedTest(name = "LastName field tests via Value Sourse with: {0}")
    @ValueSource(strings = {"Williams", "Harris", "Thomas", "Robinson", "Walker",
            "Scott", "Nelson", "Mitchell", "Morgan", "Cooper"})
    void lastNameFieldTestValueSource(String lastName) {
        registrationFormPage.setLastName(lastName);
        registrationFormPage.pressSubmitButton();
        checkInResult(lastName);
    }

    @ParameterizedTest(name = "Email field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#emailAddressData")
    void emailFieldTest(String email) {
        registrationFormPage.setUserEmail(email);
        registrationFormPage.pressSubmitButton();
        checkInResult(email);
    }

    @ParameterizedTest(name = "Gender RadioButton tests with: {0}")
    @EnumSource(Genders.class)
    void genderRadioButtonTest(@NotNull Genders enumerate) {
        String gender = enumerate.nameToCapitalize();
        registrationFormPage.selectGender(gender);
        registrationFormPage.pressSubmitButton();
        checkInResult(gender);
    }

    @ParameterizedTest(name = "Mobile field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#phoneNumberData")
    void phoneNumberFieldTest(String number) {
        registrationFormPage.setPhoneNumber(number);
        registrationFormPage.pressSubmitButton();
        checkInResult(number);
    }

    @ParameterizedTest(name = "Date of Birth field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#dateOfBirthData")
    void dateOfBirthFieldTest(String @NotNull [] date) {
        registrationFormPage.setDateOfBirth(date);
        registrationFormPage.pressSubmitButton();
        String dateForAssert = date[0] + ' ' + date[1] + ',' + date[2];
        checkInResult(dateForAssert);
    }

    @ParameterizedTest(name = "Subjects field tests with: {0}")
    @EnumSource(Subjects.class)
    void subjectsFieldTest(@NotNull Subjects enumerate) {
        String subject = enumerate.nameToCapitalize();
        registrationFormPage.selectSubjects(subject);
        registrationFormPage.pressSubmitButton();
        checkInResult(subject);
    }

    @ParameterizedTest(name = "Hobbies field tests with: {0}")
    @EnumSource(Hobbies.class)
    void hobbiesCheckboxTest(@NotNull Hobbies enumerate) {
        String hobby = enumerate.nameToCapitalize();
        registrationFormPage.selectHobby(hobby);
        registrationFormPage.pressSubmitButton();
        checkInResult(hobby);
    }

    @ParameterizedTest(name = "File upload tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#imageFileData")
    void uploadFileTest(File file) {
        registrationFormPage.uploadPicture(file);
        registrationFormPage.pressSubmitButton();
        checkInResult(file.getName());
    }

    @ParameterizedTest(name = "Address field tests with: {0}")
    @MethodSource("registration_form_tests.tests.test_data.PositiveTestDataProvider#addressData")
    void addressFieldTest(String address) {
        registrationFormPage.setAddress(address);
        registrationFormPage.pressSubmitButton();
        checkInResult(address);
    }

    @ParameterizedTest(name = "State and City fields tests for: {0}")
    @EnumSource(StatesCities.class)
    void stateAndCityComboboxTest(@NotNull StatesCities enumerate) {
        String state = enumerate.state();
        String city = enumerate.city();
        registrationFormPage.selectStateCity(state, city);
        registrationFormPage.pressSubmitButton();
        checkInResult(state);
    }

    @Step("Проверяем наличие в таблице с результатами ранее введенных в форму данных")
    private void checkInResult(String @NotNull ... keys) {
        SelenideElement resultTable = registrationFormPage.getResultForm();
        for (String key : keys) {
            resultTable.shouldHave(text(key));
        }
    }
}

