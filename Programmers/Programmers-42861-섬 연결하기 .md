# 섬 연결하기

https://school.programmers.co.kr/learn/courses/30/lessons/42861

- 키 포인트
  - 크루스칼 알고리즘
  - 유니온 파인드

----

# 풀이

| 난이도     | 시간    |
|---------|-------|
| Level 3 | 45+@분 |

```python
def get_parent(parent: list, num: int):
    if parent[num] == num:
        return num
    parent[num] = get_parent(parent, parent[num])
    return parent[num]


def union_parent(parent: list, num1: int, num2: int):
    num1_parent = get_parent(parent, num1)
    num2_parent = get_parent(parent, num2)

    if num1_parent < num2_parent:
        for i in range(len(parent)):
            if parent[i] == num2_parent:
                parent[i] = num1_parent
    else:
        for i in range(len(parent)):
            if parent[i] == num1_parent:
                parent[i] = num2_parent


def is_same_parent(parent: list, num1: int, num2: int):
    num1_parent = get_parent(parent, num1)
    num2_parent = get_parent(parent, num2)

    return num1_parent == num2_parent


def solution(n, costs):
    answer = 0
    parent = [i for i in range(n)]
    for node1, node2, cost in sorted(costs, key=lambda x: x[2]):
        if not is_same_parent(parent, node1, node2):
            answer += cost
            union_parent(parent, node1, node2)
    return answer
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32093"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="32094"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="32095"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="32096"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.2MB)</td></tr><tr data-testcase-id="32097"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="32098"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.1MB)</td></tr><tr data-testcase-id="32099"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.3MB)</td></tr><tr data-testcase-id="32100"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>