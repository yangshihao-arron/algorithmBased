package array;

public class Array <E> {
    private E[] data;
    private int size;

    //传入capacity
    public Array(int capacity){
        data = (E[]) new Object[capacity];
    }

    //capacity = 10
    public Array(){
        this(10);
    }
    //返回数组元素个数
    public int getSize(){
        return size;
    }
    //返回数组容量
    public int getCapacity(){
        return  data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //向数组末尾添加元素e
    public void addLast(E e){
//        if(size == data.length)
//            throw new IllegalArgumentException("addLast faileed. array is full");
//        data[size] = e;
//        size++;
        add(size,e);
    }
    //向数组首部添加元素e
    public void addFirst(E e){
        add(0,e);
    }
    //向数组index位置插入元素e
    public void add(int index,E e ){
        if(index < 0 || index > size)//index = size说明只用移动一个元素
            throw new IllegalArgumentException("add failed. index is not available");
        if(size == data.length)
            resize(2*data.length);
        for(int i = size-1; i >=index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index < 0 | index >= size)  //index == size 处索引为空
            throw new IllegalArgumentException(("Get failed,Index is illegal"));
        return data[index];
    }
    //修改index索引位置的元素为e
    void set(int index,E e){
        if(index< 0 || index >= size)
            throw  new IllegalArgumentException("Set failed,index is Illegal");
            data[index] = e;
    }
    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0; i < size;i++){
            if(data[i] .equals(e) )
                return true;
        }
        return false;
    }
    //找不到返回-1，找到返回e的索引
    public int find(E e){
        for(int i = 0; i < size;i++){
            if(data[i] .equals(e) )
                return i;
        }
        return -1;
    }
    //从数组中删除Index位置的元素，返回删除的元素
    public E remove(int index){
        if(index < 0 || index >=size)
        throw new IllegalArgumentException("remove failed, Index is illegal");
        E ret = data[index];
        for(int i = index + 1; i < size; i++)
            data[i-1] = data[i];
        size--;//存在对象引用，不会被垃圾机智回收
        data[size] = null; //loitering objects != memory leak
        if(size == data.length / 4 && data.length/2 != 0)
            resize(data.length / 2);
        return ret;
    }

    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    //从数组中删除最后位置的元素，返回删除的元素
    public E removeLast(){
       return remove(size-1);
    }
    //从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }
    @Override
    public String toString(){
      StringBuilder res = new StringBuilder();
      res.append(String.format("Array:size = %d, capacity = %d\n",size,data.length));
      res.append('[');
      for(int i = 0 ; i < size; i++ ){
          res.append(data[i]);
          if(i != size -1){
              res.append(",");
          }
      }
      res.append(']');
      return  res.toString();
    }
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0 ; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
