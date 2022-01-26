# Number Line Jumps
https://www.hackerrank.com/challenges/kangaroo/problem

증가하는 두 수가 만나는 지점을 반환하는 문제입니다.

더 앞선 지점에서 시작하는 `x2`가 `x1`보다 더 작은 거리를 가야만 만날 가능성이 있기 때문에,
미리 확인하여 값을 반환하도록 최대한 효율적으로 구현하였습니다.

----

# 풀이

```java
private static final String NO = "NO";
private static final String YES = "YES";

public static String kangaroo(int x1, int v1, int x2, int v2) {
// Write your code here
    if (v1 <= v2) return NO;

    int kang1 = x1;
    int kang2 = x2;

    while(kang1 < kang2) {
        kang1 += v1;
        kang2 += v2;
    }

    if (kang1 != kang2) return NO;

    return YES;
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/151096210-eca6a9b3-6986-4199-9447-2df260beb9ae.png)
