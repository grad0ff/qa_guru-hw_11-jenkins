package registration_form_tests.tests.test_utils.grandomizer;

import registration_form_tests.tests.TestBase;
import registration_form_tests.tests.test_data.enums.Monthes;
import registration_form_tests.tests.test_utils.grandomizer.services.RandomDateService;
import registration_form_tests.tests.test_utils.grandomizer.services.RandomGenderService;
import registration_form_tests.tests.test_utils.grandomizer.services.RandomImageFormatService;
import registration_form_tests.tests.test_utils.grandomizer.services.RandomPhoneNumberService;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Grandomizer {

    /**
     * Returns pseudorandom year
     */
    public int randomYear() {
        return RandomDateService.getRandomYear();
    }

    /**
     * Returns pseudorandom year as String
     */
    public String randomYearString() {
        return String.valueOf(RandomDateService.getRandomYear());
    }

    /**
     * Returns pseudorandom month
     */
    public String randomMonth() {
        return RandomDateService.getRandomMonth().nameToCapitalize();
    }

    /**
     * Returns ordinal number of pseudorandom month
     */
    public int randomMonthAsOrdinal() {
        return RandomDateService.getRandomMonth().ordinal();
    }

    /**
     * Returns pseudorandom day
     */
    public int randomDay() {
        return RandomDateService.getRandomDay();
    }

    /**
     * Returns pseudorandom day as String
     */
    public String randomDayString() {
        return String.valueOf(RandomDateService.getRandomDay());
    }

    /**
     * Returns pseudorandom day for pseudorandom month and pseudorandom year
     */
    public String randomDayOfRandomDate() {
        return String.valueOf(RandomDateService.getRandomDayOfDate(
                RandomDateService.getRandomYear(), RandomDateService.getRandomMonth())
        );
    }

    /**
     * Returns array of pseudorandom day, pseudorandom month and pseudorandom year
     */
    public String[] randomDayMonthYear() {
        int randomYear = RandomDateService.getRandomYear();
        String year = String.valueOf(randomYear);
        Monthes randomMonth = RandomDateService.getRandomMonth();
        String month = randomMonth.nameToCapitalize();
        int randomDay = RandomDateService.getRandomDayOfDate(randomYear, randomMonth);
        String day = String.valueOf(randomDay);
        return new String[]{day, month, year};
    }

    /**
     * Returns pseudorandom gender
     */
    public String randomGender() {
        return RandomGenderService.getRandomGender().nameToCapitalize();
    }

    /**
     * Returns pseudorandom phoneNumber
     */
    public long randomSimplePhoneNumber() {
        return RandomPhoneNumberService.getRandomPhoneNumber();
    }

    /**
     * Returns pseudorandom phoneNumber as String
     */
    public String randomPhoneNumberString() {
        return String.valueOf(RandomPhoneNumberService.getRandomPhoneNumber());
    }

    /**
     * Returns pseudorandom phoneNumber as String
     */
    public File randomImage() {
        File file = null;
        try {
            file = File.createTempFile(String.valueOf(Math.abs(new Random().nextInt())),
                    RandomImageFormatService.getRandomImageFormat().fileFormat(), TestBase.imageFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}


