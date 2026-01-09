package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public final class RandomLottoNumberGenerator {

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}
