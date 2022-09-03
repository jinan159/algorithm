# 두 정수 사이의 합
https://school.programmers.co.kr/learn/courses/30/lessons/12912

----

# 풀이

```python
def solution(a, b):
    answer = 0

    if a > b:
        a, b = b, a

    for i in range(a, b+1):
        answer += i

    return answer
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16697"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16698"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16699"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="16701"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (852.70ms, 10.1MB)</td></tr><tr data-testcase-id="16702"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (593.26ms, 10.3MB)</td></tr><tr data-testcase-id="16703"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (493.82ms, 10.3MB)</td></tr><tr data-testcase-id="16704"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (247.91ms, 10.3MB)</td></tr><tr data-testcase-id="16705"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (397.30ms, 10.2MB)</td></tr><tr data-testcase-id="16706"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (312.49ms, 10.3MB)</td></tr><tr data-testcase-id="16707"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (66.32ms, 10.3MB)</td></tr><tr data-testcase-id="16708"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.21ms, 10.3MB)</td></tr><tr data-testcase-id="16709"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.66ms, 10.2MB)</td></tr><tr data-testcase-id="16710"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.26ms, 10.3MB)</td></tr><tr data-testcase-id="16711"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16712"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.3MB)</td></tr><tr data-testcase-id="16713"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.13ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>