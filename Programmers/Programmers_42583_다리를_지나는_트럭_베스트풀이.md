# 다리를 지나는 트럭
https://programmers.co.kr/learn/courses/30/lessons/42583?language=java

나는 bridge의 길이만큼 queue에 데이터를 넣어고, 꽉차면 밀어내는 방식으로 끝까지 간 트럭을 확인했는데
여기서는 객체지향을 이용하여 직관적이게 구조를 짰다.

나는 빈 공간을 계속 채워넣어야해서 overhead가 많은데, 여기서는 정말 필요한 정도만 연산을 하기 때문에
소요시간도 나와 아주 많이 차이가 난다.

> 핵심 : 문제에서 동일한 속성, 동작을 가진 개체가 여러개 나오면 객체지향으로 해결 방안을 찾아보자

```java
import java.util.*;

class Solution {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33014"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (2.94ms, 73.5MB)</td></tr><tr data-testcase-id="33015"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (12.32ms, 78.1MB)</td></tr><tr data-testcase-id="33016"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.63ms, 77.7MB)</td></tr><tr data-testcase-id="33017"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (23.32ms, 76.8MB)</td></tr><tr data-testcase-id="33018"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (52.87ms, 87.4MB)</td></tr><tr data-testcase-id="33019"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (49.20ms, 85.3MB)</td></tr><tr data-testcase-id="33020"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.83ms, 83.9MB)</td></tr><tr data-testcase-id="33021"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (1.52ms, 70.4MB)</td></tr><tr data-testcase-id="33022"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (5.45ms, 76.1MB)</td></tr><tr data-testcase-id="33023"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.34ms, 73.8MB)</td></tr><tr data-testcase-id="33024"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.66ms, 75.3MB)</td></tr><tr data-testcase-id="33025"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (1.99ms, 72MB)</td></tr><tr data-testcase-id="33026"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (2.47ms, 77.7MB)</td></tr><tr data-testcase-id="69253"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.75ms, 74.4MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
