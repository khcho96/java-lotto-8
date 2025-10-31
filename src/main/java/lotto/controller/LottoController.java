package lotto.controller;

import java.util.List;
import lotto.dto.IssuedLottosDto;
import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.Printer;
import lotto.view.Reader;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        while (true) {
            try {
                IssuedLottosDto issuedLottosDto = issueLottos();
                Printer.printIssuedLottos(issuedLottosDto);

                registerWinningLottoNumber();

                LottoResultDto lottoResultDto = getLottoResult();
                Printer.printLottoResult(lottoResultDto);

                return;
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e);
            }
        }
    }

    private IssuedLottosDto issueLottos() {
        Printer.printPurchasedAmountRequest();
        String rawPurchasedAmount = Reader.readInput();

        Integer purchasedAmount = InputParser.parsePurchasedAmount(rawPurchasedAmount);

        IssuedLottosDto issuedLottosDto = lottoService.issueLottos(purchasedAmount);

        return issuedLottosDto;
    }

    private void registerWinningLottoNumber() {

        Printer.printWinningLottoRequest();
        String rawWinningLottoNumber = Reader.readInput();

        List<String> winningLottoNumber = InputParser.parseWinningLottoNumber(rawWinningLottoNumber);

        lottoService.registerWinningLottoNumber(winningLottoNumber);
    }


    private LottoResultDto getLottoResult() {
        Printer.printBonusNumberRequest();
        String rawBonusNumber = Reader.readInput();

        Integer bonusNumber = InputParser.parseBonusNumber(rawBonusNumber);

        lottoService.registerBonusNumber(bonusNumber);
        LottoResultDto lottoResultDto = lottoService.getLottoResult();

        return lottoResultDto;
    }
}