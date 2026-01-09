package lotto.controller;

import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.util.Retry;
import lotto.view.InputView;

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

    }
}

