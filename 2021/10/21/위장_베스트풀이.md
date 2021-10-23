# 위장
https://programmers.co.kr/learn/courses/30/lessons/42578?language=java#

`위장` 문제에서 가장 좋아요를 많이 받은 풀이인데, Java의 Stream을 극한으로(?) 활용하여 문제를 풀었다.

아직 Stream을 제대로 알지 못하지만, 이 코드만 어느정도 분석해도 스트림 공부가 될 것 같다.

이 기회에 Java8에서 제공하는 기능들도 하나씩 공부를 해봐야겠다.

(그런데 효율성은 내가 작성한 로직이 더 효율적인것 같다.. [링크](https://github.com/jinan159/programmers-algorithm/blob/main/2021.10.21/%EC%9C%84%EC%9E%A5.md#%EA%B2%B0%EA%B3%BC))

```java
import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
    }
}
```

---

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32828"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (8.99ms, 74.1MB)</td></tr><tr data-testcase-id="32829"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (6.16ms, 82.1MB)</td></tr><tr data-testcase-id="32830"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (5.73ms, 78.2MB)</td></tr><tr data-testcase-id="32831"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (7.88ms, 78.6MB)</td></tr><tr data-testcase-id="32832"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (7.47ms, 75.2MB)</td></tr><tr data-testcase-id="32833"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (5.73ms, 73.5MB)</td></tr><tr data-testcase-id="32834"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (5.71ms, 77.1MB)</td></tr><tr data-testcase-id="32835"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (5.58ms, 74.4MB)</td></tr><tr data-testcase-id="32836"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (6.03ms, 71.6MB)</td></tr><tr data-testcase-id="32837"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (5.68ms, 76.4MB)</td></tr><tr data-testcase-id="32838"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (7.73ms, 73.5MB)</td></tr><tr data-testcase-id="32839"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (5.52ms, 76.9MB)</td></tr><tr data-testcase-id="32840"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (6.78ms, 75MB)</td></tr><tr data-testcase-id="32841"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (5.77ms, 75.5MB)</td></tr><tr data-testcase-id="32842"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (5.46ms, 80.9MB)</td></tr><tr data-testcase-id="32843"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (6.03ms, 77MB)</td></tr><tr data-testcase-id="32844"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (5.63ms, 73.9MB)</td></tr><tr data-testcase-id="32845"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (5.58ms, 77.8MB)</td></tr><tr data-testcase-id="32846"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (5.75ms, 77.2MB)</td></tr><tr data-testcase-id="32847"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (6.83ms, 73.8MB)</td></tr><tr data-testcase-id="32848"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (6.81ms, 79.5MB)</td></tr><tr data-testcase-id="32849"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (5.30ms, 73.4MB)</td></tr><tr data-testcase-id="32850"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (5.58ms, 72.3MB)</td></tr><tr data-testcase-id="32851"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (6.47ms, 76.7MB)</td></tr><tr data-testcase-id="32852"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (7.58ms, 76.8MB)</td></tr><tr data-testcase-id="32853"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (8.42ms, 78.3MB)</td></tr><tr data-testcase-id="32854"><td valign="top" class="td-label">테스트 27 <span>〉</span></td><td class="result passed">통과 (7.84ms, 73.9MB)</td></tr><tr data-testcase-id="32855"><td valign="top" class="td-label">테스트 28 <span>〉</span></td><td class="result passed">통과 (8.05ms, 78.9MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
