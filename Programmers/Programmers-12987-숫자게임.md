# 숫자 게임

https://school.programmers.co.kr/learn/courses/30/lessons/12987

- 상대보다 큰 수 중에서 가장 작은 수로 이기는것이 중요함
  - 그래야 다음 순서에서 더 많이 이길 수 있기 때문

----

# 풀이

| 난이도     | 시간  |
|---------|-----|
| Level 3 | 60분 |

```java
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
  }

  public int solution(int[] A, int[] B) {
    int answer = 0;

    Comparator<Integer> desc = (n1, n2) -> n2 - n1;
    PriorityQueue<Integer> teamA = convertToHeap(A, desc);
    PriorityQueue<Integer> teamB = convertToHeap(B, desc);

    while (bothTeamNotEmpty(teamA, teamB)) {
      int a = teamA.poll();
      int b = teamB.poll();

      if (a < b) answer++;
      else teamB.add(b);
    }

    return answer;
  }

  private boolean bothTeamNotEmpty(PriorityQueue<Integer> teamA, PriorityQueue<Integer> teamB) {
    return !teamA.isEmpty() && !teamB.isEmpty();
  }

  private PriorityQueue<Integer> convertToHeap(int[] team, Comparator<Integer> comparator) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(comparator);

    for (int num : team) {
      heap.add(num);
    }

    return heap;
  }
}
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="22278"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.78ms, 84.8MB)</td></tr><tr data-testcase-id="22279"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.63ms, 89.7MB)</td></tr><tr data-testcase-id="22280"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.95ms, 73.5MB)</td></tr><tr data-testcase-id="22281"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.90ms, 84MB)</td></tr><tr data-testcase-id="22282"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (1.33ms, 79.2MB)</td></tr><tr data-testcase-id="22283"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (1.42ms, 77.5MB)</td></tr><tr data-testcase-id="22284"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.02ms, 73.1MB)</td></tr><tr data-testcase-id="22285"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.94ms, 71.9MB)</td></tr><tr data-testcase-id="22286"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (2.45ms, 68MB)</td></tr><tr data-testcase-id="22287"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.96ms, 76.3MB)</td></tr><tr data-testcase-id="22288"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (2.48ms, 90MB)</td></tr><tr data-testcase-id="22289"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (2.11ms, 74.8MB)</td></tr><tr data-testcase-id="22290"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (9.41ms, 78.9MB)</td></tr><tr data-testcase-id="22291"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (13.53ms, 86.8MB)</td></tr><tr data-testcase-id="22292"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (11.96ms, 80.1MB)</td></tr><tr data-testcase-id="22293"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (15.45ms, 83.3MB)</td></tr><tr data-testcase-id="22294"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (3.72ms, 82.4MB)</td></tr><tr data-testcase-id="22295"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (3.47ms, 79.3MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="22296"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (122.65ms, 71.4MB)</td></tr><tr data-testcase-id="22297"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (107.04ms, 66.9MB)</td></tr><tr data-testcase-id="22298"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (112.14ms, 71.6MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 85.7</div><div class="console-message">효율성: 14.3</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>