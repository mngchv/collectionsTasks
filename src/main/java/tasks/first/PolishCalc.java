package tasks.first;

        import java.util.ArrayDeque;
        import java.util.Scanner;

public class PolishCalc {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String str = in.nextLine();
        String [] strArr = str.split(" ");
        ArrayDeque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < strArr.length; i++) {
            if (isNumber(strArr[i])) {
                stack.push(Long.parseLong(strArr[i]));
            } else {
                long elem1 = stack.pop();
                long elem2 = stack.pop();

                switch (strArr[i]) {
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
                        stack.push(elem2/elem1);
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
