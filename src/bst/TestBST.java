package bst;

import java.util.ArrayList;
import java.util.Random;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        int n = 1000;
        Random random = new Random();

        for(int i= 0; i < n ;i++){
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i-1) < nums.get(i))
                System.out.println("false");
        }
    }

}
