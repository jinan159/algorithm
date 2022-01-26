# Time Conversion
https://www.hackerrank.com/challenges/time-conversion/submissions

AM, PM 포함여부에 따라 24시간 표기법으로 변경하는 문제입니다.
기본적인 문자열을 다루기 문제 입니다.
- 특정 문자열 포함여부
- 문자열 특정 문자 기준으로 자르기
- 정해진 길이만큼 문자열 채우기

----

# 풀이

```java
private static final String AM = "AM";
private static final String PM = "PM";

public static String timeConversion(String s) {
// Write your code here
    boolean isAM = false;

    if (s.contains(AM)) {
        isAM = true;
    }

    if (isAM) {
        s = s.replace(AM, "");
    } else {
        s = s.replace(PM, "");
    }

    String[] times = s.split(":");

    StringBuilder sb = new StringBuilder();
    sb.append(convertToMilitaryTime(times, isAM))
        .append(":").append(times[1])
        .append(":").append(times[2]);

    return sb.toString();
}

private static String convertToMilitaryTime(String[] times, boolean isAM) {
    int hour = Integer.parseInt(times[0]);

    if (isAM && hour >= 12) {
        hour -= 12;
    }

    if (!isAM && hour < 12) {
        hour += 12;
    }

    return padLeftZero(String.valueOf(hour), 2);
}

private static String padLeftZero(String str, int size) {
    StringBuilder sb = new StringBuilder();
    int len = size - str.length();
    IntStream.range(0,len).forEach(i -> sb.append("0"));
    sb.append(str);

    return sb.toString();
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/151096071-de7cfdb8-6520-4c4b-8887-8609acf54698.png)
