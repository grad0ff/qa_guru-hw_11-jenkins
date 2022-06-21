package registration_form_tests.tests.test_utils.grandomizer.services;

import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;
import registration_form_tests.tests.test_data.enums.ImageFormats;

import java.util.Random;

public class RandomImageFormatService {

    private static final Faker faker = new Faker();

    /**
     * Returns pseudorandom image file format
     */
    public static @NotNull ImageFormats getRandomImageFormat() {
        int randomImageFormat = new Random().nextInt(ImageFormats.values().length);
        ImageFormats imageFormat = ImageFormats.BMP;
        switch (randomImageFormat) {
            case 1:
                imageFormat = ImageFormats.JPEG;
                break;
            case 2:
                imageFormat = ImageFormats.GIF;
                break;
            case 3:
                imageFormat = ImageFormats.PNG;
                break;
        }
        return imageFormat;
    }
}

