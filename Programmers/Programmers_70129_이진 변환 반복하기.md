# 이진 변환 반복하기

https://school.programmers.co.kr/learn/courses/30/lessons/70129

----

# 풀이

```python
def solution(s: str):
    convert_cnt = 0
    removed_zero_cnt = 0

    while s != '1':
        convert_cnt += 1
        removed_zero_cnt += s.count('0')
        s = bin(len(s.replace('0', '')))[2:]

    return [convert_cnt, removed_zero_cnt]
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="84781"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="84782"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (1.34ms, 10.3MB)</td></tr><tr data-testcase-id="84783"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="84784"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="84785"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="84786"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="84787"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="84788"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="84789"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.42ms, 10.2MB)</td></tr><tr data-testcase-id="84790"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.97ms, 10.3MB)</td></tr><tr data-testcase-id="84791"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (1.32ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>