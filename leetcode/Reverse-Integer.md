# Reverse Integer
https://leetcode.com/problems/reverse-integer/

주어진 숫자x를 부호부분을 제외하고 숫자 부분만 뒤집는 문제 입니다.

이 문제의 키 포인트는 다음과 같습니다.

- 숫자 x의 범위와, 뒤집었을때 범위
- 100과 같은 숫자를 뒤집을 경우

----

# 풀이

```java
class Solution {
    
    public int reverse(int x) {
        if (x == 0) return 0;
        
        boolean isMinus = (x < 0);
        String numStr = String.valueOf(Math.abs(x));
        
        StringBuffer sb = new StringBuffer();
        sb.append(numStr);
        
        String result = sb.reverse().toString();
        
        try {
            result = String.valueOf(Integer.parseInt(result));
        } catch (Exception e) {
            return 0;
        }        
        
        if (isMinus) {
            result = "-" + result;
        }
        
        return Integer.parseInt(result);
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/149054887-2cde09f6-1d87-4296-b4a2-b2769de13db8.png)
