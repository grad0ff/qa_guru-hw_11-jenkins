package registration_form_tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;
import registration_form_tests.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentsRegistrationFormPage {

    public CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Заполняем поле FirstName")
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    @Step("Заполняем поле LastName")
    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @Step("Заполняем поле Email")
    public void setUserEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Выбираем р-баттон Gender")
    public void selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    @Step("Заполняем поле Phone")
    public void setPhoneNumber(String phone) {
        $("#userNumber").setValue(phone);
    }

    @Step("Заполняем поле DateOfBirth...")
    public void setDateOfBirth(String @NotNull [] date) {
        calendarComponent.setDate(date[0], date[1], date[2]); // может, лучше через мапу, но пока не изучил :(
    }

    @Step("Заполняем поле Subjects (значения скрыты с помощью JS)")
    public void selectSubjects(String subject) {
        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();
    }

    @Step("Выбираем Hobby с помощью чекбоксов")
    public void selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
    }

    @Step("Загружаем картинку")
    public void uploadPicture(File file) {
        $("#uploadPicture").uploadFile(file);
    }

    @Step("Заполняем поле Address")
    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Выбираем State и City из выпадающих списков")
    public void selectStateCity(String state, String city) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    @Step("Нажимаем кнопку Submit")
    public void pressSubmitButton() {
        $("#submit").click();
    }

    @Step("Получаем веб-элемент таблицы с результатом")
    public SelenideElement getResultForm() {
        return $(".table-responsive tbody");
    }
}

