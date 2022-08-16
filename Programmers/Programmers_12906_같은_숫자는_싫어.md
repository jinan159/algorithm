# 같은 숫자는 싫어
https://school.programmers.co.kr/learn/courses/30/lessons/12906

아주 간단한 문제.
파이썬 연습용

----

# 풀이

```python
def solution(arr):
    answer = []

    prev = -1

    for num in arr:
        if num != prev:
            answer.append(num)

        prev = num

    return answer
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="7077"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="7078"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="7079"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10MB)</td></tr><tr data-testcase-id="7080"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7081"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7082"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="7083"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7084"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7085"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="7086"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7087"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7088"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7089"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="7090"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7091"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7092"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="7093"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="7098"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (47.58ms, 27.9MB)</td></tr><tr data-testcase-id="7099"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (44.88ms, 27.7MB)</td></tr><tr data-testcase-id="7100"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (41.29ms, 27.8MB)</td></tr><tr data-testcase-id="7101"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (42.50ms, 27.8MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 71.9</div><div class="console-message">효율성: 28.1</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>