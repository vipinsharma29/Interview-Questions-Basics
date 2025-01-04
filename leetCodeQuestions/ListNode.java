package leetCodeQuestions;

/**
 * Time, Space = O(n+m)
 */
class ListNode {
    int data;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.data = val;
    }

    ListNode(int val, ListNode next) {
        this.data = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.data + "";
    }
}
