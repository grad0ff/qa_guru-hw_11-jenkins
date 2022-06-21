package registration_form_tests.tests.test_utils.grandomizer.services;

import org.jetbrains.annotations.NotNull;
import registration_form_tests.tests.test_data.enums.Monthes;

import java.time.LocalDate;
import java.util.Random;

public class RandomDateService {

    /**
     * Returns pseudorandom year in the range from 1900 to the current year
     */
    public static int getRandomYear() {
        int currentYear = LocalDate.now().getYear();
        int rangeOfYears = currentYear - 1900;
        int randomYearOffset = new Random().nextInt(rangeOfYears);
        return 1900 + randomYearOffset;
    }

    /**
     * Returns pseudorandom month of year
     */
    public static Monthes getRandomMonth() {
        Monthes month = Monthes.JANUARY;
        int randomMonthNumber = new Random().nextInt(12) + 1;
        switch (randomMonthNumber) {
            case 2:
                month = Monthes.FEBRUARY;
                break;
            case 3:
                month = Monthes.MARCH;
                break;
            case 4:
                month = Monthes.APRIL;
                break;
            case 5:
                month = Monthes.MAY;
                break;
            case 6:
                month = Monthes.JUNE;
                break;
            case 7:
                month = Monthes.JULY;
                break;
            case 8:
                month = Monthes.AUGUST;
                break;
            case 9:
                month = Monthes.SEPTEMBER;
                break;
            case 10:
                month = Monthes.OCTOBER;
                break;
            case 11:
                month = Monthes.NOVEMBER;
                break;
            case 12:
                month = Monthes.DECEMBER;
                break;
        }
        return month;
    }

    /**
     * Returns pseudorandom day of month in the range 1 to 31 day
     */
    public static int getRandomDay() {
        return new Random().nextInt(32);
    }

    /**
     * Returns pseudorandom day for specific year and month
     */
    public static int getRandomDayOfDate(int year, @NotNull Monthes month) {
        int maxDays = month.maxDays();
        if ((year % 100 == 0 || year % 4 == 0) && month == Monthes.FEBRUARY) {
            ++maxDays;
        }
        return new Random().nextInt(maxDays) + 1;
    }
}

