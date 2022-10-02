# 야근 지수

https://school.programmers.co.kr/learn/courses/30/lessons/12927

- 키 포인트
  - 피로도를 `최소화` 하는 로직 = 제일 큰 숫자들을 줄이기
  - 큰 순서대로 정렬

----

# 풀이

| 난이도     | 시간  |
|---------|-----|
| Level 3 | 30분 |

```python
def solution(n, works: list):
    if sum(works) <= n:
        return 0

    works.sort(reverse=True)
    
    work_cnt = 0
    
    while len(works) > 0 and work_cnt < n:
        max_num = works[0]
        for i in range(len(works)):
            if work_cnt == n:
                break
            
            if works[i] == max_num:
                works[i] -= 1
                work_cnt += 1
            else:
                break

    answer = [w ** 2 for w in works]

    return sum(answer)
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="23406"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="23407"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="23408"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="23409"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="23410"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="23411"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="23412"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="23413"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.46ms, 9.99MB)</td></tr><tr data-testcase-id="23414"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.38ms, 10.2MB)</td></tr><tr data-testcase-id="23415"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="23416"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="23417"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="23418"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.2MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="23419"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (145.21ms, 10.2MB)</td></tr><tr data-testcase-id="23420"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (127.91ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 86.7</div><div class="console-message">효율성: 13.3</div><div class="console-message">합계: 100.0 / 100.0</div></pre>