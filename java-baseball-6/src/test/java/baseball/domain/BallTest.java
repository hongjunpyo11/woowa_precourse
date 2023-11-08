package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class BallTest {

    @DisplayName("Ball 생성")
    @Nested()
    class CreateBall {
        @DisplayName("1 ~ 9 사이의 숫자를 입력하면 예외가 발생하지 않는다.")
        @ParameterizedTest
        @ValueSource(ints = {3, 9})
        void NoExceptionIfValidNumber(int validNumber) {
            assertThatNoException()
                    .isThrownBy(() -> new Ball(validNumber));
        }

        @DisplayName("1 ~ 9 사이의 숫자 외의 숫자를 입력하면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(ints = {-6, 0, 12})
        void ThrowExceptionIfInvalidNumber(int invalidNumber) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Ball(invalidNumber));
        }
    }
}
