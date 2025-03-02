package leetCodeQuestions;

import models.ListNode;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Linking nodes to form a list: 3 -> 2 -> 0 -> -4
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Creating a cycle by linking last node to second node (2)
        fourth.next = second;

        System.out.println(firstMethod(head));
    }

    private static boolean firstMethod(ListNode head) {
        ListNode i = head, j = head;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) return true;
        }
        return false;
    }
}
