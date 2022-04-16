package baseball.play.domain;

import baseball.functional.LoopHelper;
import baseball.util.GeneratorUtil;
import helper.UserInputHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class PlayTest {

    static MockedStatic<GeneratorUtil> util;

    @BeforeAll
    static void beforeAll() {
        util = mockStatic(GeneratorUtil.class);
    }

    @AfterAll
    static void afterAll() {
        util.close();
    }

    @Test
    void 숫자를_제외한_입력을_하면_예외가_발생해야_한다() {
        Play play = new Play();
        String input = "abc";
        // given

        UserInputHelper.mockUserInput(input);
        // when

        assertThatThrownBy(play::start).isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @Test
    void 정해진_자리의_숫자를_입력하지_않으면_예외가_발생한다() {
        Play play = new Play();
        String input = "1234";
        // given

        UserInputHelper.mockUserInput(input);
        // when

        assertThatThrownBy(play::start).isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @Test
    void 중복된_숫자를_입력하면_예외가_발생한다() {
        Play play = new Play();
        String input = "112";
        // given

        UserInputHelper.mockUserInput(input);
        // when

        assertThatThrownBy(play::start).isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @Test
    void 게임_종료_후_1_또는_2_가_아닌_입력을_하면_예외가_발생한다() {
        Play play = new Play();
        List<Integer> answer = Arrays.asList(1, 2, 3);
        String input = String.join("", LoopHelper.listMap(answer, Object::toString));
        changeGenerateRandomIntegerListWithoutDuplicate(answer);
        // given

        UserInputHelper.mockUserInput(input + "\n" + 3);
        // when

        assertThatThrownBy(play::start).isInstanceOf(IllegalArgumentException.class);
        // then
    }

    private void changeGenerateRandomIntegerListWithoutDuplicate (List<Integer> value) {
        given(GeneratorUtil.generateRandomIntegerListWithoutDuplicate(anyInt(), anyInt(), anyInt()))
            .willReturn(value);
    }
}