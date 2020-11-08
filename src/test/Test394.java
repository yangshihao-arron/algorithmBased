package test;

import java.util.LinkedList;

public class Test394 {
    public static void main(String[] args) {
        String s = "1[a]1[b]";
        Test394 test394 = new Test394();
        System.out.println(test394.decodeString(s));
    }

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;

        LinkedList<Integer> stackNums = new LinkedList<>();
        LinkedList<String> stackStrings = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9')
                num = num * 10 + Integer.parseInt(c + "");
            else if (c == '[') {
                stackNums.addLast(num);
                stackStrings.addLast(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int count = stackNums.removeLast();
                System.out.println("count: " + count);
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    temp.append(res.toString());
                    res = new StringBuilder(stackStrings.removeLast() + temp.toString());
                }
            } else
                res.append(c);
        }
        return res.toString();

    }

}