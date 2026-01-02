package lotto.controller;

import java.util.List;
import lotto.dto.LottoResult;
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
        IssuedLottoResult issuedLottoResult = registerMoney();
        OutputView.printIssuedLottos(issuedLottoResult);

        registerWinningLotto();

        registerBonusNumber();

        LottoResult result = lottoService.calculateResult();
        OutputView.printResult(result);
    }

    private void registerBonusNumber() {
        Retry.retryUntilSuccess(() -> {
            int bonusNumber = InputParser.parseNumber(InputView.readBonusNumber());
            lottoService.registerBonusNumber(bonusNumber);
        });
    }

    private void registerWinningLotto() {
        Retry.retryUntilSuccess(() -> {
            List<Integer> winningNumbers = InputParser.parseCsvInput(InputView.readWinningNumbers());
            lottoService.registerWinningLotto(winningNumbers);
        });
    }

    private IssuedLottoResult registerMoney() {
        return Retry.retryUntilSuccess(() -> {
            int money = InputParser.parseNumber(InputView.readMoney());
            lottoService.registerMoney(money);
            return lottoService.issueLottos();
        });
    }
}

