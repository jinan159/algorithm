# 단속카메라

https://school.programmers.co.kr/learn/courses/30/lessons/42884

- 키 포인트
  - 진출 지점 기준으로 정렬

진짜 글쓴이 말대로 알고리즘 문제라는 느낌 보다는, IQ 테스트 문제같다....
허무함;;

https://school.programmers.co.kr/questions/27135

----

# 풀이

| 난이도     | 시간      |
|---------|---------|
| Level 3 | 45분 + @ |

```python
def solution(routes: list):
    answer = 0
    routes = sorted(routes, key=lambda x: x[1])
    camera = -30001
    for start, end in routes:
        if camera < start:
            answer += 1
            camera = end
    return answer
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33465"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="33466"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="33467"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="33468"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="33469"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="33459"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.33ms, 10.4MB)</td></tr><tr data-testcase-id="33460"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.23ms, 10.3MB)</td></tr><tr data-testcase-id="33461"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.80ms, 10.4MB)</td></tr><tr data-testcase-id="33462"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="33463"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.93ms, 10.6MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 50.0</div><div class="console-message">효율성: 50.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>