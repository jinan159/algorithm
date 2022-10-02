# 최고의 집합

https://school.programmers.co.kr/learn/courses/30/lessons/12938

키 포인트
- 규칙 찾기

----

# 풀이

|    난이도    |  시간   |
|:---------:|:-----:|
|  Level 3  |  27분  |

```python
from heapq import heappush


def solution(n, s):
    answer = []

    if s < n:
        return [-1]
    elif s % n == 0:
        return [s / n] * n
    else:
        while n > 0:
            value = s // n
            heappush(answer, value)
            s -= value
            n -= 1

        return answer
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="18243"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.37ms, 10.2MB)</td></tr><tr data-testcase-id="18244"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.66ms, 10.5MB)</td></tr><tr data-testcase-id="18245"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.63ms, 10.5MB)</td></tr><tr data-testcase-id="18246"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.58ms, 10.6MB)</td></tr><tr data-testcase-id="18247"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.09ms, 10.2MB)</td></tr><tr data-testcase-id="18248"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.32ms, 10.4MB)</td></tr><tr data-testcase-id="18249"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.08ms, 10.2MB)</td></tr><tr data-testcase-id="18250"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.15ms, 10.2MB)</td></tr><tr data-testcase-id="18251"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.37ms, 10.3MB)</td></tr><tr data-testcase-id="18252"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.66ms, 10.5MB)</td></tr><tr data-testcase-id="18253"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.63ms, 10.4MB)</td></tr><tr data-testcase-id="18254"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.44ms, 10.2MB)</td></tr><tr data-testcase-id="18255"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.75ms, 10.5MB)</td></tr><tr data-testcase-id="18256"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="18257"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.74ms, 10.5MB)</td></tr><tr data-testcase-id="18258"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.93ms, 10.6MB)</td></tr><tr data-testcase-id="18259"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (1.02ms, 10.5MB)</td></tr><tr data-testcase-id="18260"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (1.08ms, 10.8MB)</td></tr><tr data-testcase-id="18261"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (2.47ms, 11.2MB)</td></tr><tr data-testcase-id="18262"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 70.0</div><div class="console-message">효율성: 30.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>