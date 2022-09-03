# 문자열 내림차순으로 배치하기
https://school.programmers.co.kr/learn/courses/30/lessons/12917

----

# 풀이

```python
def solution(s):
    l = list(s)
    l.sort(reverse=True)
    return ''.join(l)
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16816"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16817"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16818"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16819"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="16820"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.1MB)</td></tr><tr data-testcase-id="16821"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.2MB)</td></tr><tr data-testcase-id="16822"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16823"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16824"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16825"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16826"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16827"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16828"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16829"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16830"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16831"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>