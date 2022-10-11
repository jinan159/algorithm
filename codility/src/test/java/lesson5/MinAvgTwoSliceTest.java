package lesson5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinAvgTwoSliceTest {

    private final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, minAvgTwoSlice.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, minAvgTwoSlice.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
            Arguments.of(new int[]{4, 3, 4, 3, 4}, 1),
            Arguments.of(new int[]{1, 2}, 0),
            Arguments.of(new int[]{1, 0}, 0),
            Arguments.of(new int[]{2, 0, 1, 1, 0, 0, 0, 0}, 4),
            Arguments.of(new int[]{-3, -5, -8, -4, -10}, 2)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];

        return Stream.of(
            Arguments.of(largeInput, 0)
        );
    }
}