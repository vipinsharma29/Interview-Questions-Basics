package leetCodeQuestions;

public class ReverseLinkedListInGroupOfK {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        createGroupOfK(head, 2);

//        head = reverseFirstK(head, 3);
//
//        printList(head);

    }

    private static void createGroupOfK(ListNode head, int groupSize) {
        if (head == null || groupSize <= 1) {
            System.out.println(head);
        }

        ListNode updatedList = new ListNode();
        ListNode current = head;


//        while (current != null) {
//            ListNode groupList = current;
//            int count = 0;
//            while (count < groupSize) {
//                groupList = cu
//            }
//        }
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp);

            temp = temp.next;
        }
    }

    private static ListNode reverseFirstK(ListNode head, int k) {

        ListNode prev = null, curr = head;
        int count = 0;

        while (curr != null && count < k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        head.next = curr;

        return prev;
    }


}
