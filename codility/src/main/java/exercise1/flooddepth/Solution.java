package exercise1.flooddepth;

class Solution {

    public int solution(int[] A) {

        int firstTopIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                firstTopIndex++;
            } else {
                break;
            }
        }

        int firstTop = A[firstTopIndex];
        int minHeight = A[firstTopIndex];
        int maxDepth = 0;

        for (int i = firstTopIndex + 1; i < A.length; i++) {
            if (firstTop <= (firstTop - minHeight) + A[i]) {
                maxDepth = Math.max(Math.min(firstTop, A[i]) - minHeight, maxDepth);
                if (firstTop < A[i]) {
                    firstTop = A[i];
                    minHeight = A[i];
                }
            } else {
                minHeight = Math.min(A[i], minHeight);
            }
        }

        return maxDepth;
    }
}
