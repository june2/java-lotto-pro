package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.Config.LOTTO_MAX_NUMBER;
import static lotto.constant.Config.LOTTO_MIN_NUMBER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest(name ="숫자가 1~45 사이의 숫자가 아닌 {0}이면 IllegalArgumentException을 발생시킨다.")
    @ValueSource(ints = {-5, 0, 46})
    void 로또_넘버_예외처리_test(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("로또 숫자는 " + LOTTO_MIN_NUMBER + "~" + LOTTO_MAX_NUMBER + " 사이어야합니다.");
    }
}
