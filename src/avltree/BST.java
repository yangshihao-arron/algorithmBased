package avltree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树中添加元素e
  /*  public void add(E e){

        if(root == null)
        {
            root = new Node(e);
            size++;
        }
        else{
            add(root,e);
        }
    }

    //向以node为根的二分搜索树中插入元素E ,递归算法
   private void add(Node node,E e){
        //递归终止条件
       if(e.equals(node.e))
           return;
       else if(e.compareTo(node.e) < 0 && node.left == null){
           node.left = new Node(e);
           size++;
           return ;
       }
       else if(e.compareTo(node.e) > 0 && node.right == null){
           node.right = new Node(e);
           size ++;
           return ;
       }
       if(e.compareTo(node.e) < 0)
           add(node.left,e);
       else
           add(node.right,e);
    }*/

    //向二分搜索树中添加元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的二分搜索树中插入元素E ,递归算法
    //返回插入新节点后二叉树的根
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }
    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node == null)
            return false;
        if(e.equals(node.e))
            return true;
        else if(e.compareTo(node.e) < 0)
           return contains(node.left,e);
        else
           return  contains(node.right,e);
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null)
            stack.push(cur.right);
            if(cur.left != null)
            stack.push(cur.left);
        }
    }
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n") ;
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth + 1, res);

    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }
    private  void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
    //层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null)
            queue.add(cur.left);
            if(cur.right != null)
            queue.add(cur.right);
        }
    }
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }
    //删除最小值所在结点
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除以node为根的二分搜索树中的最小节点，返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left =  removeMin(node.left);
        return node;
    }
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null)
            return node;
        return maximum(node.right);
    }
    public E removeMax(){
        E ret = maximum();
        removeMin(root);
        return ret;
    }
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }
    public void remove(E e){
        root = remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0)
        {
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0 )
        {
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            size++;
            successor.left = node.left;
            node.left = node.right = null;
            size--;
            return successor;
        }
        

    }
}
