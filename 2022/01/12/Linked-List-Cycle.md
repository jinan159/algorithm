# Linked List Cycle
https://leetcode.com/problems/linked-list-cycle/

처음에는 이 문제를 Set을 통해서 풀었습니다.

해당 객체의 주소를 넣고, 이 주소를 내가 방문했었는지 확인하는 방식으로 풀었는데요.

문제는 해결했지만, 공간복잡도가 높게 나와서 개선할 방법을 찾아봤습니다.

힌트는 문제의 제약사항에서 얻을 수 있었습니다.

```
Constraints:

- The number of the nodes in the list is in the range [0, 104].
- -10^5 <= Node.val <= 10^5
- pos is -1 or a valid index in the linked-list.
```

위는 문제의 제약사항인데요.

여기서 2번째 조건을 보시면, Node.val은 -10000 ~ 10000 까지라는 것을 알 수 있습니다.

그렇다면, 만약 이 범위 밖의 값(방문값)을 방문하는 Node 마다 넣어주고, 다음 노드의 값이 방문값인지 확인하는 방법을 통해

O(1)의 공간 복잡도로 해결할 수 있었습니다.

----

# 풀이

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private final int VISIT = 10001;
    
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        
        ListNode node = head;
        
        while(node != null) {
            
            int value = node.val;
            
            if (node.val == VISIT) {
                return true;
            }
            
            node.val = VISIT;
            node = node.next;
        }
        
        return false;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/149086195-77fc0ac0-93e7-4c37-bffb-2af9abd61a96.png)
