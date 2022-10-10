package lesson4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FrogRiverOneTest {

    private final FrogRiverOne frogRiverOne = new FrogRiverOne();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int X, int[] A, int result) {
        assertEquals(result, frogRiverOne.solution(X, A));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 6),
            Arguments.of(5, new int[]{1, 1, 1, 1, 1, 3, 5, 4}, -1)
        );
    }
}