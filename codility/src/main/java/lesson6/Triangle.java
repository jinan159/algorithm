package lesson6;

import java.util.Arrays;

public class Triangle {

    public static int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            long sum = (long)A[i] + (long)A[i + 1];
            if (sum > A[i + 2]) {
                return 1;
            }
        }

        return 0;
    }
}