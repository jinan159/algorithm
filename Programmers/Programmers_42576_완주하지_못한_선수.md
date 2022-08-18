# 완주하지 못한 선수
https://programmers.co.kr/learn/courses/30/lessons/42576?language=java

<div class="markdown solarized-dark"><p>수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.</p>

<p>마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.</li>
<li>completion의 길이는 participant의 길이보다 1 작습니다.</li>
<li>참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.</li>
<li>참가자 중에는 동명이인이 있을 수 있습니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>participant</th>
<th>completion</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>["leo", "kiki", "eden"]</td>
<td>["eden", "kiki"]</td>
<td>"leo"</td>
</tr>
<tr>
<td>["marina", "josipa", "nikola", "vinko", "filipa"]</td>
<td>["josipa", "filipa", "marina", "nikola"]</td>
<td>"vinko"</td>
</tr>
<tr>
<td>["mislav", "stanko", "mislav", "ana"]</td>
<td>["stanko", "ana", "mislav"]</td>
<td>"mislav"</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>예제 #1<br>
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>

<p>예제 #2<br>
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.</p>

<p>예제 #3<br>
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.</p>

<p><a href="http://hsin.hr/coci/archive/2014_2015/contest2_tasks.pdf" target="_blank" rel="noopener">출처</a></p>
</div>

----
# 풀이

<details>
<summary>java</summary>

```java
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> completionMap = getCompletionMap(completion);
        
        answer = getUnfinishedParticipantName(completionMap, participant);
        
        return answer;
    }
    
    private HashMap<String, Integer> getCompletionMap(String[] completion) {
        HashMap<String, Integer> completionMap = new HashMap<>();
        
        if (completion != null) {
            for (String name : completion) {
                int count = completionMap.getOrDefault(name, 0);
                completionMap.put(name, count + 1);
            }
        }
        
        return completionMap;
    }
    
    private String getUnfinishedParticipantName(HashMap<String, Integer> completionMap, String[] participant) {
        
        String unfinishedParticipantName = null;
        
        for (String name : participant) {
            int count = completionMap.getOrDefault(name, 0);
            
            if (count == 0) {
                unfinishedParticipantName = name;
                break;
            }
            
            completionMap.put(name, count - 1);
        }
        
        return unfinishedParticipantName;
    }
}
```

</details>

<details>
<summary>python3</summary>

```python
def solution(participant: list, completion: list):

    participant_map = {}

    for p in participant:
        if p in participant_map.keys():
            count = participant_map[p]
            participant_map[p] = count + 1
        else:
            participant_map[p] = 1

    for c in completion:
        count = participant_map[c]
        participant_map[c] = count - 1

        if participant_map[c] == 0:
            participant_map.pop(c)

    print(participant_map)
    print(list(participant_map)[0])

    return list(participant_map)[0]
```

</details>

----

# 결과

<details>
<summary>java</summary>
<pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32794"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.03ms, 73.5MB)</td></tr><tr data-testcase-id="32795"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.05ms, 77.3MB)</td></tr><tr data-testcase-id="32796"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.33ms, 76.8MB)</td></tr><tr data-testcase-id="32797"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.53ms, 74.8MB)</td></tr><tr data-testcase-id="32798"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.52ms, 79.2MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="32786"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (27.10ms, 81.7MB)</td></tr><tr data-testcase-id="32787"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (56.52ms, 87.8MB)</td></tr><tr data-testcase-id="32788"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (48.76ms, 113MB)</td></tr><tr data-testcase-id="32789"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (50.20ms, 97MB)</td></tr><tr data-testcase-id="32790"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (87.42ms, 97.4MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 50.0</div><div class="console-message">효율성: 50.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre>
</details>

<details>
<summary>python3</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32794"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.02ms, 9.95MB)</td></tr><tr data-testcase-id="32795"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10MB)</td></tr><tr data-testcase-id="32796"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.22ms, 10MB)</td></tr><tr data-testcase-id="32797"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.43ms, 10.5MB)</td></tr><tr data-testcase-id="32798"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.45ms, 10.2MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="32786"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (26.93ms, 21.6MB)</td></tr><tr data-testcase-id="32787"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (43.08ms, 25.1MB)</td></tr><tr data-testcase-id="32788"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (67.86ms, 27.5MB)</td></tr><tr data-testcase-id="32789"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (67.60ms, 34MB)</td></tr><tr data-testcase-id="32790"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (63.05ms, 34MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 50.0</div><div class="console-message">효율성: 50.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
