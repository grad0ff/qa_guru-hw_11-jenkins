package registration_form_tests.tests.test_data.enums;

import org.jetbrains.annotations.NotNull;
import registration_form_tests.tests.test_utils.grandomizer.Capitalizer;

public enum Genders implements Capitalizer {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String gender;

    Genders(String gender) {
        this.gender = gender;
    }

    public String toString() {
        return gender;
    }

    /**
     * returns the name of enumerate constant in Capitalize case
     */
    public @NotNull String nameToCapitalize() {
        return wordToCapitalize(name());
    }


}
