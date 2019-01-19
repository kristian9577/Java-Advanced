import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] tokens = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementToAdd = tokens[0];
        int elementToPoll = tokens[1];
        int elementToFind = tokens[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementToAdd)
                .forEach(queue::add);

        while (elementToPoll-- > 0) {
            queue.poll();
        }
        if (queue.contains(elementToFind)) {
            System.out.println("true");
        } else {
            int minNum = Integer.MAX_VALUE;

            if (queue.isEmpty()) {
                minNum = 0;
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (current < minNum) {
                    minNum = current;
                }
            }
            System.out.println(minNum);
        }
    }
}
