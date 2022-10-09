package exercise1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestPasswordTest {

    private final LongestPassword longestPassword = new LongestPassword();

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
        assertEquals(longestPassword.solution(S), result);
    }

}