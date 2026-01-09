package lotto.util;

import lotto.constant.ErrorMessage;

public final class Validator {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String NUMBER_CSV_FORMAT = "^\\d+ *(, *\\d+ *)*$";

    private Validator() {}

    public static void validateNumberFormat(String input) {
        if (!input.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateCsvFormat(String input) {
        if (!input.matches(NUMBER_CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
