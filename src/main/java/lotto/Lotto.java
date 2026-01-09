package lotto;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > 45 || number < 1)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
