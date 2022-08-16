# 타겟 넘버
https://programmers.co.kr/learn/courses/30/lessons/43165?language=java#

| numbers | target  | return  |
| - | - | - |
| [1, 1, 1, 1, 1] | 3 | 5 |

```
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
```

간단히 문제를 설명하면, 위 표처럼 숫자 배열이 주어졌을 때 아래 예시처럼 숫자를 나열하여 target과 같은 합이 나오는 조합 개수를 구하는 문제이다.

특정 숫자(노드)는 + 혹은 - 값을 가져야한다.

경우의 수가 두 가지라는 의미이기 때문에 이진트리 구조로 모든 경우의 수를 만들었다.

이렇게 모든 경우의 수를 가진 트리를 만들었는데, 이제 문제는 식의 결과를 계산해야 한다는 것이다.

나는 주어진 numbers를 한 레벨씩 내려가며 모든 경우의 수를 구현하였다.

즉, 루트 노드부터 리프 노드까지 한번에 쭉 내려가는 경로가 바로 하나의 식이 되는것이다.

이 경우에는 DFS로 탐색하면 값을 찾을 수 있어서 재귀호출을 통한 DFS를 구현하여 식의 계산 결과를 구했다.

----

# 풀이

<details>
<summary>python3</summary>

```python
class Node:
    def __init__(self, left_node, right_node, init_data):
        self.left = left_node
        self.right = right_node
        self.data = init_data


def addNodes(node, numbers, level):
    if level < len(numbers):
        node.left = Node(None, None, (-1) * numbers[level])
        node.right = Node(None, None, numbers[level])

        addNodes(node.left, numbers, level + 1)
        addNodes(node.right, numbers, level + 1)


def dfs(node, sum, target, answer):
    if node is not None:
        sum += node.data

        if node.left is not None:
            answer = dfs(node.left, sum, target, answer)

        if node.right is not None:
            answer = dfs(node.right, sum, target, answer)

        if node.left is None and node.right is None and sum == target:
            answer += 1

    return answer


def solution(numbers, target):
    answer = 0

    root_node = Node(None, None, 0);
    depth = len(numbers)
    addNodes(root_node, numbers, 0)

    return dfs(root_node, 0, target, answer)


print("1번 : ", solution([1, 1, 1, 1, 1], 3) == 5)
print("2번 : ", solution([4, 1, 2, 1], 4) == 2)
```

</details>

<details>
<summary>java</summary>

```java
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Node root = new Node(0);
        
        addChilds(root, numbers, 0);
        
        answer = dfsR(root, target, 0, 0);
        
        return answer;
    }
    
    private int dfsR(Node node, int target, int sum, int count) {
        
        if (node == null) {
            return count;
        }
        
        sum += node.data;
        
        count = dfsR(node.left, target, sum, count);
        count = dfsR(node.right, target, sum, count);        
        
        if (node.isLeaf() && sum == target) {
            count++;
        }
        
        return count;
    }
    
    private void addChilds(Node node, int[] numbers, int depth) {
        
        if (depth == numbers.length) return;
        
        node.left = new Node(numbers[depth]);
        node.right = new Node(numbers[depth] * (-1));
        
        addChilds(node.left, numbers, depth + 1);
        addChilds(node.right, numbers, depth + 1);
    }
}

class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data) {
        this.data = data;
    }
    
    public boolean isLeaf() {
        if (this.left == null && this.right == null) return true;
        
        return false;
    }
}
```

</details>

----

# 결과

<details>
<summary>java 결과</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32870"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (45.03ms, 139MB)</td></tr><tr data-testcase-id="32871"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (46.07ms, 130MB)</td></tr><tr data-testcase-id="32872"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (0.77ms, 78.8MB)</td></tr><tr data-testcase-id="32873"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (1.20ms, 75.3MB)</td></tr><tr data-testcase-id="32874"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (2.72ms, 78.6MB)</td></tr><tr data-testcase-id="32875"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (0.93ms, 82MB)</td></tr><tr data-testcase-id="32876"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (0.81ms, 75.7MB)</td></tr><tr data-testcase-id="32877"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (1.41ms, 72.9MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>

<details>
<summary>python3 결과</summary>
<div id="output" class="console-output tab-pane fade in active show"><pre class="console-content"><div></div><div class="console-heading">채점을 시작합니다.</div><div class="console-message">정확성  테스트</div><table class="console-test-group" data-category="correctness"><tbody><tr data-testcase-id="32870"><td valign="top" class="td-label">테스트 1 <span>〉</span></td><td class="result passed">통과 (8315.02ms, 366MB)</td></tr><tr data-testcase-id="32871"><td valign="top" class="td-label">테스트 2 <span>〉</span></td><td class="result passed">통과 (7722.06ms, 368MB)</td></tr><tr data-testcase-id="32872"><td valign="top" class="td-label">테스트 3 <span>〉</span></td><td class="result passed">통과 (1.69ms, 10.3MB)</td></tr><tr data-testcase-id="32873"><td valign="top" class="td-label">테스트 4 <span>〉</span></td><td class="result passed">통과 (7.72ms, 11.1MB)</td></tr><tr data-testcase-id="32874"><td valign="top" class="td-label">테스트 5 <span>〉</span></td><td class="result passed">통과 (70.01ms, 20.9MB)</td></tr><tr data-testcase-id="32875"><td valign="top" class="td-label">테스트 6 <span>〉</span></td><td class="result passed">통과 (3.80ms, 10.6MB)</td></tr><tr data-testcase-id="32876"><td valign="top" class="td-label">테스트 7 <span>〉</span></td><td class="result passed">통과 (1.74ms, 10.4MB)</td></tr><tr data-testcase-id="32877"><td valign="top" class="td-label">테스트 8 <span>〉</span></td><td class="result passed">통과 (25.69ms, 12.6MB)</td></tr></tbody></table><div class="console-heading">채점 결과</div><div class="console-message">정확성: 100.0</div><div class="console-message">합계: 100.0 / 100.0</div></pre></div>
</details>
