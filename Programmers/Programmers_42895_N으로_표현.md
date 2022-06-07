# N으로 표현
https://programmers.co.kr/learn/courses/30/lessons/42895?language=java

//문제 풀며 배운것과 느낀점
//관련 알고리즘 이론

----

# 풀이

```java
class Solution {

    private int minCount = Integer.MAX_VALUE;
    private int tenCount = 0;

    public int solution(int N, int number) {
        int answer = 0;

        int n = number;

        while(n > 0) {
            n = n / 10;
            tenCount++;
        }

        recursiveCalc(0, N, number, 0);

        if (minCount == Integer.MAX_VALUE) return -1;

        return minCount;
    }

    public void recursiveCalc(int nestedResult, int n, int number, int count) {
        if (count > 8) return;

        if (nestedResult == number) {
            if (count < minCount) {
                minCount = count;
            }
            return;
        }

        recursiveCalc(nestedResult + n, n, number, count+1);
        recursiveCalc(nestedResult - n, n, number, count+1);
        recursiveCalc(nestedResult / n, n, number, count+1);
        recursiveCalc(nestedResult * n, n, number, count+1);
        int nn = n;
        for (int i = 1; i < tenCount; i++) { // 111111
            nn = nn * 10 + n;
            recursiveCalc(nestedResult + nn, n, number, count+1+i);
            recursiveCalc(nestedResult - nn, n, number, count+1+i);
            recursiveCalc(nestedResult / nn, n, number, count+1+i);
            recursiveCalc(nestedResult * nn, n, number, count+1+i);
        }
    }
}
```

----

# 결과

<div class="console tab-content">
        <div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32880"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (13.35ms, 73.2MB)</td></tr><tr data-testcase-id="32881"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (20.47ms, 88.9MB)</td></tr><tr data-testcase-id="32882"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (15.00ms, 79.1MB)</td></tr><tr data-testcase-id="32883"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (30.69ms, 79.8MB)</td></tr><tr data-testcase-id="32884"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (21.20ms, 86.7MB)</td></tr><tr data-testcase-id="32885"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (13.12ms, 77.9MB)</td></tr><tr data-testcase-id="32886"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (13.18ms, 77.8MB)</td></tr><tr data-testcase-id="80745"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (20.20ms, 81.2MB)</td></tr><tr data-testcase-id="80746"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (1.25ms, 73.9MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
      </div>
