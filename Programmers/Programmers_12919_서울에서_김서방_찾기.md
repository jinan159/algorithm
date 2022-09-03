# 서울에서 김서방 찾기
https://school.programmers.co.kr/learn/courses/30/lessons/12919

----

# 풀이

```python
def solution(seoul):
    for i in range(0, len(seoul)):
        if seoul[i] == 'Kim':
            return f'김서방은 {i}에 있다'

    return None
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16851"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16852"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16853"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16854"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16855"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16856"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="16857"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr><tr data-testcase-id="16858"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10MB)</td></tr><tr data-testcase-id="16859"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16860"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr><tr data-testcase-id="16861"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.4MB)</td></tr><tr data-testcase-id="16862"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16863"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="16864"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>