package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution3Test {

    private final Solution3 solution3 = new Solution3();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, solution3.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, solution3.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{3, 2, 3, 2, 3}, 5),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{1, 2}, 2),
            Arguments.of(new int[]{1, 1}, 2),
            Arguments.of(new int[]{1, 1, 1}, 3),
            Arguments.of(new int[]{1, 2, 1}, 3),
            Arguments.of(new int[]{1, 2, 3}, 0),
            Arguments.of(new int[]{3, -7, 3, -7, 3}, 5),
            Arguments.of(new int[]{3, -7, 3, -7}, 4)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];

        return Stream.of(
            Arguments.of(largeInput, largeInput.length)
        );
    }
}