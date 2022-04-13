package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CheckerUtil {
    private static final Pattern HAS_EXCLUDE_NUMBER_REGEX = Pattern.compile("[^0-9].*");

    public static Boolean hasExcludeNumberInString(String value) {
        return HAS_EXCLUDE_NUMBER_REGEX.matcher(value).find();
    }

    public static Boolean hasDuplicateCharacterInString(String value) {
        String[] splitValue = value.split("");
        Set<Character> removedDuplicatedBySplitValue = new HashSet<>();

        for (Character charValue: value.toCharArray()) {
            removedDuplicatedBySplitValue.add(charValue);
        }

        return splitValue.length != removedDuplicatedBySplitValue.size();
    }
}
