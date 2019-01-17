import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();

        ArrayDeque<String> printer = new ArrayDeque<>();

        while (!line.equals("print")) {
            if (line.equals("cancel")) {
                if (printer.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Cancelled " + printer.poll());
                }
            } else {
                printer.offer(line);
            }
            line = scan.nextLine();
        }
        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
