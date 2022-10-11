package lesson5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PassingCarsTest {

    private final PassingCars passingCars = new PassingCars();

    @ParameterizedTest
    @MethodSource("provide")
    void test(int[] A, int result) {
        assertEquals(result, passingCars.solution(A));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int[] A, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, passingCars.solution(A));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        int[] largeInput = new int[100_000];

        for (int i = 0; i < largeInput.length; i++) {
            if (i < 50_000) {
                largeInput[i] = 0;
            } else {
                largeInput[i] = 1;
            }
        }

        return Stream.of(
            Arguments.of(new int[] {0, 1, 0, 1, 1}, 5),
            Arguments.of(new int[] {0, 0, 0, 1, 1}, 6),
            Arguments.of(new int[] {0, 1, 0, 1, 0, 1}, 6),
            Arguments.of(new int[] {1, 0, 1, 0, 1, 0}, 3),
            Arguments.of(new int[] {1, 1, 0, 0}, 0),
            Arguments.of(largeInput, -1)
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        int[] largeInput = new int[100_000];

        return Stream.of(
            Arguments.of(largeInput, 0)
        );
    }
}