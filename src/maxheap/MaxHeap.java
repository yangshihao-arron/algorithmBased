package maxheap;

public class MaxHeap <E extends  Comparable<E>>{

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length-1); i >= 0; i--)
            siftDown(i);
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回父亲节点的索引
    private int parent(int index){

        if(index == 0)
            throw  new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){

        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public E findMax(){

        if(data.getSize() == 0)
                throw new IllegalArgumentException("heap is empty");
        return data.get(0);
    }

    public E extractMax(){

        E ret = findMax();

        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while(leftChild(k) < data.getSize()){
           int j = leftChild(k);
           if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
               j = rightChild(k);
           if(data.get(k).compareTo(data.get(j)) >= 0 )
               break;
           data.swap(k,j);
           k = j;
        }
    }
    //取出堆中最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }



}
