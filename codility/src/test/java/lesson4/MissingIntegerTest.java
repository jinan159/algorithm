package lesson4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissingIntegerTest {

    private final MissingInteger missingInteger = new MissingInteger();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, missingInteger.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, missingInteger.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 2, 6, 4}, 5),
            Arguments.of(new int[]{1, 3, 6, 4, 1, 2}, 5),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6),
            Arguments.of(new int[]{-1, -3}, 1)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[1_000_000];

        for (int i = 1; i < largeInput.length + 1; i++) {
            largeInput[i - 1] = i;
        }

        largeInput[1_000_000 - 1] = 1_000_001;

        return Stream.of(
            Arguments.of(largeInput, 1_000_000)
        );
    }
}