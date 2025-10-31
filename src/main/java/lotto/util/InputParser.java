package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

public class InputParser {

    public static Integer parsePurchaseAmount(String rawPurchaseAmount) {
        Validator.validateNullOrBlank(rawPurchaseAmount);
        rawPurchaseAmount = rawPurchaseAmount.strip();
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
