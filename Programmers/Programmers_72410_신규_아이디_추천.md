# 신규 아이디 추천
https://programmers.co.kr/learn/courses/30/lessons/72410

레벨 1짜리 문제라서 단순 구현문제였다.

하지만 2단계의 특정 문자만 허용하는 검증작업을 정규식으로 처리하기위해 정규식을 다시 조금 공부했다.

도움이 많이 된 블로그를 아래 첨부한다.

- https://coding-factory.tistory.com/529

----

# 풀이

<details>
<summary>java 풀이</summary>

```java
class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^a-z0-9\\-_\\.]", "");

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (new_id.length() >= 2 && new_id.charAt(new_id.length()-1) == '.') {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.isEmpty()) new_id = "a";

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);

            if (new_id.charAt(new_id.length()-1) == '.') {
                new_id = new_id.substring(0, 14);
            }
        }

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while(new_id.length() <= 2) {
            new_id += new_id.substring(new_id.length()-1);            
        }
        
        answer = new_id;
        
        return answer;
    }
}
```

</details>

<details>
<summary>python3 풀이</summary>

```python
import re


def removeFirstDot(str):
    target_str = str

    if target_str.startswith('.'):
        target_str = str[1:]

    return target_str


def removeLastDot(str):
    target_str = str

    if target_str.endswith('.'):
        target_str = target_str[0:-1]

    return target_str


def solution(new_id):
    answer = ''

    # 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    new_id = new_id.lower()

    # 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    new_id = re.sub(r'[^a-zA-Z0-9\-_\.]', '', new_id)

    # 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    new_id = re.sub(r'[\.]{2,}', '.', new_id)

    # 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    new_id = removeFirstDot(new_id)
    new_id = removeLastDot(new_id)

    # 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.\
    if new_id == '':
        new_id = 'a'

    # 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    #    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    if len(new_id) >= 16:
        new_id = new_id[:15]
        new_id = removeLastDot(new_id)

    # 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    if len(new_id) <= 2:
        repeat_count = 3 - len(new_id)

        new_id = new_id + (new_id[-1:] * repeat_count)
    print(new_id)

    return new_id
```

</details>



----

# 결과

<details>
<summary>java 결과</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="88114"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.15ms, 75.3MB)</td></tr><tr data-testcase-id="88115"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (1.81ms, 73.8MB)</td></tr><tr data-testcase-id="88116"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (1.58ms, 75.4MB)</td></tr><tr data-testcase-id="88117"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.16ms, 76.5MB)</td></tr><tr data-testcase-id="88118"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.19ms, 71.5MB)</td></tr><tr data-testcase-id="88119"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.16ms, 68.6MB)</td></tr><tr data-testcase-id="88120"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.12ms, 77.3MB)</td></tr><tr data-testcase-id="88121"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.25ms, 73MB)</td></tr><tr data-testcase-id="88122"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (1.17ms, 69.1MB)</td></tr><tr data-testcase-id="88123"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.12ms, 76.2MB)</td></tr><tr data-testcase-id="88124"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.13ms, 73.9MB)</td></tr><tr data-testcase-id="88125"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.27ms, 71.9MB)</td></tr><tr data-testcase-id="88126"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (1.62ms, 83.2MB)</td></tr><tr data-testcase-id="88127"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.17ms, 77.6MB)</td></tr><tr data-testcase-id="88128"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.22ms, 74.2MB)</td></tr><tr data-testcase-id="88129"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.35ms, 73.2MB)</td></tr><tr data-testcase-id="88130"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.93ms, 72.4MB)</td></tr><tr data-testcase-id="88131"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (1.34ms, 75.3MB)</td></tr><tr data-testcase-id="88132"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (2.18ms, 78.5MB)</td></tr><tr data-testcase-id="88133"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (2.52ms, 76.3MB)</td></tr><tr data-testcase-id="88134"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (1.95ms, 77MB)</td></tr><tr data-testcase-id="88135"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (4.02ms, 73.8MB)</td></tr><tr data-testcase-id="88136"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (2.25ms, 74.4MB)</td></tr><tr data-testcase-id="88137"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (1.07ms, 75.8MB)</td></tr><tr data-testcase-id="88138"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (1.34ms, 74.7MB)</td></tr><tr data-testcase-id="88139"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (1.40ms, 77.3MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>

<details>
<summary>python3 결과</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="88114"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.3MB)</td></tr><tr data-testcase-id="88115"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.21ms, 10.5MB)</td></tr><tr data-testcase-id="88116"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.3MB)</td></tr><tr data-testcase-id="88117"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.15ms, 10.3MB)</td></tr><tr data-testcase-id="88118"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.23ms, 10.4MB)</td></tr><tr data-testcase-id="88119"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.18ms, 10.3MB)</td></tr><tr data-testcase-id="88120"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.23ms, 10.4MB)</td></tr><tr data-testcase-id="88121"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.19ms, 10.4MB)</td></tr><tr data-testcase-id="88122"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.22ms, 10.4MB)</td></tr><tr data-testcase-id="88123"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.25ms, 10.4MB)</td></tr><tr data-testcase-id="88124"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.22ms, 10.3MB)</td></tr><tr data-testcase-id="88125"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.17ms, 10.4MB)</td></tr><tr data-testcase-id="88126"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.3MB)</td></tr><tr data-testcase-id="88127"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.16ms, 10.4MB)</td></tr><tr data-testcase-id="88128"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.18ms, 10.4MB)</td></tr><tr data-testcase-id="88129"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.23ms, 10.3MB)</td></tr><tr data-testcase-id="88130"><td valign="top" class="td-label">테스트 17 <span>〉</span></td><td class="result passed">통과 (0.18ms, 10.3MB)</td></tr><tr data-testcase-id="88131"><td valign="top" class="td-label">테스트 18 <span>〉</span></td><td class="result passed">통과 (0.20ms, 10.3MB)</td></tr><tr data-testcase-id="88132"><td valign="top" class="td-label">테스트 19 <span>〉</span></td><td class="result passed">통과 (0.22ms, 10.4MB)</td></tr><tr data-testcase-id="88133"><td valign="top" class="td-label">테스트 20 <span>〉</span></td><td class="result passed">통과 (0.45ms, 10.3MB)</td></tr><tr data-testcase-id="88134"><td valign="top" class="td-label">테스트 21 <span>〉</span></td><td class="result passed">통과 (0.35ms, 10.3MB)</td></tr><tr data-testcase-id="88135"><td valign="top" class="td-label">테스트 22 <span>〉</span></td><td class="result passed">통과 (0.26ms, 10.4MB)</td></tr><tr data-testcase-id="88136"><td valign="top" class="td-label">테스트 23 <span>〉</span></td><td class="result passed">통과 (0.25ms, 10.5MB)</td></tr><tr data-testcase-id="88137"><td valign="top" class="td-label">테스트 24 <span>〉</span></td><td class="result passed">통과 (0.17ms, 10.3MB)</td></tr><tr data-testcase-id="88138"><td valign="top" class="td-label">테스트 25 <span>〉</span></td><td class="result passed">통과 (0.18ms, 10.4MB)</td></tr><tr data-testcase-id="88139"><td valign="top" class="td-label">테스트 26 <span>〉</span></td><td class="result passed">통과 (0.17ms, 10.3MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
