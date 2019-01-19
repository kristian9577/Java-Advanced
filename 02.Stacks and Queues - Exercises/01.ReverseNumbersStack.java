import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        String[] numbers = scan.nextLine().split("\\s+");

        for (int i = 0; i < numbers.length; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}
