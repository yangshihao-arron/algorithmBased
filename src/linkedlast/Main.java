package linkedlast;

public class Main {
    public static void main(String[] args ){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            linkedList.addFIrst(i);
            System.out.println(linkedList);
        }
        linkedList.addLast(999);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
