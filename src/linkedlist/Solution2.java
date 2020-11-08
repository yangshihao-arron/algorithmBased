package linkedlist;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        while (head !=null && head.val == val) {
            head = head.next;
        }
        if(head == null)
            return null;
        for (ListNode i = head; i != null; i = i.next) {
            if(i.next == null)
                return head;
            if (i.next.val == val) {
                i.next = i.next.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res =  (new Solution2()).removeElements(head,2);
        System.out.println(res);
    }
}
