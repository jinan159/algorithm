package lesson1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinaryGapTest {

    private final BinaryGap binaryGap = new BinaryGap();

    @ParameterizedTest
    @MethodSource("provide")
    void one_character(int n, int result) {
        assertEquals(result, binaryGap.solution(n));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            // 정답이 0인 경우의 수
            Arguments.of(9, 2),
            Arguments.of(529, 4),
            Arguments.of(20, 1),
            Arguments.of(15, 0),
            Arguments.of(32, 0)
        );
    }
}