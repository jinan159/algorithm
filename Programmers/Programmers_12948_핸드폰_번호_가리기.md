# 핸드폰 번호 가리기
https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=python3

----

# 풀이

```python
def solution(phone_number : str):
    star_length = (len(phone_number) - 4)
    masked = '*' * star_length
    return masked + phone_number[-4:]
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="17245"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="17246"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="17247"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10MB)</td></tr><tr data-testcase-id="17248"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="17249"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="17250"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="17251"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="17252"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="17253"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.00ms, 9.96MB)</td></tr><tr data-testcase-id="17254"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="17255"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="17256"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="18843"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.00ms, 9.95MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>