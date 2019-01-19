import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementToPush = tokens[0];
        int elementToPop = tokens[1];
        int elementToFind = tokens[2];

        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementToPush)
                .forEach(stack::push);

        while (elementToPop-- > 0) {
            stack.pop();
        }

        if (stack.contains(elementToFind)) {
            System.out.println("true");
        } else {
            int minNum = Integer.MAX_VALUE;

            if (stack.isEmpty()) {
                minNum = 0;
            }

            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (current < minNum) {
                    minNum = current;
                }
            }
            System.out.println(minNum);
        }
    }
}
