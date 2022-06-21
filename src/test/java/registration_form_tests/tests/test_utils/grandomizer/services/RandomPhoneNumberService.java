package registration_form_tests.tests.test_utils.grandomizer.services;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class RandomPhoneNumberService {

    /**
     * Returns pseudorandom phone number as string
     */
    public static long getRandomPhoneNumber() {
        StringBuilder phoneNumberBuilder = new StringBuilder();
        do {
            int randomDigit = new Random().nextInt(10);
            if (phoneNumberBuilder.length() == 0 && randomDigit == 0) continue;
            phoneNumberBuilder.append(randomDigit);
        }
        while (phoneNumberBuilder.length() < 10);
        return Long.parseLong(phoneNumberBuilder.toString());
    }

    /**
     * Returns pseudorandom phone number with "+" symbol as string
     */
    public static @NotNull String getRandomPhoneNumberPlus() {
        StringBuilder phoneNumberBuilder = new StringBuilder("+");
        do {
            int randomDigit = new Random().nextInt(10);
            if (phoneNumberBuilder.length() == 1 && randomDigit == 0) continue;
            phoneNumberBuilder.append(randomDigit);
        }
        while (phoneNumberBuilder.length() < 9);
        return phoneNumberBuilder.toString();
    }
}
