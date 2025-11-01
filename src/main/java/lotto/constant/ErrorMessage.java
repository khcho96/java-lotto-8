package lotto.constant;

public enum ErrorMessage {

    INPUT_NULL_OR_BLANK_ERROR("입력값이 null 또는 빈 문자열입니다."),
    NUMBER_FORMAT_ERROR("숫자 형태만 입력 가능합니다."),
    CSV_FORMAT_ERROR("쉼표(,)를 기준으로 구분되는 6개의 정수 입력이어야 합니다. 예) 1,2,3,4,5,6"),

    PURCHASE_AMOUNT_RANGE_ERROR("구입 금액은 0원 초과 100,000원 이하여야 합니다."),
    PURCHASE_AMOUNT_UNIT_ERROR("구입 금액은 1000원 단위여야 합니다."),

    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1 이상 45 이하의 정수여야 합니다."),
    LOTTO_NUMBER_UNIQUE_ERROR("로또 번호는 중복이 없어야 합니다."),

    BONUS_NUMBER_UNIQUE_ERROR("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
