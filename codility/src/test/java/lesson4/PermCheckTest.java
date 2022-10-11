package lesson4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermCheckTest {

    private final PermCheck permCheck = new PermCheck();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, permCheck.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, permCheck.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 2, 5, 4}, 1),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{1, 1, 2}, 0),
            Arguments.of(new int[]{1, 2}, 1),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 10000}, 0),
            Arguments.of(new int[]{3, 2}, 0),
            Arguments.of(new int[]{1, 3}, 0),
            Arguments.of(new int[]{3, 1, 2, 5, 4, 7}, 0)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[1_000_000];

        for (int i = 1; i < largeInput.length + 1; i++) {
            largeInput[i-1] = i;
        }

        return Stream.of(
            Arguments.of(largeInput, 1)
        );
    }
}