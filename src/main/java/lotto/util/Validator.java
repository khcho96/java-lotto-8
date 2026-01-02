package lotto.util;

import lotto.constant.ErrorMessage;

public final class Validator {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String CSV_FORMAT = "^\\d+ *(, *\\d+ *)*$";

    private Validator() {}

    public static void validateCsvFormat(String rawInput) {
        if (!rawInput.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateNumberFormat(String rawInput) {
        if (!rawInput.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
