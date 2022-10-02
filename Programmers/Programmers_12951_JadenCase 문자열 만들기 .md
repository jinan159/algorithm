# JadenCase 문자열 만들기

https://school.programmers.co.kr/learn/courses/30/lessons/12951

----

# 풀이

```python
def solution(s: str):
    str_list = s.split(' ')

    for i in range(len(str_list)):
        word = str_list[i].lower()
        str_list[i] = word
        if word != '' and word[0].isalpha():
            str_list[i] = word[0].upper()
            if len(word) > 1:
                str_list[i] += word[1:]

    return ' '.join(str_list)
```

----

# 결과

<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="18851"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18852"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18854"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18855"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="18856"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.4MB)</td></tr><tr data-testcase-id="18857"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18858"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="18859"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18860"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18861"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="18862"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18863"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18864"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18865"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="18866"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="29281"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="121300"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="121301"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>