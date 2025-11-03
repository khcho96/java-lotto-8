# 🎯 프리코스 3주차 과제 - 로또

> 내용이 추가 또는 수정될 수 있다.

## 🚀 기능 구현 목록
> - 기능 작동 순서대로 작성한다.
>
> - 스스로 판단한 내용은 (`판단`) 이라고 표시한다.
    >   - 판단한 내용에 대한 이유를 설명한다.
>
> - 기능을 구현했다면 해당 기능 목록에 체크한다.

### 1. 사용자로부터 구입 금액을 입력받는다.
- [x] 사용자에게 구입 금액 입력 메시지를 출력한다.
- [x] 사용자로부터 구입 금액을 입력받는다.

### 2. 구입 금액에 대한 입력값을 검증하고 정수로 변환한다.
- [x] 입력값이 null 또는 빈 문자열(공백만 존재하는 경우 포함)이면 에외를 발생시키고 다시 입력을 받는다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값이 숫자(정수) 형태가 아니면 예외를 발생시키고 다시 입력을 받는다.
- [x] 입력값을 정수로 변환한다.

### 3. 정수로 변환한 구입 금액을 검증하고 발행 가능한 로또의 개수를 계산한다.
- [x] 구입 금액이 0원 초과 및 100,000원 이하가 아니면 에외를 발생시키고 다시 입력을 받는다. (`판단`: 실제 1인당 1회 최대 구매 금액 100,000원)
- [x] 구입 금액이 1000원 단위가 아니면 에외를 발생시키고 다시 입력을 받는다.
- [x] 구입 금액에 알맞은 발행 가능한 로또의 개수를 계산한다.

### 4. 개수에 맞는 로또를 발행 후 검증한다.
- [x] 개수에 맞는 로또를 발행한다.
- [x] 발행한 로또를 검증한다.
  - [x] 로또 번호가 6개가 아니면 예외를 발생시키고 다시 입력을 받는다.
  - [x] 로또 번호가 1 이상 45 이하의 정수가 아니면 예외를 발생시키고 다시 입력을 받는다.
  - [x] 로또 번호에 중복이 있으면 예외를 발생시키고 다시 입력을 받는다.
- [x] 발행된 로또의 리스트를 반환한다.

### 5. 발행한 로또를 출력한다.
- [x] 로또를 오름차순으로 출력한다.

### 6. 사용자로부터 당첨 번호를 입력받는다.
- [x] 사용자에게 당첨 번호 입력 메시지를 출력한다.
- [x] 사용자로부터 당첨 번호를 입력받는다.

### 7. 당첨 번호에 대한 입력값을 검증하고 쉼표로 분리한다.
- [x] 입력값이 null 또는 빈 문자열(공백만 존재하는 경우 포함)이면 에외를 발생시키고 다시 입력을 받는다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] `정수,정수,...,정수` 형태가 아니면  에외를 발생시키고 다시 입력을 받는다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값을 쉼표로 분리하고 각 값의 양쪽 공백을 제거한다.
- [x] 당첨 번호를 반환한다.

### 8. 당첨 번호를 검증한다.
- [x] 당첨 번호가 6개가 아니면 예외를 발생시키고 다시 입력을 받는다.
- [x] 각 번호가 1 이상 45 이하의 정수가 아니면 예외를 발생시키고 다시 입력을 받는다.
- [x] 당첨 번호에 중복이 있으면 예외를 발생시키고 다시 입력을 받는다.

### 9. 사용자로부터 보너스 번호를 입력받는다.
- [x] 사용자에게 보너스 번호 입력 메시지를 출력한다.
- [x] 사용자로부터 보너스 번호를 입력받는다.

### 10. 보너스 번호에 대한 입력값을 검증하고 정수로 변환한다.
- [x] 입력값이 null 또는 빈 문자열(공백만 존재하는 경우 포함)이면 에외를 발생시키고 다시 입력을 받는다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값이 숫자(정수) 형태가 아니면 예외를 발생시키고 다시 입력을 받는다.
- [x] 입력값을 정수로 변환한다.

