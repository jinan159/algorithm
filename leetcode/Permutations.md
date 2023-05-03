# Permutations
https://leetcode.com/problems/permutations/submissions/943917665/

DFS 재귀를 응용한 순열 조합 문제

----

# 풀이

```kotlin
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val visited = BooleanArray(nums.size)
        val permutation = IntArray(nums.size)
        val permutations = arrayListOf<List<Int>>()

        for (i in nums.indices) {
            if (!visited[i]) {
                visited[i] = true
                permutation[0] = nums[i]
                visit(nums, visited, permutation, permutations, 1, nums.size)
                visited[i] = false
            }
        }

        return permutations
    }

    private fun visit(
        nums: IntArray,
        visited: BooleanArray,
        permutation: IntArray,
        permutations: MutableList<List<Int>>,
        depth: Int,
        size: Int
    ) {
        if (depth == size) {
            permutations.add(permutation.toList())
            return
        }

        for (i in nums.indices) {
            if (!visited[i]) {
                visited[i] = true
                permutation[depth] = nums[i]
                visit(nums, visited, permutation, permutations, depth + 1, size)
                visited[i] = false
            }
        }
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/235991385-2ba1821f-cc37-4025-902a-5db2e4116671.png)
