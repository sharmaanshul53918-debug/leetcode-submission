class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Step 1: Edge cases
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 2: Find length and tail
        ListNode tail = head;
        int n = 1;

        while(tail.next != null) {
            tail = tail.next;
            n++;
        }

        // Step 3: Calculate effective rotations
        k = k % n;

        if(k == 0) {
            return head;
        }

        // Step 4: Make circular linked list
        tail.next = head;

        // Step 5: Find new tail
        int steps = n - k;
        ListNode newTail = head;

        for(int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 6: Find new head
        ListNode newHead = newTail.next;

        // Step 7: Break circular linked list
        newTail.next = null;

        return newHead;
    }
}