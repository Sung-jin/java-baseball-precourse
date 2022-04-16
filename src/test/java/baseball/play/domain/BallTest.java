package baseball.play.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    @Test
    void 숫자야구_볼_count_테스트() {
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> enteredAnswer = Arrays.asList(3, 2, 1);
        // given

        int ballCount = Ball.count(answer, enteredAnswer);
        // when

        assertThat(ballCount).isEqualTo(2);
    }
}