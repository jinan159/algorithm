# 최댓값과 최솟값

https://school.programmers.co.kr/learn/courses/30/lessons/12939

----

# 풀이

```python
def solution(s: str):
    str_list = s.split(' ')
    int_list = [int(i) for i in str_list]
    
    max_num = max(int_list)
    min_num = min(int_list)
    
    return '{} {}'.format(min_num, max_num)
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="17185"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="17186"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.3MB)</td></tr><tr data-testcase-id="17187"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.4MB)</td></tr><tr data-testcase-id="17188"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.4MB)</td></tr><tr data-testcase-id="17190"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.4MB)</td></tr><tr data-testcase-id="17191"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="17192"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.3MB)</td></tr><tr data-testcase-id="17193"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.4MB)</td></tr><tr data-testcase-id="17194"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.4MB)</td></tr><tr data-testcase-id="17195"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.4MB)</td></tr><tr data-testcase-id="17196"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.4MB)</td></tr><tr data-testcase-id="17197"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.3MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>