package lesson5;

public class CountDiv {

    public int solution(int start, int end, int K) {
        int minDivNum = 0;
        int maxDivNum = 0;

        for (int i = start; i <= end; i++) {
            if (i % K == 0) {
                minDivNum = i;
                break;
            }
        }

        for (int i = end; start <= i; i--) {
            if (i % K == 0) {
                maxDivNum = i;
                break;
            }
        }

        if (minDivNum == maxDivNum && start <= minDivNum) {
            return 1;
        }

        if (start <= minDivNum && maxDivNum <= end) {
            return (maxDivNum / K) - (minDivNum / K) + 1;
        }

        return 0;
    }
}