### 11. 정수로 변환한 보너스 번호를 검증한다.
- [x] 보너스 번호가 1 이상 45 이하의 정수가 아니면 예외를 발생시키고 다시 입력을 받는다.
- [x] 보너스 번호가 당첨 번호와 중복이 되면 예외를 발생시키고 다시 입력을 받는다.

### 12. 당첨 통계를 계산한다.
- [x] 발행한 각 로또 번호의 등수를 판단한다.
- [x] 수익률을 계산한다.
- [x] 당첨 통계를 반환한다.

### 13. 당첨 통계를 출력한다.
- [x] 각 등수의 당첨 개수를 출력한다.
- [x] 수익률을 출력한다.

## 🔍 테스트 코드 구현 목록
> 테스트가 정상적으로 통과하면 해당 테스트 목록에 체크한다.

### 1. ApplicationTest
#### 정상 입력
- [x] 구입 금액 테스트
  - [x] 기본 케이스
  - [x] 양쪽 공백 케이스
- [x] 당첨 번호 테스트
  - [x] 기본 케이스
  - [x] 양쪽 공백 케이스
  - [x] 사이 공백 케이스
- [x] 보너스 번호 테스트
  - [x] 기본 케이스
  - [x] 양쪽 공백 케이스

#### 예외 발생
- [x] 구입 금액 케이스
  - [x] 빈 문자열이면 예외 발생
  - [x] 숫자가 아닌 형식이면 예외 발생
  - [x] 0 초과 100,000 이하가 아니면 예외 발생
  - [x] 1000원 단위가 아니면 예외 발생
- [x] 당첨 번호 케이스
  - [x] 빈 문자열이면 예외 발생
  - [x] 쉼표로 구분되는 정수 형식이 아니면 예외 발생
  - [x] 쉼표로 분리한 숫자가 6개가 아니면 예외 발생
  - [x] 각 숫자가 1 이상 45 이하가 아니면 예외 발생
  - [x] 6개의 숫자 중 중복이 있으면 에외 발생
- [x] 보너스 번호 케이스
  - [x] 빈 문자열이면 예외 발생
  - [x] 숫자가 아닌 형식이면 예외 발생
  - [x] 1 이상 45 이하가 아니면 예외 발생
  - [x] 당첨 번호와 중복이면 에외 발생

### 2. domain.IssuedLottosTest
- [x] 여러개의 로또를 정상적으로 발행하는지 테스트 

### 3. domain.LottoMachineTest
- [x] 여러개의 로또를 정상적으로 발행하는지 테스트

### 4. domain.LottoTest
- [x] 로또 번호의 개수가 6개가 아니면 예외 발생
- [x] 로또 번호의 범위가 알맞지 않으면 예외 발생
- [x] 로또 번호에 중복된 숫자가 있으면 예외가 발생
- [x] 로또 번호를 정상적으로 발행하는지 테스트
- [x] 로또 번호가 중복일 때 중복임을 정상적으로 확인하는지 테스트
- [x] 두 개의 로또 번호끼리 서로 일치하는 숫자의 개수를 정상적으로 반환하는지 테스트

### 5. domain.PurchaseAmountTest
- [x] 구매 금액 입력값이 알맞은 범위가 아니면 예외 발생
- [x] 구매 금액 입력값이 1000원 단위가 아니면 예외 발생
- [x] 구매 금액에 알맞는 발행할 로또의 개수를 정상적으로 반환하는지 테스트
- [x] 수익을 가지고 수익률을 정상적으로 계산하여 반환하는지 테스트

### 6. domain.WinningLottoTest
- [x] 당첨 번호의 개수가 6개가 아니면 예외 발생
- [x] 당첨 번호의 범위가 알맞지 않으면 예외 발생
- [x] 당첨 번호에 중복된 숫자가 있으면 예외 발생
- [x] 보너스 번호의 범위가 알맞지 않으면 예외 발생
- [x] 보너스 번호가 당첨 번호와 중복이면 예외 발생
- [x] 발행된 로또 번호와 비교하여 해당 로또의 등수를 정상적으로 반환하는지 테스트

