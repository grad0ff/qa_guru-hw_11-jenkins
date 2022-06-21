package registration_form_tests.tests.test_data;

import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.provider.Arguments;
import registration_form_tests.tests.test_utils.grandomizer.Grandomizer;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class PositiveTestDataProvider {

    private static final Faker faker = new Faker();
    private static final Grandomizer grandomizer = new Grandomizer();

    public static @NotNull Stream<String> firstNameData() {
        return Arrays.stream(new String[10]).map((String s) -> faker.name().firstName());
    }

    public static @NotNull Stream<String> lastNameData() {
        return Arrays.stream(new String[10]).map((String s) -> faker.name().lastName());
    }

    public static Stream<String> emailAddressData() {
        return Arrays.stream(new String[10]).map((String s) -> faker.internet().emailAddress());
    }

    public static Stream<String> phoneNumberData() {
        return Arrays.stream(new String[10]).map((String s) -> grandomizer.randomPhoneNumberString());
    }

    public static Stream<Arguments> dateOfBirthData() {
        return Stream.of(new String[10][3]).map((String[] s) -> Arguments.of((Object) grandomizer.randomDayMonthYear()));
    }

    public static Stream<Arguments> imageFileData() {
        return Stream.of(new File[10]).map((File f) -> (Arguments.of(grandomizer.randomImage())));
    }

    public static Stream<String> addressData() {
        return Arrays.stream(new String[10]).map((String s) -> faker.address().fullAddress());
    }

}