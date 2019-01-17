import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> browser = new ArrayDeque<>();
        String line = scan.nextLine();

        String current = "";
        while (!line.equals("Home")) {
            if (line.equals("back")) {
                if (!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    line = scan.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    browser.push(current);
                }
                current = line;
            }
            System.out.println(current);
            line = scan.nextLine();
        }
    }
}
