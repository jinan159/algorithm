# 이상한 문자 만들기
https://programmers.co.kr/learn/courses/30/lessons/12930

간단한 문제이지만, 공백은 그대로 유지한 상태에서 문자만 바꿔야 합니다.

----

# 풀이
<details>
<summary>java</summary>

```java
class Solution {
    public String solution(String s) {
        if (s.equals("")) return s;
        
        char[] chrArr = s.toCharArray();
        
        int index = 0;

        for (int i = 0; i < chrArr.length; i++) {
            char chr = chrArr[i];
            
            if (chr == ' ') {
                index = 0;
                continue;
            }
            
            if (index % 2 == 0) chrArr[i] = Character.toUpperCase(chr);
            else chrArr[i] = Character.toLowerCase(chr);
            
            index++;
        }
        
        return String.valueOf(chrArr);
    }
}
```
</details>

<details>
<summary>python</summary>

```python
def solution(s : str):
    str_list = []

    upper_flag = True

    for chr in s:
        if chr != ' ' and upper_flag:
            str_list.append(chr.upper())
            upper_flag = False
        else:
            str_list.append(chr.lower())
            upper_flag = True

    return ''.join(str_list)
```
</details>

----

# 결과
<details>
<summary>java</summary>

![image](https://user-images.githubusercontent.com/45728407/150055614-1152e11e-a7eb-407b-853f-4f4e932b6170.png)
</details>

<details>
<summary>python</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="16902"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16903"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10MB)</td></tr><tr data-testcase-id="16904"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10.1MB)</td></tr><tr data-testcase-id="16905"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="16906"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16907"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.00ms, 10MB)</td></tr><tr data-testcase-id="16908"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16909"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="16910"><td valign="top" class="td-label">테스트 9 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.3MB)</td></tr><tr data-testcase-id="16911"><td valign="top" class="td-label">테스트 10 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="16912"><td valign="top" class="td-label">테스트 11 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="16913"><td valign="top" class="td-label">테스트 12 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="16914"><td valign="top" class="td-label">테스트 13 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16915"><td valign="top" class="td-label">테스트 14 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="16916"><td valign="top" class="td-label">테스트 15 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.1MB)</td></tr><tr data-testcase-id="16917"><td valign="top" class="td-label">테스트 16 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
