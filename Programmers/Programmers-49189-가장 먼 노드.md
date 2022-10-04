# 가장 먼 노드

https://school.programmers.co.kr/learn/courses/30/lessons/49189

- 키 포인트
  - BFS


----

# 풀이

| 난이도     | 시간  |
|---------|-----|
| Level 3 | 20분 |

```python
from collections import deque


def solution(n, edge):
    answer = 0

    node_map = {node_no: [] for node_no in range(1, n+1)}

    for node_no, connected_node in edge:
        node_map[node_no].append(connected_node)
        node_map[connected_node].append(node_no)

    visited = [False] * (n + 1)
    distances = [0] * (n + 1)

    q = deque()

    q.append(1)
    visited[1] = True

    while q:
        node_no = q.popleft()

        for connected in node_map[node_no]:
            if visited[connected]:
                continue
            q.append(connected)
            visited[connected] = True
            distances[connected] = distances[node_no] + 1

    return distances.count(max(distances))
```

----

# 결과

<pre class="console-content"><div></div><div class="console-failed">같은 코드로 채점한 결과가 있습니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32888"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="32889"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="32890"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.1MB)</td></tr><tr data-testcase-id="32891"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.17ms, 10.1MB)</td></tr><tr data-testcase-id="32892"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.69ms, 10.4MB)</td></tr><tr data-testcase-id="32893"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (3.40ms, 10.9MB)</td></tr><tr data-testcase-id="32894"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (22.49ms, 17.8MB)</td></tr><tr data-testcase-id="32895"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (53.06ms, 21.6MB)</td></tr><tr data-testcase-id="32896"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (29.80ms, 21.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>