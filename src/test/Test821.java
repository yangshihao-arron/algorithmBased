package test;

import java.util.HashMap;
import java.util.Map;

public class Test821 {
    //"loveleetcode"
    //"e"
    public int[] shortestToChar(String S, char C) {
        char[] sChar = S.toCharArray();
        int[] nums = new int[sChar.length];
        int count = 0;
        int index = 0;
        for(int i = 0; i < sChar.length; i++)
            if(sChar[i] == C)
                count++;
        int[] indexs = new int[count];
        for(int i = 0; i < sChar.length; i++){
            if(sChar[i] == C){
                indexs[index] = i;
                index++;
            }

        }
        index = 0;
        int pre = indexs[0];
        int next = indexs[0];
        if(count > 1)
             next = indexs[1];
        if(pre != next)
            index = 1;
        for(int i = 0; i < sChar.length; i++){
            if(Math.abs(pre - i) <= Math.abs(next - i))
                nums[i] = Math.abs(pre - i);
            else{
                nums[i] = Math.abs(next - i);
                pre = next;
                if(index < count - 1){
                    next = indexs[index+1];
                    index++;
                }
            }
        }
        return nums;
    }
}
