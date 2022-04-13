package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GeneratorUtil {

    private GeneratorUtil() {}

    public static List<Integer> generateRandomIntegerListWithoutDuplicate(
        int rangeStartInt, int rangeEndInt, int listSize
    ) {
        validateRangeLength(listSize, rangeEndInt - rangeStartInt + 1);

        Set<Integer> result = new HashSet<>();

        while(result.size() < listSize) {
            result.add(Randoms.pickNumberInRange(rangeStartInt, rangeEndInt));
            /*
            Randoms 에 range validation 존재
            요구사항에 pickNumberInRange 를 사용해야 하므로 pickUniqueNumbersInRange 사용 불가
             */
        }

        return shuffleFromSet(result);
    }

    private static void validateRangeLength(int rangeLength, int availableElementCount) {
        if (rangeLength < 0) {
            throw new IllegalArgumentException("Range length is not allow negative number.");
        }
        if (rangeLength > availableElementCount) {
            throw new IllegalArgumentException("Cannot generate list over usable number.");
        }
    }

    private static List<Integer> shuffleFromSet(Set<Integer> from) {
        List<Integer> to = new ArrayList<>(from);
        Collections.shuffle(to);

        return to;
    }
}
