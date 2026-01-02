package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.dto.IssuedLottoResult;
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
        IssuedLottoResult issuedLottoResult = Retry.retryUntilSuccess(() -> {
            int money = InputParser.parseNumber(InputView.readMoney());
            lottoService.registerMoney(money);
            return lottoService.issueLottos();
        });

        OutputView.printIssuedLottos(issuedLottoResult);

        Retry.retryUntilSuccess(() -> {
            List<Integer> winningNumbers = InputParser.parseCsvInput(InputView.readWinningNumbers());
            lottoService.registerWinningLotto(winningNumbers);
        });

        Retry.retryUntilSuccess(() -> {
            int bonusNumber = InputParser.parseNumber(InputView.readBonusNumber());
            lottoService.registerBonusNumber(bonusNumber);
        });

        LottoResult result = lottoService.calculateResult();
        OutputView.printResult(result);
    }
}

