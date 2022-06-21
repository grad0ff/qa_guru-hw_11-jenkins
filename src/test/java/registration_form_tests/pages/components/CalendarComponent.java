package registration_form_tests.pages.components;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CalendarComponent {

    @Step("Выбираем дату из всплывающего календаря")
    public void setDate(@NotNull String day, String month, String year) {
        if (day.length() < 2) day = "0".concat(day);
        step("Кликаем на поле ввода даты", () -> $("#dateOfBirthInput").click());
        step("Выставляем месяц", () -> $(".react-datepicker__month-select").selectOption(month));
        step("Выставляем год", () -> $(".react-datepicker__year-select").selectOption(year));
        @NotNull String finalDay = day;
        step("Выставляем день", () -> $(".react-datepicker__day--0" + finalDay +
                ":not(.react-datepicker__day--outside-month)").click());
    }
}
