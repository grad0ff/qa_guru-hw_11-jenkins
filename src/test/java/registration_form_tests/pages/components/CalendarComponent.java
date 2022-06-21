package registration_form_tests.pages.components;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    @Step("...выбирая дату из всплывающего календаря")
    public void setDate(@NotNull String day, String month, String year) {
        if (day.length() < 2) day = "0".concat(day);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
