# K번째수
https://programmers.co.kr/learn/courses/30/lessons/42748

배열 자르기, 정렬을 이용하여 간단하게 풀 수 있는 문제입니다.

----

# 풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i=0; i<commands.length; i++) {
            answer[i] = getK(array, commands[i]);
        }
        
        return answer;
    }
    
    private int getK(int[] array, int[] command) {
        int from = command[0] - 1;
        int to = command[1];
        int k = command[2] - 1;
        
        int[] cutted = Arrays.copyOfRange(array, from, to);
        Arrays.sort(cutted);
    
        return cutted[k];
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/150055586-9ee3b61d-d5ba-4e11-9086-7e7ec6f520ea.png)