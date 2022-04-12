package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GenerateGame {
    private static final int ANSWER_LENGTH = 3;
    private static final int ANSWER_RANGE_START = 1;
    private static final int ANSWER_RANGE_END = 9;

    static List<Integer> generateAnswer() {
        Set<Integer> answer = new HashSet<>();

        while(answer.size() < ANSWER_LENGTH) {
            answer.add(Randoms.pickNumberInRange(ANSWER_RANGE_START, ANSWER_RANGE_END));
            // 요구사항에 pickNumberInRange 를 사용해야 하므로
            // pickUniqueNumbersInRange 사용 불가
        }

        return shuffleFromSet(answer);
    }

    private static List<Integer> shuffleFromSet(Set<Integer> from) {
        List<Integer> to = new ArrayList<>(from);
        Collections.shuffle(to);

        return to;
    }
}
