# 문자열 내 마음대로 정렬하기
https://school.programmers.co.kr/learn/courses/30/lessons/12915?language=python3

----

# 풀이

```python
def solution(strings, n):
    return sorted(strings, key=lambda s: (s[n], s))
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16813"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="18929"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18930"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="18931"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18932"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="18933"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18934"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18935"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="18936"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18937"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18938"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="18939"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>