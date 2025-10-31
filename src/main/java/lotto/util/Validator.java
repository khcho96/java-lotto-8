package lotto.util;

import static lotto.constant.ErrorMessage.CSV_FORMAT_ERROR;
import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;

public class Validator {

    private static final String CSV_FORMAT = "^\\d+ *(, *\\d+ *)*,? *\\d+$";

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
        }
    }

    public static void validateCsvFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(CSV_FORMAT_ERROR.getErrorMessage());
        }
    }
}
