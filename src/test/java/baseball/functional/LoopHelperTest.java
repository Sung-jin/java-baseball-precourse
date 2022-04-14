package baseball.functional;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class LoopHelperTest {

    @Test
    void function_helper_list_forEach_기능_테스트() {
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger index = new AtomicInteger();

        LoopHelper.listForEach(original, (value) -> {
            assertThat(value).isEqualTo(original.get(index.getAndIncrement()));
        });
    }

    @Test
    void function_helper_list_map_기능_테스트() {
        int index = 0;
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);
        // when

        List<Integer> doubleMapResult = LoopHelper.listMap(original, (value) -> value * 2);
        // when

        for (Integer value: original) {
            assertThat(value * 2).isEqualTo(doubleMapResult.get(index++));
        }
        // then
    }

    @Test
    void function_helper_array_forEach_기능_테스트() {
        Integer[] original = {1, 2, 3, 4, 5};
        AtomicInteger index = new AtomicInteger();

        LoopHelper.arrayForEach(original, (value) -> {
            assertThat(value).isEqualTo(Array.get(original, index.getAndIncrement()));
        });
    }

    @Test
    void function_helper_array_map_to_list_기능_테스트() {
        int index = 0;
        Integer[] original = {1, 2, 3, 4, 5};
        // when

        List<Integer> doubleMapResult = LoopHelper.arrayMapToList(original, (value) -> value * 2);
        // when

        for (Integer value: original) {
            assertThat(value * 2).isEqualTo(doubleMapResult.get(index++));
        }
        // then
    }
}
