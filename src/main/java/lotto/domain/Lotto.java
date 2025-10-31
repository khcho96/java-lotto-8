package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersCount(numbers);
        validateLottoNumbersRange(numbers);
        validateLottoNumbersUnique(numbers);
        this.numbers = numbers.stream().toList();
    }

    private void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        long count = numbers.stream().
                filter(number -> 1 <= number && number <= 45)
                .count();
        if (count != 6) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하의 정수여야 합니다.");
        }
    }

    private void validateLottoNumbersUnique(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복이 없어야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream().toList();
    }
}
