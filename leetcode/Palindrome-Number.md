# Palindrome Number
https://leetcode.com/problems/palindrome-number/

앞에서부터 읽었을 때(정방향)와 뒤에서부터 읽었을 때(역방향) 똑같이 읽히는 수 인지 확인하는 문제 입니다.

입력된 숫자를 Strin으로 변환하고, 정방향과 역방향을 비교하는 방식으로 구현했습니다.

----

### 추가

Follow up: Could you solve it without converting the integer to a string?

숫자를 문자로 변경하지 않고 Palindrome Number인지 확인하는 로직을 추가로 구현 해봤습니다.

각 자리수를 배열에 담고, 이를 앞과 뒤부터 비교하는 방식으로 구현하였습니다.

# 풀이

```java
// 추가 풀이
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        
        int[] temp = new int[10];
        int digit = x;
        int i;
        
        for (i=0; i<10; i++) {
            temp[i] = digit % 10;
            
            digit = digit / 10;
            
            if (digit < 10) {
                i++;
                temp[i] = digit;
                break;
            }
        }
        
        int[] nums = new int[i+1];
        
        for (i=0; i<nums.length; i++) {
            nums[i] = temp[i];
        }
        
        for (i=0; i<nums.length / 2; i++) {
            int back = nums.length - 1 - i;
            if (nums[i] != nums[back]) return false;
        }
        
        return true;
    }
}

// 기존 풀이
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        
        String num = String.valueOf(x);
        
        StringBuffer sb = new StringBuffer();
        sb.append(num);
        
        String reverse = sb.reverse().toString();
        
        return num.equals(reverse);
    }
}
```

----

# 결과
- 추가 풀이
![image](https://user-images.githubusercontent.com/45728407/149169995-55e6ee9a-245c-4ce7-b40d-8acfd4a5628f.png)

- 기존 풀이
![image](https://user-images.githubusercontent.com/45728407/149073637-61cdce93-7ae2-4213-aea6-b7030e5acd87.png)
