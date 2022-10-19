package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution2Test {

    private final Solution2 solution2 = new Solution2();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] T, int[] A, int result) {
        assertEquals(result, solution2.solution(T, A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] T, int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, solution2.solution(T, A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{0, 0, 1, 1}, new int[]{2}, 3),
            Arguments.of(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6}, 5),
            Arguments.of(new int[]{0, 0, 1, 2}, new int[]{1, 2}, 3),
            Arguments.of(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0}, 7),
            Arguments.of(new int[]{0, 1, 0, 1, 0, 3, 2, 3, 2, 7, 4, 5, 12}, new int[]{8,9,10,11,12}, 12)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];

        return Stream.of(
            Arguments.of(largeInput, largeInput.length)
        );
    }
}