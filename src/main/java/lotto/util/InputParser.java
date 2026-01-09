package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private InputParser() {
    }

    public static int parseMoney(String rawInput) {
        return parseNumber(rawInput);
    }

    public static List<Integer> parseWinningNumbers(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }

    public static int parseBonusNumber(String rawInput) {
        return parseNumber(rawInput);
    }

    private static int parseNumber(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateNumberFormat(rawInput);

        return NumberConvertor.convertToNumber(rawInput);
    }
}
