package tasks.first;

        import java.util.ArrayDeque;
        import java.util.Scanner;

public class PolishCalc {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String str = in.nextLine();
        String [] strArr = str.split(" ");
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (String s : strArr) {
            if (isNumber(s)) {
                stack.push(Long.parseLong(s));
            } else {
                long elem1 = stack.pop();
                long elem2 = stack.pop();

                switch (s) {
                    case "+":
                        stack.push(elem1 + elem2);
                        break;
                    case "-":
                        stack.push(elem2 - elem1);
                        break;
                    case "*":
                        stack.push(elem1 * elem2);
                        break;
                    case "/":
                        stack.push(elem2 / elem1);
                        break;
                }
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        else {
            System.out.println("Error");
        }
    }
    private static boolean isNumber(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
