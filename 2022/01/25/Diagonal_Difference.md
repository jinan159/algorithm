# Diagonal Difference
https://www.hackerrank.com/challenges/diagonal-difference/problem

기본적인 배열 인덱스 활용 문제입니다.

----

# 풀이

```java
public static int diagonalDifference(List<List<Integer>> arr) {
// Write your code here

    int len = arr.get(0).size();
    int[][] matrix = new int[len][len];

    for (int y=0; y<len; y++) {
        for (int x=0; x<len; x++) {
            List<Integer> row = arr.get(y);
            matrix[y][x] = row.get(x);
        }
    }

    int leftSum = getLeftSum(matrix);
    int rightSum = getRightSum(matrix);

    return Math.abs(leftSum - rightSum);
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/151096005-6e939201-6f38-4d27-bf51-02f0e8c7f81a.png)
