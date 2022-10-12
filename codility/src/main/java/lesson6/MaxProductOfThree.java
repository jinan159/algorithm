package lesson6;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);

        int N = A.length;

        int minProduct = A[N - 1] * A[N - 2] * A[N - 3];

        if (A[0] < 0 && A[1] < 0 && A[N - 1] > 0 ) {
            minProduct = Math.max(minProduct, (A[0] * A[1] * A[N - 1]));
        }

        return minProduct;
    }
}
