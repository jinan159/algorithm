# 프린터
https://programmers.co.kr/learn/courses/30/lessons/42587?language=java

어렵지 않은 문제였다.

일반적인 프린터는 인쇄 요청이 `들어온 순서대로` 인쇄합니다...

아주 대놓고 큐를 쓰라고 하는 문제 설명이다.

그저 Queue에 작업을 모두 넣고, 현재 작업(peek)의 중요도보다 큰 작업이

뒤에 있으면 빼서(poll) 다시 뒤에 넣으면서 location을 같이 계산하며 추적하면 간단히 해결된다.

----

# 풀이

```java
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int p : priorities) {
            queue.offer(p);
        }
        
        while(!queue.isEmpty()) {
            
            if (isPeekMostImportant(queue)) {
                queue.poll();
                answer++;
                
                if (location == 0) break;
                
                location = moveLocation(location, queue.size());                
                continue;
            }
            
            int peek = queue.poll();
            queue.offer(peek);
            location = moveLocation(location, queue.size());
        }        
        
        return answer;
    }
    
    private boolean isPeekMostImportant(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return false;
        }
        
        int max = Collections.max(queue);
        int peek = queue.peek();
        
        if (peek < max) {
            return false;
        }
        
        return true;
    }
    
    private int moveLocation(int location, int maxLength) {
        location -= 1;
        
        if (location < 0) {
            location = maxLength -1;
        }
        
        return location;
    }
}
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32611"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (1.08ms, 73MB)</td></tr><tr data-testcase-id="32612"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (3.26ms, 79.8MB)</td></tr><tr data-testcase-id="32613"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.83ms, 66.4MB)</td></tr><tr data-testcase-id="32614"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.77ms, 72.5MB)</td></tr><tr data-testcase-id="32615"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.27ms, 77.5MB)</td></tr><tr data-testcase-id="32616"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (1.18ms, 70.6MB)</td></tr><tr data-testcase-id="32617"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.03ms, 73.9MB)</td></tr><tr data-testcase-id="32618"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (3.63ms, 78.9MB)</td></tr><tr data-testcase-id="32619"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.47ms, 75.2MB)</td></tr><tr data-testcase-id="32620"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.14ms, 78MB)</td></tr><tr data-testcase-id="32621"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (2.15ms, 73.9MB)</td></tr><tr data-testcase-id="32622"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.63ms, 77.9MB)</td></tr><tr data-testcase-id="32623"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (2.14ms, 78.8MB)</td></tr><tr data-testcase-id="32624"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.20ms, 76.9MB)</td></tr><tr data-testcase-id="32625"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.33ms, 74.5MB)</td></tr><tr data-testcase-id="32626"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.75ms, 78.3MB)</td></tr><tr data-testcase-id="32627"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (3.14ms, 79.5MB)</td></tr><tr data-testcase-id="32628"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.40ms, 75.8MB)</td></tr><tr data-testcase-id="32629"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (2.26ms, 69.7MB)</td></tr><tr data-testcase-id="32630"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (0.84ms, 76.8MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
