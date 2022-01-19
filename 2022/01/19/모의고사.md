# 모의고사
https://programmers.co.kr/learn/courses/30/lessons/42840

완전탐색을 통해 각 학생별로 문제를 맞춘 개수를 구하고, 가장 많이 맞춘 학생을 반환하는 형식으로 구현했습니다.

주의할 점은, 3명다 하나도 못맞췄을 경우 [] 를 반환해야 합니다.

----

# 풀이

```java
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] students = {
                { 1,2,3,4,5 },
                { 2,1,2,3,2,4,2,5 },
                { 3,3,1,1,2,2,4,4,5,5 }
        };

        int[] corrects = new int[students.length];

        for (int i=0; i<answers.length; i++) {
            for (int j=0; j<students.length; j++) {
                int[] student = students[j];
                int index = i % student.length;
                if (student[index] == answers[i]) {
                    corrects[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(corrects)
                .max()
                .getAsInt();

        List<Integer> bestStudents = new ArrayList<>();

        for (int i=0; i<corrects.length; i++) {
            if (maxScore > 0 && corrects[i] == maxScore) {
                bestStudents.add(i + 1);
            }
        }

        int[] answer = new int[bestStudents.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = bestStudents.get(i);
        }

        return answer;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/150055631-7c63abef-7619-473b-b7a8-6a5807864f18.png)