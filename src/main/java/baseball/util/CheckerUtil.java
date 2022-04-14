package baseball.util;

import baseball.functional.LoopHelper;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CheckerUtil {
    private static final Pattern HAS_EXCLUDE_NUMBER_REGEX = Pattern.compile("[^0-9].*");

    private CheckerUtil() {}

    public static Boolean hasExcludeNumberInString(String value) {
        return HAS_EXCLUDE_NUMBER_REGEX.matcher(value).find();
    }

    public static Boolean hasDuplicateCharacterInString(String value) {
        Set<String> removedDuplicatedBySplitValue = new HashSet<>();

        LoopHelper.arrayForEach(value.split(""), removedDuplicatedBySplitValue::add);

        return value.split("").length != removedDuplicatedBySplitValue.size();
    }
}
