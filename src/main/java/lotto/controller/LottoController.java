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
        Retry.retryUntilSuccess(() -> {
            int money = InputParser.parseMoney(InputView.readMoney());
            lottoService.registerMoney(money);
        });

        List<List<Integer>> issuedLottos = lottoService.issueLottos();
        OutputView.printIssuedLotto(issuedLottos);

        Retry.retryUntilSuccess(() -> {
            List<Integer> numbers = InputParser.parseWinningNumbers(InputView.readWinningNumbers());
            lottoService.registerWinningNumbers(numbers);
        });

        Retry.retryUntilSuccess(() -> {
            int bonusNumber = InputParser.parseBonusNumber(InputView.readBonusNumber());
            lottoService.registerBonusNumber(bonusNumber);
        });

        LottoResult lottoResult = lottoService.calculateResult();

    }
}

