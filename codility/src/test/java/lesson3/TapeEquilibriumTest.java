package lesson3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TapeEquilibriumTest {

    private final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int[] A, int result) {
        assertEquals(result, tapeEquilibrium.solution(A));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, 2, 4, 3}, 1),
            Arguments.of(new int[]{-1000, 1000}, 2000),
            Arguments.of(new int[]{2, 3}, 1)
        );
    }
}