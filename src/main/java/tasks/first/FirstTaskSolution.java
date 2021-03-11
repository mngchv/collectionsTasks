package tasks.first;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjMatrix, int startIndex) {
        String ans = "";
        int m = adjMatrix.length;
        ArrayList<Integer> status = new ArrayList<>();
        ArrayDeque<Integer> graph = new ArrayDeque<>();
        graph.add(startIndex);
        while(status.size() < m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                if (adjMatrix[i][graph.peekFirst()]){
                    temp.add(i);
                }
            }
            Collections.sort(temp);
            graph.addAll(temp);

            if(!status.contains(graph.peekFirst())) {
                status.add(graph.peekFirst());
                ans = ans + graph.pop() + ",";
            }
            else{
                graph.removeFirst();
            }
        }
        return ans.substring(0, ans.length()-1);
    }

    @Override
    public Boolean validateBrackets(String s) {
        String openBraces = "([{";
        String closeBraces = ")]}";

            char[] entry = s.toCharArray();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (Character c : entry) {
                if (openBraces.contains(c.toString())) {
                    stack.add(c);
                } else if (closeBraces.contains(c.toString())) {
                    if (stack.isEmpty()) {
                        return false;
                    } else if (closeBraces.indexOf(c) == openBraces.indexOf(stack.peekLast())) {
                        stack.removeLast();
                    }
                }
            return stack.isEmpty();
        }
        return null;
    }

    @Override
    public Long polishCalculation(String s) {
        return null;
    }
}
