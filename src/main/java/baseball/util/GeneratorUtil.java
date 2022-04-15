package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GeneratorUtil {

    private GeneratorUtil() {}

    public static List<Integer> generateRandomIntegerListWithoutDuplicate(
        int rangeStartInt, int rangeEndInt, int listSize
    ) {
        validateRangeLength(listSize, rangeEndInt - rangeStartInt + 1);

        List<Integer> result = new ArrayList<>();

        while(result.size() < listSize) {
            ifNoHasThenAddInList(result, Randoms.pickNumberInRange(rangeStartInt, rangeEndInt));
            /*
            Randoms 에 range validation 존재
            요구사항에 pickNumberInRange 를 사용해야 하므로 pickUniqueNumbersInRange 사용 불가
             */
        }

        return result;
    }

    private static void validateRangeLength(int rangeLength, int availableElementCount) {
        if (rangeLength < 0) {
            throw new IllegalArgumentException("Range length is not allow negative number.");
        }
        if (rangeLength > availableElementCount) {
            throw new IllegalArgumentException("Cannot generate list over usable number.");
        }
    }

    private static <T> void ifNoHasThenAddInList(List<T> source, T value) {
        if (!source.contains(value)) {
            source.add(value);
        }
    }
}
