package lotto.generator;

import static lotto.constant.core.Constant.LOTTO_NUMBER_COUNT;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MAX;
import static lotto.constant.core.Constant.LOTTO_NUMBER_MIN;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT);
    }
}
