package lesson4;

public class MaxCounters {

    public int[] solution(int N, int[] A) {

        int[] counters = new int[N];

        int maxCounter = N  + 1;

        int maxCount = 0;
        int tempMaxCount = 0;

        for (int num : A) {
            int counterIndex = num - 1;

            if (num == maxCounter) {
                maxCount = tempMaxCount;
                continue;
            }

            if (counters[counterIndex] < maxCount) {
                counters[counterIndex] = maxCount;
            }

            counters[counterIndex]++;

            tempMaxCount = Math.max(tempMaxCount, counters[counterIndex]);
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < maxCount)
                counters[i] = maxCount;
        }

        return counters;
    }
}
