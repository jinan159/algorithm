# 위장
https://programmers.co.kr/learn/courses/30/lessons/42578?language=java#

<div class="markdown solarized-dark"><p>스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.</p>

<p>예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.</p>
<table class="table">
        <thead><tr>
<th>종류</th>
<th>이름</th>
</tr>
</thead>
        <tbody><tr>
<td>얼굴</td>
<td>동그란 안경, 검정 선글라스</td>
</tr>
<tr>
<td>상의</td>
<td>파란색 티셔츠</td>
</tr>
<tr>
<td>하의</td>
<td>청바지</td>
</tr>
<tr>
<td>겉옷</td>
<td>긴 코트</td>
</tr>
</tbody>
      </table>
<p>스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.</li>
<li>스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.</li>
<li>같은 이름을 가진 의상은 존재하지 않습니다.</li>
<li>clothes의 모든 원소는 문자열로 이루어져 있습니다.</li>
<li>모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.</li>
<li>스파이는 하루에 최소 한 개의 의상은 입습니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>clothes</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[["yellow<u>hat", "headgear"], ["blue</u>sunglasses", "eyewear"], ["green_turban", "headgear"]]</td>
<td>5</td>
</tr>
<tr>
<td>[["crow<u>mask", "face"], ["blue</u>sunglasses", "face"], ["smoky_makeup", "face"]]</td>
<td>3</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>예제 #1<br>
headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.</p>
<div class="highlight"><pre class="codehilite"><code>1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses
</code></pre></div>
<p>예제 #2<br>
face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.</p>
<div class="highlight"><pre class="codehilite"><code>1. crow_mask
2. blue_sunglasses
3. smoky_makeup
</code></pre></div>
<p><a href="http://2013.bapc.eu/" target="_blank" rel="noopener">출처</a></p>
</div>

----

# 풀이

```java
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            int count = clothMap.getOrDefault(type, 0);
            clothMap.put(type, count + 1);
        }
        
        for (String key : clothMap.keySet()) {
            int count = clothMap.get(key);
            answer = answer * (count + 1);
        }
        
        return answer - 1;
    }
}
```

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32828"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.06ms, 76.3MB)</td></tr><tr data-testcase-id="32829"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.05ms, 74.1MB)</td></tr><tr data-testcase-id="32830"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75.2MB)</td></tr><tr data-testcase-id="32831"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.07ms, 76.9MB)</td></tr><tr data-testcase-id="32832"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.07ms, 74.9MB)</td></tr><tr data-testcase-id="32833"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75.8MB)</td></tr><tr data-testcase-id="32834"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.13ms, 75.8MB)</td></tr><tr data-testcase-id="32835"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75.2MB)</td></tr><tr data-testcase-id="32836"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.05ms, 75.8MB)</td></tr><tr data-testcase-id="32837"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.05ms, 75.7MB)</td></tr><tr data-testcase-id="32838"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.04ms, 76.5MB)</td></tr><tr data-testcase-id="32839"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.07ms, 83.9MB)</td></tr><tr data-testcase-id="32840"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.07ms, 81.8MB)</td></tr><tr data-testcase-id="32841"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.06ms, 74MB)</td></tr><tr data-testcase-id="32842"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.04ms, 74.8MB)</td></tr><tr data-testcase-id="32843"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.05ms, 75.1MB)</td></tr><tr data-testcase-id="32844"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.08ms, 73.1MB)</td></tr><tr data-testcase-id="32845"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.05ms, 72MB)</td></tr><tr data-testcase-id="32846"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (0.04ms, 74.9MB)</td></tr><tr data-testcase-id="32847"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (0.07ms, 77MB)</td></tr><tr data-testcase-id="32848"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (0.05ms, 71.9MB)</td></tr><tr data-testcase-id="32849"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (0.05ms, 74.6MB)</td></tr><tr data-testcase-id="32850"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (0.06ms, 76.9MB)</td></tr><tr data-testcase-id="32851"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (0.04ms, 72.5MB)</td></tr><tr data-testcase-id="32852"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (0.06ms, 83.1MB)</td></tr><tr data-testcase-id="32853"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (0.07ms, 75.3MB)</td></tr><tr data-testcase-id="32854"><td valign="top" class="td-label">테스트 27 <span>〉</span></td><td class="result passed">통과 (0.06ms, 73.3MB)</td></tr><tr data-testcase-id="32855"><td valign="top" class="td-label">테스트 28 <span>〉</span></td><td class="result passed">통과 (0.06ms, 75.6MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
