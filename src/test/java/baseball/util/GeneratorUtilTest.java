package baseball.util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GeneratorUtilTest {

    @Nested
    class 랜덤_유니크_숫자_리스트_생성_테스트 {

        @Test
        void 요청된_크기와_범위_내의_랜덤한_숫자_생성_요청시_정상_적으로_생성되어야_한다() {
            int startNumber = -100;
            int endNumber = 100;
            int generateListSize = 10;
            // given

            List<Integer> generatedRandomNumberList = GeneratorUtil
                    .generateRandomIntegerListWithoutDuplicate(startNumber, endNumber, generateListSize);
            // when

            assertThat(generatedRandomNumberList.size()).isEqualTo(generateListSize);
            for (int number: generatedRandomNumberList) {
                assertThat(number).isBetween(startNumber, endNumber);
                assertThat(generatedRandomNumberList.indexOf(number))
                        .isEqualTo(generatedRandomNumberList.lastIndexOf(number));
            }
            // then
        }

        @Test
        void 요청한_범위의_시작값이_끝값보다_큰_경우_예외가_발생해야_한다() {
            int startNumber = 10;
            int endNumber = -10;
            int generateListSize = 10;

            assertThatThrownBy(() ->
                GeneratorUtil.generateRandomIntegerListWithoutDuplicate(startNumber, endNumber, generateListSize)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 사용_가능한_숫자들_보다_큰_사이즈의_리스트_생성_요청시_예외가_발생해야_한다() {
            int startNumber = 3;
            int endNumber = 3;
            int generateListSize = 10;

            assertThatThrownBy(() ->
                    GeneratorUtil.generateRandomIntegerListWithoutDuplicate(startNumber, endNumber, generateListSize)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
