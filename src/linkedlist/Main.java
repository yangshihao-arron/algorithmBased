package linkedlist;

public class Main {
    public static void main(String[] args ){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            linkedList.addFIrst(i);
            System.out.println(linkedList);
        }

        linkedList.add(0,7);
        linkedList.add(4,8);

        System.out.println(linkedList.toString());
    }
}
