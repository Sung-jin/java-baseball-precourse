package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateGameTest {

    @Test
    void 생성된_정답은_1에서_9사이의_중복되지_않은_3개의_숫자이어야_한다() {
        int answerSize = 3;
        // given

        List<Integer> answer = GenerateGame.generateAnswer();
        // when

        assertThat(answer.size()).isEqualTo(answerSize);
        for (int number: answer) {
            assertThat(number).isBetween(1, 9);
            assertThat(answer.indexOf(number)).isEqualTo(answer.lastIndexOf(number));
        }
        // then
    }
}