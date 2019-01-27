import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String value = scan.nextLine();
            if (resources.containsKey(input)) {
                resources.put(input, resources.get(input) + Integer.parseInt(value));
            } else {
                resources.put(input, Integer.parseInt(value));
            }
            input = scan.nextLine();
        }
        for (String res : resources.keySet()) {
            System.out.println(res + " -> " + resources.get(res));
        }
    }
}