package tasks.first;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        System.out.println(checkBrackets(new Scanner(System.in).next()));
    }

    static String oBraces = "([{";
    static String cBraces = ")]}";

    public static boolean checkBrackets(String s){
        char [] entry = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : entry) {
            if (oBraces.contains(c.toString())) {
                stack.add(c);
            } else if (cBraces.contains(c.toString())){
                if (stack.isEmpty()){
                    return false;
                } else if (cBraces.indexOf(c) == oBraces.indexOf(stack.peekLast())){
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
