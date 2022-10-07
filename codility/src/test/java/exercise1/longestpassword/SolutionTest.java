package exercise1.longestpassword;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
        "c:-1",
        "11:-1",
        "1:1",
        "word:-1",
        "1word:5",
        "?1word:-1",
        "test 5 a0A pass007 ?xy1:7"
    }, delimiter = ':')
    void one_character(String S, int result) {
        assertEquals(solution.solution(S), result);
    }

}