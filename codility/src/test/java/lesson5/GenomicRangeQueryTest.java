package lesson5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GenomicRangeQueryTest {

    private final GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

    @ParameterizedTest
    @MethodSource("provide")
    void test(String S, int[] P, int[] Q, int[] result) {
        assertArrayEquals(result, genomicRangeQuery.solution(S, P, Q));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(String S, int[] P, int[] Q, int[] result) {
        long before = System.currentTimeMillis();
        assertArrayEquals(result, genomicRangeQuery.solution(S, P, Q));
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("milli sec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
            Arguments.of("CAGCCTA", new int[]{2, 2, 5}, new int[]{2, 5, 6}, new int[]{3, 2, 1})
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        String dna = "G".repeat(30_000) + "A"+ "G".repeat(30_000) + "C" + "G".repeat(39_998);
        int[] P = new int[50000];
        int[] Q = new int[50000];
        int[] result = new int[50000];

        Arrays.fill(P, 0);
        Arrays.fill(Q, 99999);
        Arrays.fill(result, 1);

        return Stream.of(
            Arguments.of(dna, P, Q, result)
        );
    }
}