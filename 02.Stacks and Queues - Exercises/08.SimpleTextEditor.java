import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        StringBuilder text = new StringBuilder();

        Deque<StringBuilder> stack = new ArrayDeque<>();

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");

            String command = tokens[0];

            switch (command) {
                case "1":
                    text.append(tokens[1]);
                    stack.push(new StringBuilder(text));
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    int start = text.length() - count;
                    text.delete(start, start + count);
                    stack.push(new StringBuilder(text));
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
                    break;
                case "4":
                    if (stack.size() > 1) {
                        stack.pop();
                        text = stack.peek();
                    } else if (stack.size() == 1) {
                        text = new StringBuilder();
                    }
                    break;
            }
        }
    }
}
