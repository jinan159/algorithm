# 전화번호 목록
https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

<div class="markdown solarized-dark"><p>전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.<br>
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.</p>

<ul>
<li>구조대 : 119</li>
<li>박준영 : 97 674 223</li>
<li>지영석 : 11 9552 4421</li>
</ul>

<p>전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한 사항</h5>

<ul>
<li>phone_book의 길이는 1 이상 1,000,000 이하입니다.

<ul>
<li>각 전화번호의 길이는 1 이상 20 이하입니다.</li>
<li>같은 전화번호가 중복해서 들어있지 않습니다.</li>
</ul></li>
</ul>

<h5>입출력 예제</h5>
<table class="table">
        <thead><tr>
<th>phone_book</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>["119", "97674223", "1195524421"]</td>
<td>false</td>
</tr>
<tr>
<td>["123","456","789"]</td>
<td>true</td>
</tr>
<tr>
<td>["12","123","1235","567","88"]</td>
<td>false</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1<br>
앞에서 설명한 예와 같습니다.</p>

<p>입출력 예 #2<br>
한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.</p>

<p>입출력 예 #3<br>
첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.</p>

<hr>

<p><strong>알림</strong></p>

<p>2021년 3월 4일, 테스트 케이스가 변경되었습니다. 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.</p>

<p><a href="https://ncpc.idi.ntnu.no/ncpc2007/ncpc2007problems.pdf" target="_blank" rel="noopener">출처</a></p>
</div>

----
# 풀이

```java
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<String> phoneSet = new HashSet<>();
        HashSet<Integer> lengthSet = new HashSet<>();
        
        for (String number : phone_book) {
            phoneSet.add(number);
            lengthSet.add(number.length());
        }
        
        lengthSet.stream().sorted();
        
        for (String number : phone_book) {
            phoneSet.remove(number);
            
            for (int length : lengthSet) {
                if (length > number.length()) break;
                
                String tempNumber = number.substring(0, length);
                
                if (phoneSet.contains(tempNumber)) return false;
            }
            
            phoneSet.add(number);
        }
        
        return true;
    }
}
```

----
# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32818"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.32ms, 70.9MB)</td></tr><tr data-testcase-id="32819"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.33ms, 72.6MB)</td></tr><tr data-testcase-id="32820"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.47ms, 77.3MB)</td></tr><tr data-testcase-id="32821"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.50ms, 66.2MB)</td></tr><tr data-testcase-id="32822"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.34ms, 79.6MB)</td></tr><tr data-testcase-id="32823"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.53ms, 75MB)</td></tr><tr data-testcase-id="32824"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.33ms, 72.3MB)</td></tr><tr data-testcase-id="32825"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.33ms, 76MB)</td></tr><tr data-testcase-id="47902"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.27ms, 74.2MB)</td></tr><tr data-testcase-id="47903"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.31ms, 76MB)</td></tr><tr data-testcase-id="47904"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.30ms, 71.4MB)</td></tr><tr data-testcase-id="90340"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.30ms, 78.6MB)</td></tr><tr data-testcase-id="90341"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.29ms, 72MB)</td></tr><tr data-testcase-id="90342"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (3.25ms, 80MB)</td></tr><tr data-testcase-id="90343"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (3.84ms, 80.6MB)</td></tr><tr data-testcase-id="90344"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (2.05ms, 69.7MB)</td></tr><tr data-testcase-id="90345"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (2.08ms, 79MB)</td></tr><tr data-testcase-id="90346"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (3.84ms, 89.9MB)</td></tr><tr data-testcase-id="90347"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (2.20ms, 77.5MB)</td></tr><tr data-testcase-id="90348"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (4.94ms, 79.5MB)</td></tr></tbody></table><div class="console-message">효율성  테스트</div><table class="console-test-group" data-category="effectiveness"><tbody><tr data-testcase-id="33211"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (6.93ms, 57.3MB)</td></tr><tr data-testcase-id="33212"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (5.66ms, 56.4MB)</td></tr><tr data-testcase-id="90349"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (285.71ms, 110MB)</td></tr><tr data-testcase-id="90351"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (147.68ms, 117MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 83.3</div><div class="console-message">효율성: 16.7</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