### 7. util.InputParserTest
- [x] 구입 금액 입력값이 null 또는 빈 문자열이면 예외 발생
- [x] 구입 금액 입력값이 숫자 형식이 아니면 예외 발생
- [x] 구입 금액 입력값을 정상적으로 정수로 변환하는지 테스트
- [x] 당첨 번호 입력값이 null 또는 빈 문자열이면 예외 발생
- [x] 당첨 번호 입력값이 쉼표로 구분된 정수 형식이 아니면 예외 발생
- [x] 당첨 번호 입력값을 정상적으로 쉼표로 분리해 정수 리스트를 반환하는지 테스트
- [x] 보너스 번호 입력값이 null 또는 빈 문자열이면 예외 발생
- [x] 보너스 번호 입력값이 숫자 형식이 아니면 예외 발생
- [x] 보너스 번호 입력값을 정상적으로 정수로 변환하는지 테스트

### 8. util.ValidatorTest
- [x] 입력값이 null 또는 빈 문자열이면 예외 발생
- [x] 입력값이 쉼표로 구분된 정수 형식이 아니면 예외 발생

## ✅ 요구 사항 체크
### 과제 진행 요구 사항
- [x] 미션은 로또 저장소를 포크하고 클론하는 것으로 시작한다.
- [x] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  - [x] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- [x] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

