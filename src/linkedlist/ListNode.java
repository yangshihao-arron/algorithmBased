package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
    //链表结点的构造函数
    //使用arr为参数，创建一个链表，当前的ListNode为链表结点
    public ListNode(int [] arr){
        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for(int i =1 ; i < arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }
    @Override
    //以当前结点为头节点对应的字符串
    public String toString( ){
       StringBuilder res = new StringBuilder();
       res.append("ListNode:");
       ListNode node = this;
       while(node !=null){
           res.append(node.val + "->");
           node = node.next;
       }
       res.append("null");
       return res.toString();
    }
}
