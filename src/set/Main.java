package set;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
//        System.out.println("a-tale-of-two-cities");
//
//        ArrayList<String> words1 = new ArrayList<>();
//        if(FileOperation.readFile("a-tale-of-two-cities.txt",words1)){
//            System.out.println("Total words:" + words1.size());
//
//            BSTSet<String> set1 = new BSTSet<>();
//            for(String word : words1)
//                set1.add(word);
//            System.out.println("Total different words:" + set1.getSize());
//        }
        String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String [] words = {"gin", "zen", "gig", "msg"};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            StringBuilder res = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++){
                res.append(codes[words[i].charAt(j) - 'a']);
            }
            set.add(res.toString());
        }
       System.out.println(set.size());

    }
}
