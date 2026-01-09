package lotto.constant;

public enum ErrorMessage {

    FORMAT_ERROR("잘못된 형식입니다."),
    MONEY_UNIT_ERROR("1000원 단위로 입력해야 합니다."),
    DUPLICATION_ERROR("번호가 중복입니다."),
    RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    COUNT_ERROR("로또 번호는 6개여야 합니다."),
    BONUS_DUPLICATION_ERROR("보너스 번호가 당첨 번호와 중복입니다.")
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
