# 단어 변환

https://school.programmers.co.kr/learn/courses/30/lessons/43163

- 키 포인트

----

# 풀이

| 난이도     | 시간      |
|---------|---------|
| Level 3 | 45분 + @ |

```python
def get_one_char_diffs(target: str, words: list):
    diffs = set()

    for word in words:
        diff_cnt = 0
        for t_char, w_char in zip(target, word):
            if t_char != w_char:
                diff_cnt += 1
            if diff_cnt > 1:
                break
        if diff_cnt == 1:
            diffs.add(word)

    return diffs


def solution(begin: str, target: str, words: list):
    if target not in words:
        return 0

    one_diffs = {}

    for w in words:
        one_diffs[w] = get_one_char_diffs(w, words)
    one_diffs[begin] = get_one_char_diffs(begin, words)

    res = float('inf')

    def dfs(word: str, level: int, visited: set):
        if word == target:
            nonlocal res
            res = min(res, level)
            return

        diffs = one_diffs[word]

        for d_word in diffs:
            if d_word not in visited:
                visited.add(d_word)
                dfs(d_word, level + 1, visited)
                visited.remove(d_word)

    dfs(begin, 0, set())

    return res
```

----

# 결과

<pre class="console-content"><div></div><div class="console-failed">같은 코드로 채점한 결과가 있습니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="33156"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10MB)</td></tr><tr data-testcase-id="33157"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.85ms, 10.2MB)</td></tr><tr data-testcase-id="33158"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.85ms, 10.2MB)</td></tr><tr data-testcase-id="33159"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.3MB)</td></tr><tr data-testcase-id="33160"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.3MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>