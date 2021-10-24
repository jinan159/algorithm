# 주식가격
https://programmers.co.kr/learn/courses/30/lessons/42584?language=java

역시 문제를 풀때는 계속해서 고정관념에서 빠져나오려는 노력이 중요한 것 같다.

이 문제는 `스택/큐` 카테고리에 있었다.

처음 문제를 봤을 때, '그냥 반복문으로 풀면 되는거 아닌가?' 생각했었다.

하지만 `스택/큐`로 분류되어있는 이유가 있을것이라고 생각하여, 계속 `스택/큐`로 풀 방법을 고민했다.

물론 방법이 있겠지만, 나는 쉽게 떠오르지 않았고 그냥 반복문으로 풀었다.

실행 결과와 효율성도 통과했다.

생각해보니, 어차피 특정 가격이 언제 떨어지는지 알기 위해선 결국 반복문을 쓸 수 밖에 없으니 적절히 `break` 만 해주면 되는것 이었다.

> 결론 : 문제를 풀 때는 고정관념에 빠지지 말자.

----

# 풀이

```java
import java.util.*;

class Solution {    
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        for (int i=0; i<prices.length-1; i++) {
            int count = 0;
            
            for (int j=i+1; j<prices.length; j++) {
                int price = prices[i];
                int compareTarget = prices[j];
                
                count++;
                
                if (price > compareTarget) break;
            }
            
            answer[i] = count;
        }
        
        answer[answer.length-1] = 0;
        
        return answer;
    }
}


```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32800"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 79.2MB)</td></tr><tr data-testcase-id="32801"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.02ms, 78.8MB)</td></tr><tr data-testcase-id="32802"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.19ms, 72.5MB)</td></tr><tr data-testcase-id="32803"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.14ms, 79.4MB)</td></tr><tr data-testcase-id="32804"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.30ms, 76.7MB)</td></tr><tr data-testcase-id="32805"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 75MB)</td></tr><tr data-testcase-id="32806"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.09ms, 86.3MB)</td></tr><tr data-testcase-id="32807"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.10ms, 73.4MB)</td></tr><tr data-testcase-id="32808"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.02ms, 67.6MB)</td></tr><tr data-testcase-id="32809"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.18ms, 78.6MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="32810"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (17.30ms, 77.2MB)</td></tr><tr data-testcase-id="32811"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (11.89ms, 69.8MB)</td></tr><tr data-testcase-id="32812"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (18.80ms, 77.6MB)</td></tr><tr data-testcase-id="32813"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (14.56ms, 72.2MB)</td></tr><tr data-testcase-id="32814"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (10.14ms, 63.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 66.7</div><div class="console-message">효율성: 33.3</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
