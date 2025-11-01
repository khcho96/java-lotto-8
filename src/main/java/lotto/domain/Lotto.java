package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;
import static lotto.constant.core.Constant.LOTTO_NUMBER_COUNT;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MAX;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MIN;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersRange(numbers);
        validateLottoNumbersUnique(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        long count = numbers.stream().
                filter(number -> LOTTO_NUMBER_MIN <= number && number <= LOTTO_NUMBER_MAX)
                .count();
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateLottoNumbersUnique(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_UNIQUE_ERROR.getErrorMessage());
        }
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }

    public Integer getMatchedCount(Lotto lotto) {
        return (int) lotto.numbers.stream()
                .filter(numbers::contains)
                .count();
    }
}
