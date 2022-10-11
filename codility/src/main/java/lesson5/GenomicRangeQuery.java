package lesson5;

import java.util.Map;


public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int M = P.length;

        Map<Character, Integer> dnaMap = Map.of(
            'A', 0,
            'C', 1,
            'G', 2,
            'T', 3
        );

        char[] dnaArray = S.toCharArray();
        int[][] dnaCounts = new int[dnaArray.length][4];
        int[] dnaSum = new int[4];

        for (int i = 0; i < dnaArray.length; i++) {
            dnaSum[dnaMap.get(dnaArray[i])]++;

            System.arraycopy(dnaSum, 0, dnaCounts[i], 0, dnaSum.length);
        }

        int[] answer = new int[M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                int endSum = dnaCounts[Q[i]][j];
                int beforeStartSum = P[i] == 0 ? 0 : dnaCounts[P[i]-1][j];

                if (endSum - beforeStartSum > 0) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
