package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckerUtilTest {

    @Test
    void 문자열에_숫자를_제외한_값이_존재하는지_체크_기능_테스트() {
        String onlyNumberString = "1234567890";
        String stringStartWithNumberString = "!@#abc123456789";
        String stringEndWithNumberString = "123456789abc!@#";
        String mixStringAndNumberString = "a!123b@456c#789";
        // given

        Boolean onlyNumberValidateResult = CheckerUtil.hasExcludeNumberInString(onlyNumberString);
        Boolean stringStartWithNumberValidateResult = CheckerUtil.hasExcludeNumberInString(stringStartWithNumberString);
        Boolean stringEndWithNumberValidateResult = CheckerUtil.hasExcludeNumberInString(stringEndWithNumberString);
        Boolean mixStringAndNumberValidateResult = CheckerUtil.hasExcludeNumberInString(mixStringAndNumberString);
        // when

        assertThat(onlyNumberValidateResult).isFalse();
        assertThat(stringStartWithNumberValidateResult).isTrue();
        assertThat(stringEndWithNumberValidateResult).isTrue();
        assertThat(mixStringAndNumberValidateResult).isTrue();
        // then
    }

    @Test
    void 중복_문자_여부_체크_기능_테스트() {
        String hasDuplicateTextInString = "ab!c!def";
        String noneDuplicateTextInString = "abcdef12345";
        // given

        Boolean hasDuplicateStringResult = CheckerUtil.hasDuplicateCharacterInString(hasDuplicateTextInString);
        Boolean noneDuplicateStringResult = CheckerUtil.hasDuplicateCharacterInString(noneDuplicateTextInString);
        // when

        assertThat(hasDuplicateStringResult).isTrue();
        assertThat(noneDuplicateStringResult).isFalse();
    }
}
