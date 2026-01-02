package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static int parseNumber(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateNumberFormat(rawInput);

        return NumberConvertor.convertToNumber(rawInput);
    }

    public static List<Integer> parseCsvInput(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }
}
