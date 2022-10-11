package lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A) {

        Set<Integer> numbers = new HashSet<>();

        for (int a : A) {
            numbers.add(a);
        }

        return numbers.size();
    }
}
