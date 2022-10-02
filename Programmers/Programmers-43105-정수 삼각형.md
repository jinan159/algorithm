# 정수 삼각형

https://school.programmers.co.kr/learn/courses/30/lessons/43105

키 포인트
- 맨 아래에서 부터 합을 계산하기
- DP 를 이용해서 최대 합을 미리 구해놓기

----

# 풀이

```python
from typing import List


def recursive(triangle: List[List[int]], dp: List[List[int]], level: int, index: int):
    if dp[level][index] != -1:
        return dp[level][index]

    if level == len(triangle) - 1:
        dp[level][index] = triangle[level][index]
        return triangle[level][index]

    if level < len(triangle):
        nested_sum = triangle[level][index] + max(recursive(triangle, dp, level + 1, index), recursive(triangle, dp, level + 1, index + 1))
        dp[level][index] = nested_sum if dp[level][index] < nested_sum else dp[level][index]
        return dp[level][index]


def solution(triangle: List[List[int]]):
    dp = [[-1 for x in range(len(triangle[y]))] for y in range(len(triangle))]

    return recursive(triangle, dp, 0, 0)
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="30294"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.5MB)</td></tr><tr data-testcase-id="30295"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.6MB)</td></tr><tr data-testcase-id="30296"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.10ms, 10.5MB)</td></tr><tr data-testcase-id="30297"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.33ms, 10.4MB)</td></tr><tr data-testcase-id="33493"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (2.29ms, 11MB)</td></tr><tr data-testcase-id="33494"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.66ms, 10.7MB)</td></tr><tr data-testcase-id="33495"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (4.52ms, 10.6MB)</td></tr><tr data-testcase-id="33496"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.53ms, 10.4MB)</td></tr><tr data-testcase-id="33497"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.5MB)</td></tr><tr data-testcase-id="33498"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.32ms, 10.5MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="33483"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (80.59ms, 18.5MB)</td></tr><tr data-testcase-id="33484"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (57.12ms, 16.4MB)</td></tr><tr data-testcase-id="33485"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (89.78ms, 19.6MB)</td></tr><tr data-testcase-id="33486"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (75.04ms, 18.4MB)</td></tr><tr data-testcase-id="33487"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (74.61ms, 17.8MB)</td></tr><tr data-testcase-id="33488"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (88.32ms, 20MB)</td></tr><tr data-testcase-id="33489"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (79.78ms, 19.1MB)</td></tr><tr data-testcase-id="33490"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (70.73ms, 17.5MB)</td></tr><tr data-testcase-id="33491"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (71.38ms, 18MB)</td></tr><tr data-testcase-id="33492"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (82.45ms, 19.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 64.3</div><div class="console-message">효율성: 35.7</div><div class="console-message">합계: 100.0 / 100.0</div></pre>