package baseball.play.domain;

import baseball.functional.LoopHelper;
import baseball.util.CheckerUtil;
import baseball.util.GeneratorUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private final int ANSWER_LENGTH = 3;
    private final int ANSWER_RANGE_START_NUMBER = 1;
    private final int ANSWER_RANGE_END_NUMBER = 9;

    private List<Integer> answer;
    private Boolean isEndedGame;
    private int ballCount = 0;
    private int strikeCount = 0;

    public void start() {
        init();

        while (!isEndedGame) {
            List<Integer> enteredAnswer = enterAnswerByPlayer();
        }
    }

    private void init() {
        answer = GeneratorUtil.generateRandomIntegerListWithoutDuplicate(
            ANSWER_RANGE_START_NUMBER, ANSWER_RANGE_END_NUMBER, ANSWER_LENGTH
        );
        isEndedGame = false;
    }

    private List<Integer> enterAnswerByPlayer() {
        String enteredByPlayer = Console.readLine();

        validateEnteredByPlayer(enteredByPlayer);

        return LoopHelper.arrayMapToList(enteredByPlayer.split(""), Integer::parseInt);
    }

    private void validateEnteredByPlayer(String value) {
        if (CheckerUtil.hasExcludeNumberInString(value)) {
            throw new IllegalArgumentException("Only numeric input is allowed");
        }
        if (value.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException(String.format("You must enter a %d digit number", ANSWER_LENGTH));
        }
        if (CheckerUtil.hasDuplicateCharacterInString(value)) {
            throw new IllegalArgumentException("Only non-duplicate numbers are allowed");
        }
    }

    private List<Integer> convertStringToSingleNumberList(String value) {
        List<Integer> result = new ArrayList<>();

        for (String charValue: value.split("")) {
            result.add(Integer.parseInt(charValue));
        }

        return result;
    }
}
