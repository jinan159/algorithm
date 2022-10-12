package lesson6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxProductOfThreeTest {

    private final MaxProductOfThree maxProductOfThree = new MaxProductOfThree();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, maxProductOfThree.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, maxProductOfThree.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        int[] largeInput = new int[2001];
        int[] largeInput2 = new int[100_000];

        int num = -1000;

        for (int i = 0; i < largeInput.length; i++) {
            largeInput[i] = num + i;
        }

        Arrays.fill(largeInput2, 1000);

        return Stream.of(
            Arguments.of(new int[] {-1, 1, 2, -2, 5, 6}, 60),
            Arguments.of(new int[] {-1, -1, 2, -2, 5, 6}, 60),
            Arguments.of(new int[] {-1, 3, 8, -10, 5, 1}, 120),
            Arguments.of(new int[] {4, 7, 3, 2, 1, -3, -5}, 105),
            Arguments.of(largeInput, 1000 * (-1000) * (-999)),
            Arguments.of(largeInput2, 1000 * 1000 * 1000),
            Arguments.of(new int[] {-1, 3, 8, -10, 2, 1}, 80)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];



        return Stream.of(
            Arguments.of(largeInput, 1)
        );
    }
}