package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class RandomLottoNumberGenerator {

    public static List<Integer> generateLottoNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
}
