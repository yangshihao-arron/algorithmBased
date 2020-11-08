package recurisf;

import linkedlist.ListNode;

/*203. 移除链表元素
 删除链表中等于给定值 val 的所有节点。
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x；
      }
 示例:
 输入: 1->2->6->3->4->5->6, val = 6
 输出: 1->2->3->4->5
 */
public class Solution{
    public ListNode removeElements(ListNode head, int val){
        if(head == null)
            return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next:head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new linkedlist.Solution()).removeElements(head, 6);
        System.out.println(res);
    }
}