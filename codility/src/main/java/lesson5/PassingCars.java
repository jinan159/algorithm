package lesson5;

import java.util.ArrayList;
import java.util.List;

public class PassingCars {

    private static final int EAST_CAR = 0; // -->

    public int solution(int[] A) {
        int[] westCarCounts = new int[A.length];
        List<Integer> eastCarIndexes = new ArrayList<>();

        int westCarCount = 0;

        for (int i = A.length - 1; 0 <= i; i--) {
            if (A[i] == EAST_CAR) {
                eastCarIndexes.add(i);
                westCarCounts[i] = westCarCount;
            } else {
                westCarCount++;
            }
        }

        long sum = 0;

        for (int eastCarIndex : eastCarIndexes) {
            sum += westCarCounts[eastCarIndex];

            if (1_000_000_000 < sum) {
                return -1;
            }
        }

        return (int) sum;
    }
}
