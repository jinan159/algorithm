# 비밀지도
https://programmers.co.kr/learn/courses/30/lessons/17681

이 문제의 핵심은 아래와 같다

- int를 binary로 치환
- 지정된 길이만큼 padleft

위 두개만 구현한다면, 사실 아주 쉽게 풀리는 문제이다.

python 에서 제공하는 간단한 기능
- bin() : 이진수로 변환
- zfill() : lpad 역할(왼쪽 0으로 채움)

----

# 풀이

<details>
<summary>java</summary>

```java
class Solution {
    
    private final String WALL = "#";
    private final String SPACE = " ";
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            
            int row1 = arr1[i];
            int row2 = arr2[i];
            
            String binary = Integer.toBinaryString(row1 | row2);
            
            answer[i] = makeSharpRow(binary, n);
        }
        
        return answer;
    }
    
    private String makeSharpRow(String binary, int n) {
        
        StringBuilder sb = new StringBuilder();
        
        String binaryRow = padLeftToZero(binary, n);
        
        for (int i=0; i<n; i++) {            
            if (binaryRow.charAt(i) == '0') {
                sb.append(SPACE);
            } else {
                sb.append(WALL);
            }
        }
        
        return sb.toString();
    }
    
    private String padLeftToZero(String source, int length) {
        int diff = length - source.length();
        
        StringBuffer sb = new StringBuffer();
        
        for (int i=0; i<diff; i++) {
            sb.append("0");
        }
        
        sb.append(source);
        
        return sb.toString();
    }
}
```

</details>

<details>
<summary>python3</summary>

```python
def to_bin_arr(arr1: list, length: int):
    return [bin(i).replace('0b','').zfill(length) for i in arr1]


def decrypt(arg1: str, arg2: str):
    if arg1 == '1' or arg2 == '1':
        return '#'

    return ' '


def solution(n: int, arr1: list, arr2: list):
    answer = []

    bin_arr1 = to_bin_arr(arr1, n)
    bin_arr2 = to_bin_arr(arr2, n)

    for i in range(n):
        row1 = bin_arr1[i]
        row2 = bin_arr2[i]
        new_row = ""

        for j in range(n):
            new_row += decrypt(row1[j], row2[j])

        answer.append(new_row)

    return answer
```

</details>

----

# 결과

<details>
<summary>java</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="30892"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.14ms, 74.2MB)</td></tr><tr data-testcase-id="30893"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.13ms, 78.4MB)</td></tr><tr data-testcase-id="30894"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.13ms, 77.9MB)</td></tr><tr data-testcase-id="30895"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.13ms, 71.6MB)</td></tr><tr data-testcase-id="30896"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.22ms, 73MB)</td></tr><tr data-testcase-id="30897"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.12ms, 76.4MB)</td></tr><tr data-testcase-id="30898"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.14ms, 74.2MB)</td></tr><tr data-testcase-id="30899"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.11ms, 77.9MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>

<details>
<summary>python3</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="30892"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10.3MB)</td></tr><tr data-testcase-id="30893"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.06ms, 10.1MB)</td></tr><tr data-testcase-id="30894"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.01ms, 10.2MB)</td></tr><tr data-testcase-id="30895"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.03ms, 10MB)</td></tr><tr data-testcase-id="30896"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.2MB)</td></tr><tr data-testcase-id="30897"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.04ms, 10.1MB)</td></tr><tr data-testcase-id="30898"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.02ms, 10.1MB)</td></tr><tr data-testcase-id="30899"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.02ms, 9.99MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
