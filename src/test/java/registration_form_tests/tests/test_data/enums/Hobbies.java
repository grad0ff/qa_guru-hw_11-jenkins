package registration_form_tests.tests.test_data.enums;

import org.jetbrains.annotations.NotNull;
import registration_form_tests.tests.test_utils.grandomizer.Capitalizer;

public enum Hobbies implements Capitalizer {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String hobby;

    Hobbies(String hobby) {
        this.hobby = hobby;
    }

    public String hobby() {
        return hobby;
    }

    /**
     * returns the name of enumerate constant in Capitalize case
     */
    public @NotNull String nameToCapitalize() {
        return wordToCapitalize(name());
    }
}