### 기능 요구 사항
간단한 로또 발매기를 구현한다.
- [x] 로또 번호의 숫자 범위는 1~45까지이다.
- [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- [x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - [x] 1등: 6개 번호 일치 / 2,000,000,000원
  - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - [x] 3등: 5개 번호 일치 / 1,500,000원
  - [x] 4등: 4개 번호 일치 / 50,000원
  - [x] 5등: 3개 번호 일치 / 5,000원
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- [x] 로또 1장의 가격은 1,000원이다.
- [x] 당첨 번호와 보너스 번호를 입력받는다.
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

#### 입출력 요구 사항
##### 입력
- [x] 로또 구입 금액을 입력 받는다. 
  - [x] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [x] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- [x] 보너스 번호를 입력 받는다.

##### 출력
- [x] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [x] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

### 프로그래밍 요구 사항 1
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 Application의 main()이다.
- [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - [x] 기본적으로 Java Style Guide를 원칙으로 한다.

### 프로그래밍 요구 사항 2
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - [x] 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - [x] 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 프로그래밍 요구 사항 3
- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - [x] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x] else 예약어를 쓰지 않는다.
  - [x] else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- [x] Java Enum을 적용하여 프로그램을 구현한다.
- [x] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - [x] 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

#### 라이브러리
- [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - [x] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 📝 구현 코드 명세
| Class                               | Field&Method                                                 | Role(Responsibility)              |
|-------------------------------------|--------------------------------------------------------------|-----------------------------------|
| constant.core.Constant              | PURCHASE_AMOUNT_MIN, PURCHASE_AMOUNT_MAX 등                   | 비즈니스 로직에 필요한 상수로 관리               |
| constant.core.Rank(Enum)            | FIRST, SECOND, THIRD, FOURTH, FIFTH                          | 각 등수를 의미하는 Enum 객체                |
|                                     | private final Long prize                                     | 등수별 부여된 상금                        |
|                                     | private final String printedContents                         | 등수별 결과 출력을 위한 문자열                 |
| constant.ErrorMessage(Enum)         | INPUT_NULL_OR_BLANK_ERROR, NUMBER_FORMAT_ERROR 등             | 에러 메시지를 담은 Enum 객체                |
|                                     | private static final String ERROR_MESSAGE_PREFIX             | “[ERROR]" 문자열                     |
|                                     | private final String errorMessage                            | 에러 메시지                            |
| controller.LottoController          | private final LottoService lottoService                      | 의존성 주입으로 서비스 객체를 할당받아 컨트롤하기 위한 변수 |
|                                     | public void run()                                            | 컨트롤러를 시작                          |
|                                     | private IssuedLottosDto issueLottos()                        | 구입 금액을 입력 받아 로또를 발행               |
|                                     | private void registerWinningLottoNumber()                    | 당첨 번호를 입력 받아 등록                   |
|                                     | private void registerBonusNumber()                           | 보너스 번호를 입력 받아 등록                  |
|                                     | private LottoResultDto getLottoResult()                      | 당첨 통계를 계산하여 반환                    |
| domain.IssuedLottos                 | private final List<Lotto> lottos                             | 발행한 로또 리스트                        |
|                                     | public static IssuedLottos getInstance()                     | 정적 팩토리 메서드                        |
|                                     | public void add(List<Integer> lottoNumbers)                  | 발행한 로또를 리스트에 추가                   |
|                                     | public IssuedLottosDto getIssuedLottos()                     | 발행한 로또의 결과를 DTO로 변환하여 반환          |
|                                     | public Iterator<Lotto> getIssuedLottosViewer()               | 리스트 순회를 위한 Iterator 반환            |
| domain.Lotto                        | private final List<Integer> numbers                          | 로또 번호 리스트                         |
|                                     | public static Lotto from(List<Integer> numbers)              | 정적 팩토리 메서드                        |
|                                     | private void validateLottoNumbersCount(List<Integer> numbers) | 로또 번호 개수 검증                       |
|                                     | private void validateLottoNumbersRange(List<Integer> numbers) | 로또 번호 범위 검증                       |
|                                     | private void validateLottoNumbersUnique(List<Integer> numbers) | 로또 번호 중복 검증                       |
|                                     | public boolean contains(Integer number)                      | 로또 번호 리스트에 이미 있는 값인지 확인           |
|                                     | public Integer getMatchedCount(Lotto lotto)                  | 로또 번호와 일치하는 숫자의 개수 반환             |
| domain.LottoMachine                 | private final Integer lottoCount                             | 발행할 로또 개수                         |
|                                     | public static LottoMachine from(Integer purchaseAmount)      | 정적 팩토리 메서드                        |
|                                     | public IssuedLottos generateLottos(LottoGenerator lottoGenerator) | 알맞은 개수만큼 로또를 발행                   |
| domain.LottoResult                  | private final Map<Rank, Integer> lottoResult                 | 등수별 당첨 개수를 저장하는 맵                 |
|                                     | private Double profitRate                                    | 수익률                               |
|                                     | public static LottoResult getInstance()                      | 정적 팩토리 메서드                        |
|                                     | public LottoResultDto getLottoResult(WinningLotto winningLotto, IssuedLottos issuedLottos, PurchaseAmount purchaseAmount) | 당첨 통계 계산하여 반환                     |
|                                     | private void calculateLottoResult(WinningLotto winningLotto, IssuedLottos issuedLottos) | 등수별 당첨 개수 계산                      |
|                                     | private void calculateProfitRate(PurchaseAmount purchaseAmount) | 수익률 계산                            |
| domain.PurchaseAmount               | private final Integer purchaseAmount                         | 구입 금액                             |
|                                     | public static PurchaseAmount from(Integer purchaseAmount)    | 정적 팩토리 메서드                        |
|                                     | private void validateRange(Integer purchaseAmount)           | 구입 금액 범위 검증                       |
|                                     | private void validateUnit(Integer purchaseAmount)            | 구입 금액 단위 검증                       |
|                                     | public Integer getLottoCount()                               | 금액에 알맞은 발행할 로또의 개수 계산             |
|                                     | public Double getProfitRate(Long profit)                     | 수익률 계산                            |
| domain.WinningLotto                 | private final Lotto winningLotto                             | 당첨 로또                             |
|                                     | private Integer bonusNumber                                  | 보너스 번호                            |
|                                     | public static WinningLotto from(List<Integer> winningLottoNumber) | 정적 팩토리 메서드                        |
|                                     | public void registerBonusNumber(Integer bonusNumber)         | 보너스 번호 등록                         |
|                                     | private void validateBonusNumberRange(Integer bonusNumber)   | 보너스 번호 범위 검증                      |
|                                     | private void validateBonusNumberUnique(Integer bonusNumber)  | 보너스 번호 중복 검증                      |
|                                     | public Rank determineRank(Lotto issuedLotto)                 | 등수 결정                             |
| dto.IssuedLottosDto(Record)         | List<List<Integer>> issuedLottos                             | 발행한 로또 번호                         |
|                                     | List<List<Integer>> issuedLottos()                           | 발행한 로또 번호 반환                      |
| dto.LottoResultDto(Record)          | Map<Rank, Integer> lottoResult                               | 등수별 당첨 개수                         |
|                                     | Double profitRate                                            | 수익률                               |
|                                     | public Map<Rank, Integer> lottoResult()                      | 등수별 당첨 개수 반환                      |
|                                     | public Double profitRate()                                   | 수익률 반환                            |
| generator.LottoGenerator(Interface) | List<Integer> generateLottoNumbers()                         | 6개의 로또 번호 생성(추상 메서드)              |
| generator.FixedLottoGenerator       | private final List<List<Integer>> lottoNumbers               | 고정된 로또 번호 리스트                     |
|                                     | public FixedLottoGenerator(List<List<Integer>> lottoNumbers) | 생성자 의존성 주입으로 고정된 로또 번호 리스트 저장     |
|                                     | public List<Integer> generateLottoNumbers()                  | 고정된 로또 번호 반환                      |
| generator.RandomLottoGenerator      | public List<Integer> generateLottoNumbers()                  | 랜덤 로또 번호 반환                       |
| service.LottoService                | private WinningLotto winningLotto                            | 당첨 로또                             |
|                                     | private IssuedLottos issuedLottos                            | 발행한 로또                            |
|                                     | private PurchaseAmount purchaseAmount                        | 구입 금액                             |
|                                     | public void registerWinningLottoNumber(List<Integer> winningLottoNumber) | 당첨 번호 등록                          |
|                                     | public void registerBonusNumber(Integer bonusNumber)         | 보너스 번호 등록                         |
|                                     | public LottoResultDto getLottoResult()                       | 당첨 통계 반환                          |
| util.InputParser                    | DELIMITER                                                    | 쉼표 구분자 상수                         |
|                                     | public static Integer parsePurchaseAmount(String rawPurchaseAmount) | 구입 금액 입력값 검증 및 정수 변환              |
|                                     | public static List<Integer> parseWinningLottoNumber(String rawWinningLottoNumber) | 당첨 번호 입력값 검증 및 쉼표로 분리 및 정수 변환     |
|                                     | public static Integer parseBonusNumber(String rawBonusNumber) | 보너스 번호 입력값 검증 및 정수 변환             |
|                                     | private static Integer convertToNumber(String input)         | 문자열 정수 변환                         |
| util.Validator                      | CSV_FORMAT                                                   | 쉼표 구분 입력 패턴                       |
|                                     | public static void validateNullOrBlank(String input)         | null 또는 빈 문자열 검증                  |
|                                     | public static void validateCsvFormat(String input)           | 쉼표 구분 입력 형식 검증                    |
| view.Printer                        | NEW_LINE, PURCHASE_AMOUNT_REQUEST 등                          | 출력 메시지 상수                         |
|                                     | public static void printPurchaseAmountRequest()              | 구입 금액 입력 메시지                      |
|                                     | public static void printWinningLottoRequest()                | 당첨 번호 입력 메시지                      |
|                                     | public static void printBonusNumberRequest()                 | 보너스 번호 입력 메시지                     |
|                                     | public static void printIssuedLottos(IssuedLottosDto issuedLottosDto) | 발행한 로또 번호 출력                      |
|                                     | public static void printLottoResult(LottoResultDto lottoResultDto) | 당첨 통계 출력                          |
|                                     | public static void printErrorMessage(IllegalArgumentException e) | 에러메시지 출력                          |
| view.Reader                         | public static String readInput()                             | 사용자 입력값 받아서 반환                    |