package unionfind;

//第一版并查集Quick Find
public class UnionFind1 implements  UF{
    private int[] id;

    public UnionFind1(int size){

        id = new int[size];

        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    @Override
    public int getsize() {
        return id.length;
    }

    //查找元素p所对应的编号
    private int find(int p){
        if(p < 0 && p >= id.length )
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }


    //时间复杂度:O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合  时间复杂度:O(N)
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if(pID == qID)
            return;
        for(int i = 0; i < id.length; i++){
            if(id[i] == pID)
                id[i] = qID;
        }
    }
}
