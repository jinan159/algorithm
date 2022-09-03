# 가운데 글자 가져오
https://school.programmers.co.kr/learn/courses/30/lessons/12903

----

# 풀이

```python
def solution(s):
    length = len(s)
    
    end = int(length / 2) + 1
    start = end - 1;
    
    if length % 2 == 0:
        start -= 1
    
    return s[start:end]
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16656"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16657"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16658"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16659"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16660"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16661"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16662"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16663"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16664"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16665"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16666"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16667"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16668"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16669"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16670"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16671"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>