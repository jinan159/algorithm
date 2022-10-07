package exercise1.longestpassword;

class Solution {

    public int solution(String S) {
        // 1. 공백 기준으로 문자 나누기
        String[] words = S.split(" ");

        int maxLength = -1;

        for (String word : words) {
            int alphabetCount = 0;
            int digitCount = 0;

            // 2. 문자열들을 다시 charArray 로 변경
            for (char chr : word.toCharArray()) {
                // 3. a~z A~Z 0~9 인지 확인 후 count 증가
                if (Character.isAlphabetic(chr)) {
                    alphabetCount++;
                } else if (Character.isDigit(chr)) {
                    digitCount++;
                }
            }

            // 4. valid, invalid 구분
            if (isValid(word, alphabetCount, digitCount)) {

                // 5. valid 인 경우 max 와 비교 후 더 크면 변경
                if (maxLength < word.length()) {
                    maxLength = word.length();
                }
            }
        }

        return maxLength;
    }

    private boolean isValid(String word, int alphabetCount, int digitCount) {
        return alphabetCount % 2 == 0
            && digitCount % 2 == 1
            && word.length() == (alphabetCount + digitCount);
    }
}
