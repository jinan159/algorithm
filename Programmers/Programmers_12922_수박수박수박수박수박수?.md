# 수박수박수박수박수박수?
https://school.programmers.co.kr/learn/courses/30/lessons/12922

----

# 풀이

```python
def solution(n):
    answer = ''

    for i in range(n):
        answer += '수' if i % 2 == 0 else '박'

    return answer
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16867"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.10ms, 10.1MB)</td></tr><tr data-testcase-id="16868"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.69ms, 10.2MB)</td></tr><tr data-testcase-id="16869"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.28ms, 10.2MB)</td></tr><tr data-testcase-id="16870"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.77ms, 10.2MB)</td></tr><tr data-testcase-id="16871"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.39ms, 10.3MB)</td></tr><tr data-testcase-id="16872"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16873"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16874"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16875"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16876"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16877"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16878"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16879"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16880"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16881"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (1.39ms, 10.4MB)</td></tr><tr data-testcase-id="16882"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>