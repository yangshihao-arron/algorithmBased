package bst;

public class TestBST {
    public static void main(String[] args){
        BST<Integer> bst = new BST<Integer>();
        bst.add(20);
        bst.add(18);
        bst.add(24);
        bst.add(15);
        System.out.println(bst.contains(18));
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
  }
}
