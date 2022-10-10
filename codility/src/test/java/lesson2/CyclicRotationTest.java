package lesson2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CyclicRotationTest {

    private final CyclicRotation cyclicRotation = new CyclicRotation();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int[] A, int K, int[] result) {
        assertArrayEquals(result, cyclicRotation.solution(A, K));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}),
            Arguments.of(new int[]{3, 8, 9, 7, 6}, 5, new int[]{3, 8, 9, 7, 6}),
            Arguments.of(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}),
            Arguments.of(new int[]{0, 0, 0}, 1, new int[]{0, 0, 0})
        );
    }
}