package registration_form_tests.tests.test_data.enums;

public enum ImageFormats {
    BMP(".bmp"),
    GIF(".gif"),
    JPEG(".jpeg"),
    PNG(".png");

    private final String fileFormat;

    ImageFormats(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String fileFormat() {
        return fileFormat;
    }
}
