package lotto.util;

import static lotto.constant.ErrorMessage.INPUT_NULL_OR_BLANK_ERROR;

public class Validator {
    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_NULL_OR_BLANK_ERROR.getErrorMessage());
        }
    }
}
