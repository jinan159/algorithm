package exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FloodDepthTest {

    private final FloodDepth floodDepth = new FloodDepth();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int[] A, int result) {
        assertEquals(result, floodDepth.solution(A));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            // 정답이 0인 경우의 수
            Arguments.of(new int[] {0, 1, 2, 3, 2, 1, 0}, 0),
            Arguments.of(new int[] {3, 2, 1, 0, 0, 0, 0}, 0),
            Arguments.of(new int[] {0, 0, 0, 0, 0, 0, 0}, 0),
            Arguments.of(new int[] {9, 9, 9, 9, 9, 9, 9}, 0),
            Arguments.of(new int[] {0, 0, 0, 0, 1, 2, 3}, 0),

            // 정답이 1 이상인 경우의 수
            Arguments.of(new int[] {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}, 2),
            Arguments.of(new int[] {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 0}, 2),
            Arguments.of(new int[] {0, 2, 1, 0, 1, 1, 1, 0}, 1),
            Arguments.of(new int[] {0, 2, 2, 1, 1, 1, 2, 0}, 1),
            Arguments.of(new int[] {0, 4, 2, 1, 1, 1, 2, 0}, 1),
            Arguments.of(new int[] {3, 3, 2, 3, 1, 3, 0, 4}, 3),
            Arguments.of(new int[] {0, 2, 1, 0, 1, 1, 2, 0}, 2),

            Arguments.of(new int[] {1, 0, 0, 0, 0, 0, 0, 4}, 1),
            Arguments.of(new int[] {4, 0, 0, 0, 0, 0, 0, 1}, 1),
            Arguments.of(new int[] {4, 0, 0, 0, 0, 0, 0, 4}, 4),
            Arguments.of(new int[] {2, 1, 0, 1, 0, 1, 1, 4}, 2)
        );
    }
}