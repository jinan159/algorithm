# 기능개발
https://programmers.co.kr/learn/courses/30/lessons/42586?language=java#

<div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.</p>

<p>또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.</p>

<p>먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.</p>

<h5>제한 사항</h5>

<ul>
<li>작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.</li>
<li>작업 진도는 100 미만의 자연수입니다.</li>
<li>작업 속도는 100 이하의 자연수입니다.</li>
<li>배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>progresses</th>
<th>speeds</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[93, 30, 55]</td>
<td>[1, 30, 5]</td>
<td>[2, 1]</td>
</tr>
<tr>
<td>[95, 90, 99, 99, 80, 99]</td>
<td>[1, 1, 1, 1, 1, 1]</td>
<td>[1, 3, 2]</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.<br>
두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.<br>
세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다. </p>

<p>따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.</p>

<p>입출력 예 #2<br>
모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.</p>

<p>따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.</p>

<p>※ 공지 - 2020년 7월 14일 테스트케이스가 추가되었습니다.</p>
</div>
    </div>

----

# 풀이

<details>
<summary>java</summary>

```java
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];
        
        Queue<Integer> progressRemainDays = new LinkedList<Integer>();
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int i=0; i<progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            
            int remainDays = (int)((100 - progress) / speed);
            if ((100 - progress) % speed > 0) {
                remainDays += 1;
            }
            
            progressRemainDays.offer(remainDays);
        }

        int peekDays = progressRemainDays.poll();
        int count = 1;
        int deployedDate = 0;
        
        answer[deployedDate] = count;
        
        while (!progressRemainDays.isEmpty()) {
            
            int curDays = progressRemainDays.poll();
            
            if (peekDays < curDays) {
                deployedDate += 1;
                peekDays = curDays;
            }
            
            answer[deployedDate] += 1;
        }
        
        return Arrays.stream(answer).filter(num -> num > 0).toArray();
    }
}
```
</details>

<details>
<summary>python</summary>

```python
def solution(progresses : list, speeds : list):
    answer = []

    while len(progresses) > 0:
        cnt = 0
        for i in range(len(progresses)):
            progresses[i] += speeds[i]

        if progresses[0] >= 100:
            while len(progresses) > 0 and progresses[0] >= 100:
                progresses.pop(0)
                speeds.pop(0)
                cnt += 1
            answer.append(cnt)

    print(answer)

    return answer
```
</details>
----

# 결과
<details>
<summary>java</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32686"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (2.04ms, 77.8MB)</td></tr><tr data-testcase-id="32687"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (2.02ms, 75.8MB)</td></tr><tr data-testcase-id="33176"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (2.42ms, 76.6MB)</td></tr><tr data-testcase-id="33177"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (4.74ms, 79MB)</td></tr><tr data-testcase-id="33178"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (2.91ms, 77.8MB)</td></tr><tr data-testcase-id="33179"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (2.35ms, 78.8MB)</td></tr><tr data-testcase-id="33180"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (2.15ms, 79.3MB)</td></tr><tr data-testcase-id="33181"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (2.31ms, 73.8MB)</td></tr><tr data-testcase-id="33182"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (2.13ms, 76.9MB)</td></tr><tr data-testcase-id="33183"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (1.99ms, 74.3MB)</td></tr><tr data-testcase-id="77620"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (1.94ms, 77.5MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>

<details>
<summary>python</summary>
<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32686"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="32687"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.32ms, 10.2MB)</td></tr><tr data-testcase-id="33176"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.42ms, 10.2MB)</td></tr><tr data-testcase-id="33177"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.2MB)</td></tr><tr data-testcase-id="33178"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.3MB)</td></tr><tr data-testcase-id="33179"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.2MB)</td></tr><tr data-testcase-id="33180"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.38ms, 10.3MB)</td></tr><tr data-testcase-id="33181"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.05ms, 10.3MB)</td></tr><tr data-testcase-id="33182"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.28ms, 10.2MB)</td></tr><tr data-testcase-id="33183"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.30ms, 10.2MB)</td></tr><tr data-testcase-id="77620"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>
</details>

