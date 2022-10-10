package lesson2;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Set<Integer> nonePairSet = new HashSet<>();

        for (int a : A) {
            if (nonePairSet.contains(a)) {
                nonePairSet.remove(a);
            } else {
                nonePairSet.add(a);
            }
        }

        return nonePairSet.iterator().next();
    }
}
