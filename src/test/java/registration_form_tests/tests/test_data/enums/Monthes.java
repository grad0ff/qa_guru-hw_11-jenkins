package registration_form_tests.tests.test_data.enums;

import org.jetbrains.annotations.NotNull;
import registration_form_tests.tests.test_utils.grandomizer.Capitalizer;

public enum Monthes implements Capitalizer {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private final int days;

    Monthes(int days) {
        this.days = days;
    }

    public int maxDays() {
        return days;
    }

    /**
     * returns the name of enumerate constant in Capitalize case
     */
    public @NotNull String nameToCapitalize() {
        return wordToCapitalize(name());
    }
}