package lotto.util;

import static lotto.constant.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    private static final String DELIMITER = ",";

    public static Integer parsePurchaseAmount(String rawPurchaseAmount) {
        Validator.validateNullOrBlank(rawPurchaseAmount);
        rawPurchaseAmount = rawPurchaseAmount.strip();
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
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
        try {
            return Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
