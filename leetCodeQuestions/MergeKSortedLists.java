package leetCodeQuestions;

public class MergeKSortedLists {
    public static void main(String[] args) {

        // 3 -> 10 -> 15
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(25);

        // Second linked list: 2 -> 3 -> 20
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);
        head3.next.next = new ListNode(16);

        ListNode head4 = new ListNode(15);
        head4.next = new ListNode(20);
        head4.next.next = new ListNode(34);

        ListNode result = mergeKLists(new ListNode[]{head1, head2, head3, head4});
        printList(result);
    }

    private static void printList(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        return mergeSort(lists, 0, lists.length - 1);
    }

    private static ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = mergeSort(lists, left, mid);
        ListNode l2 = mergeSort(lists, mid + 1, right);

        return mergeSortedLists(l1, l2);
    }

    private static ListNode mergeSortedLists(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.data <= right.data) {
            left.next = mergeSortedLists(left.next, right);
            return left;
        } else {
            right.next = mergeSortedLists(left, right.next);
            return right;
        }
    }
}
