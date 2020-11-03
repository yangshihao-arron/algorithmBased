package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TestA {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(a);
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int count = 0;
        for (int i = 0; i < n; i++)
            if (digits[i] == 9)
                count++;
        if (count == n) {
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 1; i < res.length; i++) {
                res[i] = 0;
            }
            return res;
        }
        count = digits[n - 1] == 9 ? 1 : 0;
        int index = n - 1;
        if (count == 0)
            digits[index] = digits[index] + 1;
        while (count != 0) {
            digits[index] = 0;
            index--;
            if ((digits[index] + 1) % 10 == 0) {
                continue;
            }
            count = 0;
            digits[index] = digits[index] + 1;
        }
        return digits;
    }
}
