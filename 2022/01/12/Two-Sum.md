# Two Sum
https://leetcode.com/problems/two-sum/

완전탐색을 통해 답을 도출하는 간단한 문제 입니다.

----

# 풀이

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] answer = new int[2];
        
        for (int i=0; i< nums.length-1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                
                int sum = nums[i] + nums[j];
                
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                    i = nums.length;
                    break;
                }
            }
        }
        
        return answer;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/149053881-cd91c1ca-170b-4cad-86b3-a06bf4d69275.png)
