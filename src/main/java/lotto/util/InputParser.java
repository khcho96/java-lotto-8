package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {}

    public static Integer parsePurchaseAmount(String rawPurchaseAmount) {
        Validator.validateNullOrBlank(rawPurchaseAmount);
        rawPurchaseAmount = rawPurchaseAmount.strip();

        return NumberConvertor.convertToNumber(rawPurchaseAmount);
    }

    public static List<Integer> parseWinningLottoNumber(String rawWinningLottoNumber) {
        Validator.validateNullOrBlank(rawWinningLottoNumber);
        rawWinningLottoNumber = rawWinningLottoNumber.strip();

        Validator.validateCsvFormat(rawWinningLottoNumber);

        return Stream.of(rawWinningLottoNumber.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }

    public static Integer parseBonusNumber(String rawBonusNumber) {
        Validator.validateNullOrBlank(rawBonusNumber);
        rawBonusNumber = rawBonusNumber.strip();

        return NumberConvertor.convertToNumber(rawBonusNumber);
    }
}
