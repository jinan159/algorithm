# 가운데 글자 가져오
https://school.programmers.co.kr/learn/courses/30/lessons/12910

----

# 풀이

```python
def solution(arr, divisor):
    answer = []

    for num in arr:
        if num % divisor == 0:
            answer.append(num)

    if len(answer) == 0:
        answer.append(-1)

    answer.sort()

    return answer
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16676"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16677"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16678"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16679"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="16680"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16681"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (3.23ms, 13.4MB)</td></tr><tr data-testcase-id="16682"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.3MB)</td></tr><tr data-testcase-id="16683"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16684"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.11ms, 10.2MB)</td></tr><tr data-testcase-id="16685"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.08ms, 10.4MB)</td></tr><tr data-testcase-id="16686"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="16687"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="16688"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.25ms, 10.4MB)</td></tr><tr data-testcase-id="16690"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.10ms, 10.2MB)</td></tr><tr data-testcase-id="16691"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.09ms, 10.2MB)</td></tr><tr data-testcase-id="16692"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>