import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] children = scan.nextLine().split("\\s+");
        int n = Integer.valueOf(scan.nextLine());

        ArrayDeque<String> childrens = new ArrayDeque<>();

        Collections.addAll(childrens, children);

        while (childrens.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String currentChild = childrens.poll();
                childrens.offer(currentChild);
            }
            String child = childrens.poll();
            System.out.println("Removed " + child);
        }
        System.out.println("Last is " + childrens.poll());
    }
}
