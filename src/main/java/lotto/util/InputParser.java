package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {}

    public static Integer parsePurchaseAmount(String rawPurchaseAmount) {
        Validator.validateNullOrBlank(rawPurchaseAmount);
        rawPurchaseAmount = rawPurchaseAmount.strip();
        return convertToNumber(rawPurchaseAmount);
    }

    public static List<Integer> parseWinningLottoNumber(String rawWinningLottoNumber) {
        Validator.validateNullOrBlank(rawWinningLottoNumber);
        rawWinningLottoNumber = rawWinningLottoNumber.strip();
        Validator.validateCsvFormat(rawWinningLottoNumber);
        return Stream.of(rawWinningLottoNumber.split(DELIMITER))
                .map(String::strip)
                .map(Integer::parseInt)
                .toList();
    }

    public static Integer parseBonusNumber(String rawBonusNumber) {
        Validator.validateNullOrBlank(rawBonusNumber);
        rawBonusNumber = rawBonusNumber.strip();
        return convertToNumber(rawBonusNumber);
    }

    private static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
