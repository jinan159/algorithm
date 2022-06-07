# 크레인 인형뽑기 게임
https://programmers.co.kr/learn/courses/30/lessons/64061

뽑힌 인형을 차례대로 하나씩 쌓는 개념이라, Stack 자료구조에 넣어서 구현했습니다.

----

# 풀이

```java
import java.util.*;

class Solution {
    
    private final int EMPTY = 0;
    
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> picked = new Stack<>();
        int popedDolls = 0;
        
        for (int move : moves) {
            int doll = pick(board, move-1);
        
            if (isDollPop(picked, doll)) {
                popedDolls += 2;
                picked.pop();
                continue;
            }
            
            if (doll == EMPTY) continue;
            
            picked.add(doll);
        }
        
        return popedDolls;
    }
    
    private int pick(int[][] board, int col) {
        for (int i=0; i<board.length; i++) {
            int doll = board[i][col];
            
            if (doll != EMPTY) {
                board[i][col] = EMPTY;
                return doll;
            }
        }
        
        return EMPTY;
    }
    
    private boolean isDollPop(Stack<Integer> picked, int doll) {
        return !picked.isEmpty() && picked.peek() == doll;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/150055224-2fd630d0-072f-41a0-b902-a9762d93ccb5.png)