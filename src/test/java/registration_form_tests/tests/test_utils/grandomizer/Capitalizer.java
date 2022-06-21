package registration_form_tests.tests.test_utils.grandomizer;

import org.jetbrains.annotations.NotNull;

public interface Capitalizer {

    /**
     * Returns a received String in Capitalize case
     */
    default @NotNull String wordToCapitalize(String word) {
        word = word.toLowerCase();
        String firstAlfa = word.substring(0, 1);
        String wordEndPart = word.substring(1);
        return firstAlfa.toUpperCase().concat(wordEndPart);
    }
}