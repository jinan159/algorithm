package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Solution1Test {

    private final Solution1 solution1 = new Solution1();

    @ParameterizedTest
    @MethodSource("provide")
    void test(String S, String C, String result) {
        assertEquals(result, solution1.solution(S, C));
    }

    @ParameterizedTest
    @MethodSource("timeoutProvide")
    void testTimeout(String S, String C) {
        long before = System.currentTimeMillis();
        solution1.solution(S, C);
        long after = System.currentTimeMillis();

        System.out.println("============================");
        System.out.println("millisec = " + (after - before));
    }

    private static Stream<Arguments> provide() {
        return Stream.of(
            Arguments.of("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "Example", "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>"),
            Arguments.of("John Doe, John Doe, John Doe", "Kakao", "John Doe <jdoe@kakao.com>, John Doe <jdoe2@kakao.com>, John Doe <jdoe3@kakao.com>"),
            Arguments.of("John Doe, John Dominic Oe", "Kakao", "John Doe <jdoe@kakao.com>, John Dominic Oe <jdoe2@kakao.com>")
        );
    }

    private static Stream<Arguments> timeoutProvide() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100_00; i++) {
            sb.append("John Doe");

            if (i < 99_99) sb.append(", ");
        }


        return Stream.of(
            Arguments.of(sb.toString(), "Example", "")
        );
    }
}