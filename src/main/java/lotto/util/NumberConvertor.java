package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

public final class NumberConvertor {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
