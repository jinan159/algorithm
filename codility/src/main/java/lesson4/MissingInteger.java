package lesson4;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    public int solution(int[] A) {
        Set<Integer> numberSet = new HashSet<>();
        int answer = 1;
        int maxNum = 0;

        for (int a : A) {
            numberSet.add(a);
            maxNum = Math.max(maxNum, a);
        }

        for (int i = 1; i <= maxNum + 1; i++) {
            if (!numberSet.contains(i)) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
