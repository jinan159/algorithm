# 더 맵게
https://programmers.co.kr/learn/courses/30/lessons/42626?language=java#

어렵지 않은 문제였지만, 질문하기를 보니 16번 테스트 케이스에서 헤매는 분들이 많은 것 같다.

이 문제의 핵심은 끝까지 계산하여 단 하나의 스코빌만 남아 더 이상 계산할 수 없는 상태가 되었을 때

목표 스코빌 지수(K)를 넘었다면 -1을 반환하지 않고, 섞은 횟수를 반환하는 것이다.

----

# 풀이

```java
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int mixedCount = 0;
        
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();
        
        for (int s : scoville) {
            scovilleQueue.offer(s);
        }
        
        while(scovilleQueue.size() > 1) {
            if (scovilleQueue.peek() >= K) {
                break;
            }
                
            int current = scovilleQueue.poll();
            int next = scovilleQueue.poll();
            int mixed = current + (next * 2);
            
            scovilleQueue.offer(mixed);
            mixedCount++;
        }
        
        if (scovilleQueue.size() == 1 && scovilleQueue.peek() < K) {
            mixedCount = -1;
        }
        
        return mixedCount;
    }
}
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32996"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.31ms, 71.3MB)</td></tr><tr data-testcase-id="32997"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.48ms, 75.9MB)</td></tr><tr data-testcase-id="32998"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.35ms, 73.4MB)</td></tr><tr data-testcase-id="32999"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.32ms, 73.9MB)</td></tr><tr data-testcase-id="33000"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.33ms, 78.7MB)</td></tr><tr data-testcase-id="33001"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (1.83ms, 76.4MB)</td></tr><tr data-testcase-id="33002"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.49ms, 74.6MB)</td></tr><tr data-testcase-id="33003"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.72ms, 77.1MB)</td></tr><tr data-testcase-id="33004"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.69ms, 76.1MB)</td></tr><tr data-testcase-id="33005"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.52ms, 82.7MB)</td></tr><tr data-testcase-id="33006"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (1.44ms, 74.4MB)</td></tr><tr data-testcase-id="33007"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (2.35ms, 83.4MB)</td></tr><tr data-testcase-id="33008"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (2.06ms, 78MB)</td></tr><tr data-testcase-id="33009"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.45ms, 75.6MB)</td></tr><tr data-testcase-id="33010"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (2.13ms, 77.3MB)</td></tr><tr data-testcase-id="33421"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.32ms, 72.7MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="32990"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (128.38ms, 65.5MB)</td></tr><tr data-testcase-id="32991"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (276.21ms, 86.8MB)</td></tr><tr data-testcase-id="32992"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (1375.32ms, 123MB)</td></tr><tr data-testcase-id="32993"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (103.43ms, 64.5MB)</td></tr><tr data-testcase-id="32994"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (1730.23ms, 127MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 76.2</div><div class="console-message">효율성: 23.8</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
