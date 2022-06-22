package registration_form_tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import registration_form_tests.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StudentsRegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Заполняем поле First Name")
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    @Step("Заполняем поле Last Name")
    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @Step("Заполняем поле Email")
    public void setUserEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Выбираем радиобаттон Gender")
    public void selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    @Step("Заполняем поле Mobile")
    public void setPhoneNumber(String phone) {
        $("#userNumber").setValue(phone);
    }

    @Step("Заполняем поле DateOfBirth...")
    public void setDateOfBirth(String @NotNull [] date) {
        calendarComponent.setDate(date[0], date[1], date[2]); // может, лучше через мапу, но пока не изучил :(
    }

    @Step("Заполняем поле Subjects (принимаемые значения изначально скрыты)")
    public void selectSubjects(String subject) {
        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();
    }

    @Step("Выбираем Hobby с помощью чекбокса")
    public void selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
    }

    @Step("Загружаем файл изображения")
    public void uploadPicture(File file) {
        $("#uploadPicture").uploadFile(file);
    }

    @Step("Заполняем поле Address")
    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Выбираем State и City из выпадающих списков")
    public void selectStateCity(String state, String city) {
        step("Кликаем на поле State", () -> $("#state").click());
        step("Выбираем State", () -> $("#stateCity-wrapper").$(byText(state)).click());
        step("Кликаем на поле City", () -> $("#city").click());
        step("Выбираем City", () -> $("#stateCity-wrapper").$(byText(city)).click());
    }

    @Step("Нажимаем на кнопку Submit")
    public void pressSubmitButton() {
        $("#submit").click();
    }

    @Step("Получаем веб-элемент таблицы с результатом")
    public SelenideElement getResultForm() {
        return $(".table-responsive tbody");
    }
}

