package test;

import segmengtree.SegmentTree;

public class Test307_2 {
    private SegmentTree<Integer> segmentTree;

    public Test307_2(int[] nums){
        if(nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data,(a, b) -> a+b);
        }
    }
    public int sumRange(int i, int j) {

        return segmentTree.query(i,j);
    }
    public void update(int i, int val) {
        if(segmentTree == null)
            throw new IllegalArgumentException("segment tree is null");
        segmentTree.set(i,val);
    }
}
