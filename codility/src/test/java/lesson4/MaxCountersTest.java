package lesson4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxCountersTest {

    private final MaxCounters maxCounters = new MaxCounters();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int N, int[] A, int[] result) {
        assertArrayEquals(result, maxCounters.solution(N, A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int N, int[] A) {
        long before = System.currentTimeMillis();
        maxCounters.solution(N, A);
        long after = System.currentTimeMillis();
        System.out.println((after - before) + " millisecond");
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2}),
            Arguments.of(3, new int[]{1, 1, 4, 3, 3, 4, 2}, new int[]{4, 5, 4}),
            Arguments.of(1, new int[]{1, 2, 1}, new int[]{2})
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];
        for (int i = 1; i <= largeInput.length; i++) {
            largeInput[i - 1] = 100_001;
        }

        return Stream.of(
            Arguments.of(100_000, largeInput)
        );
    }
}