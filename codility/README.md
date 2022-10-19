# Exercise

`Medium` 이하 난이도만 풀이하자..(나중에 시간 남으면 Hard 도전)

## Exercise 1 : 2015 Contest

### `LongestPassword`

이 문제는 내가 문제를 너무 대충 보고 풀어서, 삽질하면서 시간을 많이 썼음<br>
-1 을 반환하라는걸 못보다니...;;<br>
그리고 이 플랫폼은 테스트 케이스 제공 안해서, 내가 테스트 잘 해야겠더라..

### `FloodDepth`

이 문제는 규칙을 못찾아서 못풀었음...<br>
배열 최대 크기가 100,000 이라서 `O(N^2)` 미만의 시간복잡도가 되야겠다 생각함.<br>
그래서 좀 삽질을 많이한 것 같음...<br>

사실 시간복잡도 제한만 아니면, 현재기준 왼쪽 오른쪽으로 쭉 가면서<br>
왼쪽 최대값, 오른쪽 최대값 구하고 최소 깊이 구하는 방식으로 할거같은데<br>
이거는 거의 O(N^2) 이나 다름없는 방법이라 바로 버림..

결국 계속 고민만 하다가 시간 제한이
끝났고, [java 풀이](https://bojanv55.wordpress.com/2020/01/26/codility-flooddepth-java-100/) 를 참고하고
말았다..<br>

내가 못찾았던 **규칙성**은 다음과 같다.

-

최고 높이 <= 최고 높이 - 최저 높이

|  난이도   |       문제        |   풀이시간   |      내 점수      |
|:------:|:---------------:|:--------:|:--------------:|
|  Easy  | LongestPassword |   60분    |    100/100     |
| Medium |   FloodDepth    | 120분 + @ | 0/100, 100/100 |

# Lesson

- 제출 전 확인할 것
    - `정확도` 가 최우선, 그 다음이 `시간복잡도`
        - 일단 문제 해결하면서 병목이 되는 부분에 주석 남겨두기
    - `정확도`
        - 경계값 테스트
        - 입력값에 중복 요소 가능한지
    - `시간복잡도`
        - 시간복잡도에 N^2 요소가 있는지 확인
            - 하지만, 여기에 너무 많은 시간을 소비하지는 말것
            - 시간 복잡도를 줄이는 로직의 정확성을 확실히 테스트 할 것
        - 큰 공간을 생성(초기화)하는 작업 자체도 큰 오버헤드임

## Lesson 5 : Prefix Sums

|  난이도   |                                       문제                                       |  풀이시간   |       내 점수       |
|:------:|:------------------------------------------------------------------------------:|:-------:|:----------------:|
|  Easy  |    [PassingCars](https://app.codility.com/demo/results/trainingT42BRZ-J9X/)    |   22분   |     100/100      |
| Medium |     [CountDiv](https://app.codility.com/demo/results/training7JRJXH-QXN/)      |   33분   |     100/100      |
| Medium | [GenomicRangeQuery](https://app.codility.com/demo/results/trainingWPCP9B-9RN/) | 37분 + @ | 62/100 + 100/100 |
| Medium |  [MinAvgTwoSlice](https://app.codility.com/demo/results/trainingHYPT57-TM3/)   | 27분 + @ | 20/100 + 100/100 |

### GenomicRangeQuery

- 첫 번째 풀이 : https://app.codility.com/demo/results/trainingWPCP9B-9RN/
- 두 번째 풀이 : https://app.codility.com/demo/results/trainingAJS2CE-8NE/

첫 번째 풀이의 시간복잡도는 O(N * M), 두 번째 풀이는 O(N + M) 이다.<br>
DP 를 활용해서 매 순간마다 특정 항목이 있는지 확인하는 반복문을 돌지 않고,<br>
합계의 차이를 이용해서 특정 항목이 있는지 여부를 확인한다.<br>

```text
A=0, C=1, G=2, T=3

"CGTACCT"

합계
[
  [0,1,0,0], // 0
  [0,1,1,0], // 1
  [0,1,1,1], // 2
  [1,1,1,1], // 3
  [1,2,1,1], // 4
  [1,3,1,1], // 5
  [1,3,1,4], // 6
]

2~4 중에서 가장 작은 값

  4번째 까지의 합 : [1, 2, 1, 1]
2-1번째 까지의 합 : [0, 1, 1, 0]

결과 : [1, 1, 0, 1]

2~4 사이에는 A,C,T 가 있다는 의미

C G [T A C] C T
0 1 [2 3 4] 5 6
```

### MinAvgTwoSlice

- 첫 번째 풀이 : https://app.codility.com/demo/results/trainingC43H3Z-NP8/
- 두 번째 풀이 : https://app.codility.com/demo/results/training74GUAQ-CK5/
- 세 번째 풀이 : https://app.codility.com/demo/results/trainingHYPT57-TM3/

이 문제는 수학적인 사고가 필요한 문제였다.
자세한 설명은 아래에 첨부한다..

```text
숫자 배열에서 4개 이상의 요소는 평균을 구하는 의미가 없음
2, 3개의 요소의 평균만 구하면 된다.

arr = [1, 2, 3, 4, 5, 6]

위와 같은 배열이 있다고 가정해보고, 2, 4개 부분 집합을 비교해 보자.

2개
sub1 = [1, 2]
sub2 = [3, 4]

4개
sub3 = [1,2,3,4]

이렇게 구분했을 때 4개의 평균은, 2개 중 평균이 작은 것보다 더 작다.
수식으로 표현하면 MIN(AVG(sub1), AVG(sub2)) < AVG(sub3)

실제로 값을 구해보면

AVG(sub1) = 1.5
AVG(sub2) = 3.5
AVG(sub3) = 2.5

AVG(sub3) 는 2개 집합 중 작은 평균인 AVG(sub1) 보다는 무조건 크다.
왜냐면, 제일 작은 sub1 와 그보다 큰 sub2 를 더하고 2를 나누는 것이기 때문에 그렇다.

그래서 이 문제에서는 크기가 2, 3인 부분집합의 평균만 구해서 비교하면 된다...
```

## Lesson 6 : Sorting

| 난이도  |                                       문제                                       |  풀이시간   |      내 점수       |
|:----:|:------------------------------------------------------------------------------:|:-------:|:---------------:|
| Easy |    [PassingCars](https://app.codility.com/demo/results/trainingDFQPPF-XN7/)    |   6분    |     100/100     |
| Easy | [MaxProductOfThree](https://app.codility.com/demo/results/trainingDDZRJU-77Z/) | 40분 + @ | 44/100, 100/100 |
| Easy |     [Triangle](https://app.codility.com/demo/results/trainingUWNA3D-DEY/)      | 6분 + @  | 93/100, 100/100 |

### MaxProductOfThree

- 첫 번째 풀이 : https://app.codility.com/demo/results/trainingYSSA5Z-Z8N/
- 두 번째 풀이 : https://app.codility.com/demo/results/trainingDDZRJU-77Z/

간과하고 있었다.. Codility 는 수학적 사고가 정말 중요하다..<br>
어차피 큰거 3개만 찾으면 되니까, 정렬해서 계산하면 끝이다..;;<br>

### Triangle

- 첫 번째 풀이 : https://app.codility.com/demo/results/trainingXDJW7R-2MP/
- 두 번째 풀이 : https://app.codility.com/demo/results/trainingUWNA3D-DEY/

문제의 제약사항에 뻔히 int 의 최대값이 있었는데, 내가 이를 간과했다..<br> 

```text
Integer.MAX_VALUE + Integer.MAX_VALUE 하면 -2 가 되는 이유

- Integer.MAX_VALUE
  - 2진수 01111111 11111111 11111111 11111111
- Integer.MAX_VALUE + Integer.MAX_VALUE
  - 2진수 11111111 11111111 11111111 11111110
  - 하지만 Java 에서는 맨 앞자리를 부호비트로 사용(signed int)
  - 이는 -2 의 표현식임(아래 2의 변환과정 참고)

- 2의 변환
00000000000000000000000000000010 == 2
(1의 보수)
11111111111111111111111111111101
(더하기 1)
11111111111111111111111111111110 == -2
(빼기 1)
11111111111111111111111111111101
(1의 보수)
00000000000000000000000000000010 == 2

참고 : http://www.tcpschool.com/c/c_refer_negativeNumber
```



