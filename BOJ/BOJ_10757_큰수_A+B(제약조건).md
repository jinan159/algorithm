# 큰수 A+B
https://www.acmicpc.net/problem/10757

## 제약조건
- big number기능을 사용하지 않고 풀기(BigInteger 등..)

----

# 풀이

이 문제는 제약조건을 걸고 풀었습니다.

Integer만 사용하여 풀기 위해 곰곰히 고민해보다가, 이진수를 계산했던 방법을 응용하면 되겠다고 생각했습니다.

그래서 먼저, int만으로 두 수를 더할 수 있도록 억 단위로 잘라서 계산했습니다.

그리고 carry가 발생하면, 다음 계산에 넣어주어 큰 수를 계산했습니다.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final int SPLIT_DIGIT = 9; // 억 단위

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    private String getAnswer(String num1, String num2) {
        List<String> splited1 = getSplitedList(num1);
        List<String> splited2 = getSplitedList(num2);

        return addSplitedNumberToString(splited1, splited2);
    }

    private void solution() {
        String[] numbers = getNumbersToString();

        List<String> splited1 = getSplitedList(numbers[0]);
        List<String> splited2 = getSplitedList(numbers[1]);

        String sumStr = addSplitedNumberToString(splited1, splited2);

        System.out.println(sumStr);
    }

    private String[] getNumbersToString() {
        Scanner sc = new Scanner(System.in);

        String[] numbers = new String[2];
        numbers[0] = sc.next();
        numbers[1] = sc.next();

        return numbers;
    }

    private List<String> getSplitedList(String number) {
        List<String> list = new ArrayList<>();
        int length = (number.length() / SPLIT_DIGIT) + 1;

        for (int i = 0; i < length; i++) {
            int start = number.length() - (SPLIT_DIGIT * (i+1));
            int end = number.length() - ((SPLIT_DIGIT * i));

            if (start < 0) start = 0;

            list.add(number.substring(start, end));
        }

        return list;
    }

    private String addSplitedNumberToString(List<String> splited1, List<String> splited2) {

        String result = "";

        int length = getMaxLength(splited1, splited2);
        String carry = "0";

        for (int i = 0; i < length; i++) {
            String num1 = tryGet(splited1, i);
            String num2 = tryGet(splited2, i);

            String[] carryAndSum = getCarryAndSum(num1, num2, carry);

            carry = carryAndSum[0];
            String sum = carryAndSum[1];

            result = sum + result;
        }

        return trimZero(result);
    }

    private int getMaxLength(List<String> splited1, List<String> splited2) {
        int length = splited1.size();

        if (length < splited2.size()) length = splited2.size();

        return length;
    }

    private String tryGet(List<String> list, int index) {
        if (list.size() <= index) {
            return "0";
        }

        return list.get(index);
    }

    private String[] getCarryAndSum(String num1, String num2, String carry) {

        if (isNullOrEmpty(num1)) num1 = "0";
        if (isNullOrEmpty(num2)) num2 = "0";
        if (isNullOrEmpty(carry)) carry = "0";

        int sum = Integer.parseInt(num1) + Integer.parseInt(num2) + Integer.parseInt(carry);

        return new String [] { getCarry(sum), getSum(sum) };
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }

    private String getSum(int number) {
        String numStr = String.valueOf(number);

        if (numStr.length() > SPLIT_DIGIT) {
            return numStr.substring(1);
        }

        return padLeft(numStr, SPLIT_DIGIT);
    }

    private String getCarry(int number) {
        String numStr = String.valueOf(number);

        if (numStr.length() <= SPLIT_DIGIT) {
            return "0";
        }

        return String.valueOf(numStr.charAt(0));
    }

    private String padLeft(String str, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length-str.length(); i++) {
            sb.append("0");
        }

        sb.append(str);

        return sb.toString();
    }

    private String trimZero(String str) {

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                return str.substring(i);
            }
        }

        return str;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/148165507-9bc587a7-d50c-4e1c-b5f3-f9d4c542833a.png)
