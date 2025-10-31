package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

public class InputParser {

    public static Integer parsePurchasedAmount(String rawPurchasedAmount) {
        Validator.validateNullOrBlank(rawPurchasedAmount);
        rawPurchasedAmount = rawPurchasedAmount.strip();
        try {
            return Integer.parseInt(rawPurchasedAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
