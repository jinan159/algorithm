package lesson4;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    private static final int TRUE = 1;
    private static final int FALSE = 0;

    public int solution(int[] A) {
        /*
            - 중복된 수
            - 중간에 하나 없는거
                - 1 이 없는거


         */
        Set<Integer> numbers = new HashSet<>();

        int maxNum = -1;

        for (int a : A) {
            if (numbers.contains(a)) return FALSE;

            numbers.add(a);
            maxNum = Math.max(maxNum, a);
        }

        for (int i = 1; i <= maxNum; i++) {
            if (!numbers.contains(i)) {
                return FALSE;
            }
        }

        return TRUE;
    }
}
