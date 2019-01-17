import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();

        String line = scan.nextLine();

        String current = "";

        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!browser.isEmpty()) {
                    forwards.push(current);
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scan.nextLine();
                    continue;
                }
            } else if (line.equals("forward")) {
                if (!forwards.isEmpty()) {
                    browser.push(current);
                    current = forwards.pop();
                } else {
                    System.out.println("no next URLs");
                    line = scan.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    browser.push(current);
                    if (!forwards.isEmpty()) {
                        forwards.clear();
                    }
                }
                current = line;
            }
            System.out.println(current);
            line = scan.nextLine();
        }
    }
}
