package lesson5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountDivTest {

    private final CountDiv countDiv = new CountDiv();

    @Test
    void tests() {

    }

    @ParameterizedTest
    @MethodSource("provide")
    void test(int start, int end, int K, int result) {
        assertEquals(result, countDiv.solution(start, end, K));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(int start, int end, int K, int result) {
        long before = System.currentTimeMillis();
        assertEquals(result, countDiv.solution(start, end, K));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(1, 10, 2, 5),
            Arguments.of(1, 10, 2, 5),
            Arguments.of(0, 10, 2, 6),
            Arguments.of(0, 2_000_000_000, 1, 2_000_000_001),
            Arguments.of(0, 2_000_000_000, 2, 1_000_000_001),
            Arguments.of(10, 10, 5, 1),
            Arguments.of(10, 10, 20, 0),
            Arguments.of(0, 1, 11, 1),
            Arguments.of(6, 11, 2, 3),
            Arguments.of(11, 13, 12, 1),
            Arguments.of(10, 10, 5, 1),
            Arguments.of(10, 10, 7, 0),
            Arguments.of(11, 12, 11, 1)
            );
    }

    private static Stream<Arguments> timeoutProvide() {
        return Stream.of(
            Arguments.of(0, 2_000_000_000, 2_000_000_000, 2),
            Arguments.of(1, 2_000_000_000, 2_000_000_000, 1)
        );
    }
}