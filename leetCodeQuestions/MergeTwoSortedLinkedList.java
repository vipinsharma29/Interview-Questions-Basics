package leetCodeQuestions;

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        // 3 -> 10 -> 15
        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(10);
        head1.next.next = new ListNode(15);

        // Second linked list: 2 -> 3 -> 20
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(20);

        ListNode result = sortedListNode(head1, head2);
        printList(result);
    }

    static void printList(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static ListNode sortedListNode(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        if (head1.data <= head2.data) {
            head1.next = sortedListNode(head1.next, head2);
            return head1;
        } else {
            head2.next = sortedListNode(head1, head2.next);
            return head2;
        }
    }
}
