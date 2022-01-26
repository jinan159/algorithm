# Save the Prisoner!
https://www.hackerrank.com/challenges/save-the-prisoner/problem

특정수로 나눈 나머지를 통해 간단하게 풀 수 있는 문제입니다.

----

# 풀이

```java
public static int saveThePrisoner(int n, int m, int s) {
// Write your code here
    int result = (m % n) + (s-1);

    if (result == 0) result = n;
    if (result > n) result = result % n;

    return result;
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/151096379-674a3c25-051b-4248-9533-8cb04995d8cc.png)
