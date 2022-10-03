# 베스트앨범

https://school.programmers.co.kr/learn/courses/30/lessons/42579

- 키 포인트
  - 피로도를 `최소화` 하는 로직 = 제일 큰 숫자들을 줄이기
  - 큰 순서대로 정렬

----

# 풀이

| 난이도     | 시간      |
|---------|---------|
| Level 3 | 45분 + @ |

```python
def solution(genres, plays):
    answer = []

    genres_statistics = {}
    genres_songs = {}

    for i in range(len(genres)):
        genre, play = genres[i], plays[i]
        cnt = genres_statistics.get(genre, 0)
        genres_statistics[genre] = cnt + play

        songs = genres_songs.get(genre, [])
        songs.append([i, play])
        genres_songs[genre] = songs

    genres_statistics_array = []

    for genre in genres_statistics.keys():
        cnt = genres_statistics[genre]
        genres_statistics_array.append([genre, cnt])

    genres_statistics_array = sorted(genres_statistics_array, key=lambda x: x[1], reverse=True)

    for genre, cnt in genres_statistics_array:
        songs = sorted(genres_songs[genre], key=lambda x: x[1], reverse=True)

        if len(songs) > 1:
            answer += [songs[0][0], songs[1][0]]
        else:
            answer.append(songs[0][0])

    return answer
```

----

# 결과

<pre class="console-content"><div></div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32730"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="32731"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.3MB)</td></tr><tr data-testcase-id="32732"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="32733"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="33470"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.09ms, 10.1MB)</td></tr><tr data-testcase-id="33471"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.1MB)</td></tr><tr data-testcase-id="33472"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="33473"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="33474"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="33475"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.07ms, 10.2MB)</td></tr><tr data-testcase-id="33476"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="33477"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="33478"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.2MB)</td></tr><tr data-testcase-id="33479"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.11ms, 10.4MB)</td></tr><tr data-testcase-id="43663"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>