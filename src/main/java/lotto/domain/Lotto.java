package lotto.domain;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.constant.ErrorMessage.LOTTO_NUMBER_UNIQUE_ERROR;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersRange(numbers);
        validateLottoNumbersUnique(numbers);
        numbers.sort(null);
        this.numbers = numbers.stream().toList();
    }
    
    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        long count = numbers.stream().
                filter(number -> 1 <= number && number <= 45)
                .count();
        if (count != 6) {
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
