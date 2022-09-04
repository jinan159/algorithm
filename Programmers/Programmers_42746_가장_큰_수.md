# 가장 큰 수
https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=python3

----

# 풀이

```python
from functools import cmp_to_key


def compare(str1: str, str2: str):
    join1 = str1 + str2
    join2 = str2 + str1

    if join1 < join2:
        return 1
    elif join2 < join1:
        return -1

    return 0


def solution(numbers: list):
    mapped_numbers = map(str, numbers)
    str_numbers = list(mapped_numbers)

    str_numbers = sorted(str_numbers, key=cmp_to_key(compare))

    while str_numbers[0] == '0' and len(str_numbers) > 1:
        str_numbers.pop(0)

    return ''.join(str_numbers)
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33215"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (254.18ms, 21.1MB)</td></tr><tr data-testcase-id="33216"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (126.88ms, 16.1MB)</td></tr><tr data-testcase-id="33217"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (318.47ms, 24.6MB)</td></tr><tr data-testcase-id="33218"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (4.48ms, 10.2MB)</td></tr><tr data-testcase-id="33219"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (228.98ms, 20MB)</td></tr><tr data-testcase-id="33220"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (180.25ms, 18.6MB)</td></tr><tr data-testcase-id="33221"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="33222"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="33223"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.1MB)</td></tr><tr data-testcase-id="33224"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="33225"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.04ms, 9.97MB)</td></tr><tr data-testcase-id="113730"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="113731"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="113732"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="113733"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>