# 비밀지도
https://programmers.co.kr/learn/courses/30/lessons/17681

이 문제의 핵심은 아래와 같다

- int를 binary로 치환
- 지정된 길이만큼 padleft

위 두개만 구현한다면, 사실 아주 쉽게 풀리는 문제이다.

----

# 풀이

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

----

# 결과

<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="30892"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (0.14ms, 74.2MB)</td></tr><tr data-testcase-id="30893"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (0.13ms, 78.4MB)</td></tr><tr data-testcase-id="30894"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.13ms, 77.9MB)</td></tr><tr data-testcase-id="30895"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (0.13ms, 71.6MB)</td></tr><tr data-testcase-id="30896"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (0.22ms, 73MB)</td></tr><tr data-testcase-id="30897"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.12ms, 76.4MB)</td></tr><tr data-testcase-id="30898"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.14ms, 74.2MB)</td></tr><tr data-testcase-id="30899"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (0.11ms, 77.9MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
