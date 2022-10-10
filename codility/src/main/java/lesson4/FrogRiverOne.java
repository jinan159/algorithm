package lesson4;

import java.util.HashSet;
import java.util.Set;

class FrogRiverOne {
    public int solution(int X, int[] A) {
        int answer = -1;

        Set<Integer> leafs = new HashSet<>();
        for (int i = 1; i < X + 1; i++) {
            leafs.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            leafs.remove(A[i]);

            if (leafs.isEmpty()) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
