package baseball.play.domain;

import baseball.functional.LoopHelper;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ball {

    private Ball() {}

    public static int count(List<Integer> answer, List<Integer> enteredAnswer) {
        AtomicInteger count = new AtomicInteger();
        List<Integer> correctValues = LoopHelper.listFilter(enteredAnswer, answer::contains);

        LoopHelper.listForEach(correctValues, (value) -> {
            int answerIndex = answer.indexOf(value);
            int enteredIndex = enteredAnswer.indexOf(value);

            if (answerIndex != enteredIndex) {
                count.getAndIncrement();
            }
        });

        return count.get();
    }
}
