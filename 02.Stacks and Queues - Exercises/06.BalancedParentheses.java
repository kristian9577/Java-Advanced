import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String parentheses = scan.nextLine();

        Deque<Character> openingBrackets = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char current = parentheses.charAt(i);
            if (current == '{' || current == '[' || current == '(') {
                openingBrackets.push(current);
            } else {
                if (openingBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char opening = openingBrackets.pop();
                if (current == '}' && opening != '{') {
                    areBalanced = false;
                    break;
                } else if (current == ']' && opening != '[') {
                    areBalanced = false;
                    break;
                } else if (current == ')' && opening != '(') {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
