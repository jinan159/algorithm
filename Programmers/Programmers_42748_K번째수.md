# K번째수
https://programmers.co.kr/learn/courses/30/lessons/42748

배열 자르기, 정렬을 이용하여 간단하게 풀 수 있는 문제입니다.

----

# 풀이

<details>
<summary>java</summary>

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

</details>

<details>
<summary>python3</summary>

```python
def solution(array : list, commands : list):
    answer = []

    for command in commands:
        start = command[0] - 1
        end = command[1]
        index = command[2] - 1

        array_copy = array.copy()
        array_copy = array_copy[start:end]
        array_copy.sort()
        answer.append(array_copy[index])

    return answer
```

</details>

----

# 결과

<details>
<summary>java</summary>
![image](https://user-images.githubusercontent.com/45728407/150055586-9ee3b61d-d5ba-4e11-9086-7e7ec6f520ea.png)
</details>

<details>
<summary>python3</summary>

</details>
