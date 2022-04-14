package baseball.functional;

import org.junit.jupiter.api.Test;

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
}
