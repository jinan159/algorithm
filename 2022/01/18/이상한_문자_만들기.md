# 이상한 문자 만들기
https://programmers.co.kr/learn/courses/30/lessons/12930

간단한 문제이지만, 공백은 그대로 유지한 상태에서 문자만 바꿔야 합니다.

----

# 풀이

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

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/150055614-1152e11e-a7eb-407b-853f-4f4e932b6170.png)