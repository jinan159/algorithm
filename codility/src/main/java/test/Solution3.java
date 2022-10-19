package test;

public class Solution3 {
    public int solution(int[] A) {

        if (A.length <= 2) {
            return A.length;
        }

        int maxLen = 0;
        int len = 1;
        int n0 = Integer.MIN_VALUE;

        // O(N)
        for (int i = 0; i < A.length - 2; i++) {
            int n1 = A[i];
            int n2 = A[i + 1];
            int n3 = A[i + 2];

            if (n1 == n3 && n0 == n2) {
                len += 1;
            } else if (n1 == n3 && n0 != n2) {
                len = 3;
            } else if (n1 != n3 && n0 == n2) {
                maxLen = Math.max(maxLen, len);
                len = 0;
            } else {
                // n1 != n3 and n0 != n2
                len = 0;
            }

            n0 = n1;
        }

        maxLen = Math.max(len, maxLen);

        return maxLen;
    }
}

 /*
            maxLen = 0
            len = 3
            n0 = A[1]
            do
                n1, n2, n3

                if n1 == n3 and n0 == n2
                    if (len == 1) len += 3
                    else len += 1
                elif n1 == n3 and n0 != n2
                    len = 3
                elif n1 != n3 and n0 == n2
                    maxLen = Math.max(maxLen, len)
                    len = 0
                elif n1 != n3 and n0 != n2
                    len = 0
              while 0 ~ n-1
         */
        /*
            += 1
            n0 n1 n2 n3
            1  2  1  2  1  2  1  1

            n0 n1 n2 n3
            1  1  1  1  1  2  1  2  1  1
               n0 n1 n2 n3
            1  1  1  1  1  2  1  2  1  1
                  n0 n1 n2 n3
            1  1  1  1  1  2  1  2  1  1
                     n0 n1 n2 n3
            1  1  1  1  1  2  1  2  1  1

            n0 n1 n2 n3
            3  4  3  4  5  6  7

            n0 n1 n2 n3
            1  1  1  2  1  2  1  1
               n0 n1 n2 n3
            1  1  1  2  1  2  1  1

            = 3
            n0 n1 n2 n3 => 4
            1  1  1  1  2  1  2  1  1

               n0 n1 n2 n3  => 4
            1  1  1  1  2  1  2  1  1

                  n0 n1 n2 n3
            1  1  1  1  2  1  2  1  1



         */
