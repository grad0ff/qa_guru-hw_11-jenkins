package registration_form_tests.tests.test_utils.grandomizer.services;

import registration_form_tests.tests.test_data.enums.Genders;

import java.util.Random;

public class RandomGenderService {

    /**
     * Returns pseudorandom gender
     */
    public static Genders getRandomGender() {
        int randomGender = new Random().nextInt(Genders.values().length);
        Genders gender = Genders.MALE;
        switch (randomGender) {
            case 1:
                gender = Genders.FEMALE;
                break;
            case 2:
                gender = Genders.OTHER;
                break;
        }
        return gender;
    }
}
