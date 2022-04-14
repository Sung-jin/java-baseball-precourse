package baseball.functional;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class LoopHelper {
    public static <T> void listForEach(List<T> source, Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T value: source) {
            action.accept(value);
        }
    }
}
