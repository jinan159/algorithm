package lesson3;

public class TapeEquilibrium {

    private static final int MAX_VALUE = 2001;

    public int solution(int[] A) {
        int N = A.length;

        int[] sum = new int[N];
        int[] reverseSum = new int[N];
        sum[0] = A[0];
        reverseSum[N - 1] = A[N - 1];

        for (int s = 1; s < N; s++) {
            int rs = N - 1 - s;

            sum[s] = A[s] + sum[s - 1];
            reverseSum[rs] = A[rs] + reverseSum[rs + 1];
        }

        int min = MAX_VALUE;

        for (int i = 1; i < N; i++) {
            min = Math.min(min, Math.abs(sum[i - 1] - reverseSum[i]));
        }

        return min;
    }
}
