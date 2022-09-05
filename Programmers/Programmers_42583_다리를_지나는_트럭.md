# 다리를 지나는 트럭
https://programmers.co.kr/learn/courses/30/lessons/42583?language=java

이 문제를 `java`로 풀때, 핵심은 `트럭`을 `객체화` 하는것이다.

이 문제를 보는 관점은 크게 두 가지라고 할 수 있다.

바로 `다리 관점`과 `트럭 관점`이다.

나는 처음에 `다리 관점`에서 문제를 풀었는데, 로직이 쉽게 정립되지 않았다.

먼저, 트럭이 나가는 시점인 다리의 끝 지점을 구현하기 위해서 큐에 빈 값을 넣어 꽉채워놓았다.

그리고 트럭이 한칸씩 가는것을 빈 값을 큐에서 하나씩 꺼내는것으로 표현했다.(왜 이랬을까 ㅋㅋ)

이렇게 문제를 풀다 보니, 마지막 트럭이 나가는 시점을 계산하는것이 복잡했다.

하지만, `트럭 관점`에서 문제를 보고나서 진짜 10분만에 문제를 풀었던 것 같다.

`트럭`을 `객체화`하여, 트럭의 무게(속성)와 행동(앞으로간다)를 지정해주니 문제가 정말 간단해졌다.

그저 다리위의 트럭들의 무게를 확인하여 트럭을 Queue에 넣고, 한 칸을 앞으로 갈때마다 각 `트럭`이

`다리`의 길이만큼 이동했는지만 확인하면 되는것이다.

문제를 풀때 잘 안되면, 다른 관점으로 문제를 다시 바라보자!

> 문제를 풀 때는, 고정관념을 버리고 다양한 관점으로 문제를 해석하자!

----

# 풀이
<details>
<summary>java</summary>

```java
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {
    final int EMPTY = 0;
    final int BRIDGE_MAX_WEIGHT = 10000;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        ArrayBlockingQueue<Integer> bridgeQueue = new ArrayBlockingQueue<Integer>(bridge_length);
        Queue<Integer> truckQueue = new LinkedList<Integer>();
        
        for (int t : truck_weights) {
            truckQueue.offer(t);
        }

        int nextTruck = truckQueue.poll();
        int seconds = 0;
        int trucksOnBridge = 0;
        
        do {
            if (isQueueFull(bridgeQueue)) {
                trucksOnBridge -= bridgeQueue.poll();
            }
            
            if (!isQueueFull(bridgeQueue)) {
                if (trucksOnBridge + nextTruck <= weight) {
                    bridgeQueue.offer(nextTruck);
                    trucksOnBridge += nextTruck;
                    if (truckQueue.isEmpty()) {
                        nextTruck = BRIDGE_MAX_WEIGHT;
                    } else {
                        nextTruck = truckQueue.poll();
                    }
                } else {
                    bridgeQueue.offer(EMPTY);
                }
            }
            
            seconds++;
            
        } while(!truckQueue.isEmpty() || isTrucksOnBridge(bridgeQueue));
        
        return seconds;
    }
    
    private boolean isQueueFull(ArrayBlockingQueue<Integer> queue) {
        if (queue != null && queue.remainingCapacity() == 0) {
            return true;
        }
        
        return false;
    }
    
    private boolean isTrucksOnBridge(ArrayBlockingQueue<Integer> queue) {
        if (queue != null && Collections.max(queue) > 0) return true;
        
        return false;
    }
}
```
</details>

<details>
<summary>python</summary>

```python
def solution(bridge_length, weight, truck_weights):
    curr_weight = 0
    truck_move_time = bridge_length

    moving_weights = []
    moving_truck_times = []

    time = 0

    while len(truck_weights) > 0 or len(moving_truck_times) > 0:
        time += 1

        if len(moving_truck_times) > 0 and moving_truck_times[0] == 0:
            moving_truck_times.pop(0)
            arrived_truck_weight = moving_weights.pop(0)
            curr_weight -= arrived_truck_weight

        if len(moving_truck_times) < bridge_length and len(truck_weights) > 0 and curr_weight + truck_weights[0] <= weight:
            start_truck_weight = truck_weights.pop(0)
            moving_weights.append(start_truck_weight)
            curr_weight += start_truck_weight

            moving_truck_times.append(truck_move_time)

        for i in range(len(moving_truck_times)):
            moving_truck_times[i] -= 1

    return time
```
</details>

----

# 결과

<details>
<summary>java</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33014"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (142.48ms, 83.9MB)</td></tr><tr data-testcase-id="33015"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (2715.70ms, 83.2MB)</td></tr><tr data-testcase-id="33016"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (3.69ms, 79.6MB)</td></tr><tr data-testcase-id="33017"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (125.62ms, 75.5MB)</td></tr><tr data-testcase-id="33018"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (1123.73ms, 84.4MB)</td></tr><tr data-testcase-id="33019"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (280.16ms, 82.8MB)</td></tr><tr data-testcase-id="33020"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (37.06ms, 75.7MB)</td></tr><tr data-testcase-id="33021"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (4.95ms, 78.3MB)</td></tr><tr data-testcase-id="33022"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (9.64ms, 77MB)</td></tr><tr data-testcase-id="33023"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (5.23ms, 74.2MB)</td></tr><tr data-testcase-id="33024"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.97ms, 74.7MB)</td></tr><tr data-testcase-id="33025"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (3.27ms, 76.3MB)</td></tr><tr data-testcase-id="33026"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (6.68ms, 73.5MB)</td></tr><tr data-testcase-id="69253"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (4.62ms, 77.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>

<details>
<summary>python</summary>
<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33014"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (1.75ms, 10.4MB)</td></tr><tr data-testcase-id="33015"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (25.53ms, 10.3MB)</td></tr><tr data-testcase-id="33016"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.1MB)</td></tr><tr data-testcase-id="33017"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (51.75ms, 10.3MB)</td></tr><tr data-testcase-id="33018"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (417.99ms, 10.3MB)</td></tr><tr data-testcase-id="33019"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (145.41ms, 10.2MB)</td></tr><tr data-testcase-id="33020"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.59ms, 10.2MB)</td></tr><tr data-testcase-id="33021"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.44ms, 10.2MB)</td></tr><tr data-testcase-id="33022"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (8.55ms, 10.3MB)</td></tr><tr data-testcase-id="33023"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.53ms, 10.2MB)</td></tr><tr data-testcase-id="33024"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="33025"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.95ms, 10.2MB)</td></tr><tr data-testcase-id="33026"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (3.29ms, 10.1MB)</td></tr><tr data-testcase-id="69253"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>
</details>
