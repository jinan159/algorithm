package lesson3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermMissingElemTest {

    PermMissingElem permMissingElem = new PermMissingElem();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int[] A, int result) {
        assertEquals(result, permMissingElem.solution(A));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 1, 5}, 4)
        );
    }
}