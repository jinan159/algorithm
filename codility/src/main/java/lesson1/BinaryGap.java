package lesson1;

public class BinaryGap {

    private static final char ZERO = '0';
    private static final char ONE = '1';

    public int solution(int N) {
        int answer = 0;

        char[] binary  = Integer.toBinaryString(N)
            .toCharArray();

        boolean isGapStarted = false;
        int gapCount = 0;

        for (char chr : binary) {
            if (chr == ONE) {
                answer = Math.max(answer, gapCount);

                isGapStarted = true;
                gapCount = 0;
            } else if (chr == ZERO && isGapStarted) {
                gapCount++;
            }
        }

        return answer;
    }
}
