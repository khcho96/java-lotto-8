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
        IssuedLottosDto issuedLottosDto = issueLottos();
        Printer.printIssuedLottos(issuedLottosDto);

        registerWinningLottoNumber();
        registerBonusNumber();

        LottoResultDto lottoResultDto = getLottoResult();
        Printer.printLottoResult(lottoResultDto);
    }

    private IssuedLottosDto issueLottos() {
        while (true) {
            try {
                Printer.printPurchaseAmountRequest();
                String rawPurchaseAmount = Reader.readInput();

                Integer purchaseAmount = InputParser.parsePurchaseAmount(rawPurchaseAmount);

                return lottoService.issueLottos(purchaseAmount);
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e);
            }
        }
    }

    private void registerWinningLottoNumber() {
        while (true) {
            try {
                Printer.printWinningLottoRequest();
                String rawWinningLottoNumber = Reader.readInput();

                List<Integer> winningLottoNumber = InputParser.parseWinningLottoNumber(rawWinningLottoNumber);

                lottoService.registerWinningLottoNumber(winningLottoNumber);

                return;
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e);
            }
        }
    }

    private void registerBonusNumber() {
        while (true) {
            try {
                Printer.printBonusNumberRequest();
                String rawBonusNumber = Reader.readInput();

                Integer bonusNumber = InputParser.parseBonusNumber(rawBonusNumber);

                lottoService.registerBonusNumber(bonusNumber);

                return;
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e);
            }
        }
    }

    private LottoResultDto getLottoResult() {
        while (true) {
            try {
                return lottoService.getLottoResult();
            } catch (IllegalArgumentException e) {
                Printer.printErrorMessage(e);
            }
        }
    }
}
