package lesson3;

import java.util.Arrays;

public class PermMissingElem {

    public int solution(int[] A) {
        int answer = 0;

        int[] numbers = new int[A.length + 2];
        Arrays.fill(numbers, -1);
        numbers[0] = 0;

        for (int a : A) {
            numbers[a] = a;
        }

        for (int i = 1; i <= numbers.length; i++) {
            if (numbers[i] == -1) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
