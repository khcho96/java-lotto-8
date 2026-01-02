package lotto.controller;

import lotto.dto.IssuedLottoResult;
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
            int money = InputParser.parseNumber(InputView.readMoney());
            lottoService.registerMoney(money);
        });

        IssuedLottoResult issuedLottoResult = lottoService.issueLottos();
    }
}

