package unionfind;

//第二版并查集，Quick Union
//孩子指向父亲
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size){

        parent = new int[size];

        for(int i = 0; i < size; i++){
            parent[i] = i;
        }

    }

    @Override
    public int getsize() {
        return parent.length;
    }

    //时间复杂度 O(h)
    private int find(int p){

        if( p < 0 || p >= parent.length)
            throw  new IllegalArgumentException("p is out of bound");
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    //时间复杂度 O(h)
    @Override
    public boolean isConnected(int p, int q) {

        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }
}
