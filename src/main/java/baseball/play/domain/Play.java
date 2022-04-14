package baseball.play.domain;

import baseball.functional.LoopHelper;
import baseball.util.CheckerUtil;
import baseball.util.GeneratorUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> enteredAnswer = enterAnswerByPlayer();

            checkAnswer(enteredAnswer);
            checkResult();
            countInit();
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

    private void checkAnswer(List<Integer> enteredAnswer) {
        List<Integer> correctValues = LoopHelper.listFilter(enteredAnswer, (value) -> answer.contains(value));

        LoopHelper.listForEach(correctValues, (value) -> {
            int answerIndex = answer.indexOf(value);
            int enteredAnswerIndex = enteredAnswer.indexOf(value);

            if (answerIndex == enteredAnswerIndex) {
                strikeCount++;
            }

            if (answerIndex != enteredAnswerIndex) {
                ballCount++;
            }
        });
    }

    private void checkResult() {
        List<String> result = new ArrayList<>();

        if (ballCount > 0) {
            result.add(String.format("%d볼", ballCount));
        }

        if (strikeCount > 0) {
            result.add(String.format("%d스트라이크", strikeCount));
        }

        if (ballCount == 0 && strikeCount == 0) {
            result.add("낫싱");
        }

        System.out.println(String.join(" ", result));

        if (strikeCount == ANSWER_LENGTH) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", ANSWER_LENGTH);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            checkRestartPlay();
        }
    }

    private void checkRestartPlay() {
        String input = Console.readLine();

        if (input.equals("1")) {
            init();
            return;
        }
        if (Objects.equals(input, "2")) {
            isEndedGame = true;
            return;
        }

        throw new IllegalArgumentException("You must enter 1 or 2");
    }

    private void countInit() {
        strikeCount = 0;
        ballCount = 0;
    }
}
