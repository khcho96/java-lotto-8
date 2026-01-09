package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.util.Retry;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        registerMoney();

        List<List<Integer>> issuedLottos = lottoService.issueLottos();
        OutputView.printIssuedLotto(issuedLottos);

        registerWinningNumbers();
        registerBonusNumber();

        LottoResult lottoResult = lottoService.calculateResult();
        OutputView.printResult(lottoResult);
    }

    private void registerMoney() {
        Retry.retryUntilSuccess(() -> {
            int money = InputParser.parseMoney(InputView.readMoney());
            lottoService.registerMoney(money);
        });
    }

    private void registerWinningNumbers() {
        Retry.retryUntilSuccess(() -> {
            List<Integer> numbers = InputParser.parseWinningNumbers(InputView.readWinningNumbers());
            lottoService.registerWinningNumbers(numbers);
        });
    }

    private void registerBonusNumber() {
        Retry.retryUntilSuccess(() -> {
            int bonusNumber = InputParser.parseBonusNumber(InputView.readBonusNumber());
            lottoService.registerBonusNumber(bonusNumber);
        });
    }
}

