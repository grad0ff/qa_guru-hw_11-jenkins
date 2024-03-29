package registration_form_tests.tests.test_data;

import com.github.javafaker.Faker;
import registration_form_tests.tests.test_utils.grandomizer.Grandomizer;

import java.io.File;

public class TestSimpleData {

    private static final Faker faker = new Faker();
    private static final Grandomizer grandomizer = new Grandomizer();

    public static File filePhoto = grandomizer.randomImage();
    public static String[] FULL_DATE = grandomizer.randomDayMonthYear();
    public static String
            FIRST_NAME = faker.name().firstName(),
            LAST_NAME = faker.name().lastName(),
            EMAIL = faker.internet().emailAddress(),
            GENDER = grandomizer.randomGender(),
            PHONE_NUMBER = grandomizer.randomPhoneNumberString(),
            DAY = FULL_DATE[0],
            MONTH = FULL_DATE[1],
            YEAR = FULL_DATE[2],
            DATE_FOR_ASSERT = DAY + ' ' + MONTH + ',' + YEAR,
            SUBJECT = "Art",
            HOBBIES = "Sports",
            ADDRESS = faker.address().fullAddress(),
            STATE = "NCR",
            CITY = "Delhi";

}
