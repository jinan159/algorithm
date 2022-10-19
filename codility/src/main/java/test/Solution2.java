package test;

import java.util.HashMap;
import java.util.Map;

class Skill {
    int no;
    boolean learned = false;
    Skill required = null;

    public Skill(int no) {
        this.no = no;
    }
}

public class Solution2 {

    public int solution(int[] T, int[] A) {
        Map<Integer, Skill> skillMap = new HashMap<>();

        // O(N)
        for (int no = 0; no < T.length; no++) {
            skillMap.put(no, new Skill(no));
        }

        // O(N)
        for (int no = 0; no < T.length; no++) {
            int requiredNo = T[no];
            if (requiredNo == no) continue;

            Skill skill = skillMap.get(no);
            skill.required = skillMap.get(requiredNo);
        }

        int totalLearnedCount = 0;

        // worst case : O(M * N)
        // normal case : O(M * log(N)) 이진 트리로 가정
        for (int a : A) {
            Skill skill = skillMap.get(a);
            int learnedCount = 0;

            while (skill != null && !skill.learned) {
                skill.learned = true;
                skill = skill.required;
                learnedCount++;
            }

            totalLearnedCount += learnedCount;
        }

        return totalLearnedCount;
    }
}
