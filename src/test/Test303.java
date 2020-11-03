package test;

import segmengtree.SegmentTree;

public class Test303 {
    private SegmentTree<Integer> segmentTree;
    public Test303(int[] nums) {
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
}
