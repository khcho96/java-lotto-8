package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean isDuplicated(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int getMatchCount(Lotto lotto) {
        List<Integer> matchNumbers = new ArrayList<>(this.numbers);
        matchNumbers.retainAll(lotto.numbers);
        return matchNumbers.size();
    }
}
