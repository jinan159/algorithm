# Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/

문자열 앞부터 시작하여, 배열의 모든 문자열이 공통으로 가지고 있는 문자열을 찾는 문제 입니다.

로직은 단순하지만, 바로 반환할 수 있는 경우의 수를 생각하여 최대한 효율성을 높이려고 노력했습니다.

----

# 풀이

```java
class Solution {
    
    private final String EMPTY = "";
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return EMPTY;
        if (strs.length == 1) return strs[0];
        
        String prefix = strs[0];
        
        for (int i=1; i<strs.length; i++) {
            String target = strs[i];
            
            if (prefix.length() > 0 &&
                target.length() > 0 &&
                (prefix.charAt(0) != target.charAt(0))) return EMPTY;
            
            prefix = getCommonPrefix(prefix, target);
        }
        
        return prefix;
    }
    
    private String getCommonPrefix(String prefix, String str) {
        
        StringBuffer sb = new StringBuffer();
        
        char[] prefixArr = prefix.toCharArray();
        char[] strArr = str.toCharArray();
        
        for (int i=0; i<prefixArr.length; i++) {
            if (i >= strArr.length) break;
            
            if (prefixArr[i] == strArr[i]) sb.append(prefixArr[i]);
            if (prefixArr[i] != strArr[i]) break;
        }
        
        return sb.toString();
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/149127121-cc6c0cdb-3acf-4647-93d1-4a8d35421526.png)
