# 크레인 인형뽑기 게임

https://programmers.co.kr/learn/courses/30/lessons/64061

뽑힌 인형을 차례대로 하나씩 쌓는 개념이라, Stack 자료구조에 넣어서 구현했습니다.

----

# 풀이

<details>
<summary>java</summary>

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

</details>

<details>
<summary>python3</summary>

```python
def checkBomb(picked: list):
    if picked[-1:] == picked[-2:-1]:
        return True, picked[:-2]

    return False, picked


def solution(board, moves):
    answer = 0

    empty = 0;
    picked = []

    for m in moves:
        line_num = m - 1
        height = 0

        while height < len(board):
            current = board[height][line_num]
            if current != 0:
                picked.append(current)
                board[height][line_num] = empty
                is_removed, picked = checkBomb(picked)
                if is_removed:
                    answer += 2
                break
            height += 1

    return answer
```

</details>

----

# 결과

<details>
<summary>java</summary>

![image](https://user-images.githubusercontent.com/45728407/150055224-2fd630d0-072f-41a0-b902-a9762d93ccb5.png)

</details>

<details>
<summary>python3</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="68729"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.3MB)</td></tr><tr data-testcase-id="68730"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="68731"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="68732"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (1.89ms, 10MB)</td></tr><tr data-testcase-id="68733"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="68734"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10MB)</td></tr><tr data-testcase-id="68735"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.1MB)</td></tr><tr data-testcase-id="68736"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.80ms, 10.1MB)</td></tr><tr data-testcase-id="68737"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.39ms, 10.1MB)</td></tr><tr data-testcase-id="68738"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.46ms, 10.1MB)</td></tr><tr data-testcase-id="68740"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (1.05ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
