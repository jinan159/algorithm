package lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        if (A.length <= 1) {
            return A;
        }

        int rotateCount = K % A.length;

        List<Integer> collect = Arrays.stream(A)
            .boxed()
            .collect(Collectors.toList());

        for (int i = 0; i < rotateCount; i++) {
            collect.add(0, collect.remove(collect.size() - 1));
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = collect.get(i);
        }

        return A;
    }
}
