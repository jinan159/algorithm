# Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/

단방향 연결리스트 개념을 이해하고 있는지 확인하는 문제 입니다.

----

# 풀이

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode start = head;
        ListNode node = head;
        
        while(node != null && node.next != null) {
            
            node = node.next;
            
            if (start.val == node.val) {
                start.next = node.next;
                continue;
            }
            
            if (start.val < node.val) {
                start = node;
            }
        }
        
        return head;
    }
}
```

----

# 결과

![image](https://user-images.githubusercontent.com/45728407/149058878-d45ab4da-7bd4-4833-98ad-5e4fa93b2d9c.png)
