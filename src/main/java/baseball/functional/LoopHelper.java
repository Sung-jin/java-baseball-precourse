package baseball.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class LoopHelper {
    public static <T> void listForEach(List<T> source, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T value: source) {
            action.accept(value);
        }
    }

    public static <T, R> List<R> listMap(List<T> source, Function<? super T, ? extends R> mapper) {
        Objects.requireNonNull(mapper);

        List<R> result = new ArrayList<>();
        listForEach(source, (value) -> {
            result.add(mapper.apply(value));
        });

        return result;
    }

    public static <T> void arrayForEach(T[] source, Consumer<? super T> action) {
        List<T> convertToList = Arrays.asList(source);
        listForEach(convertToList, action);
    }

    public static <T, R> List<R> arrayMapToList(T[] source, Function<? super T, ? extends R> mapper) {
        List<T> convertToList = Arrays.asList(source);

        return listMap(convertToList, mapper);
    }
}