import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        Map<String, String> fixedEmails = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scan.nextLine();
            if (email.contains(".us") || email.contains(".uk")|| email.contains(".com")) {
            } else {
                fixedEmails.put(name, email);
            }
            name = scan.nextLine();
        }
        for (String emails : fixedEmails.keySet()) {
            System.out.println(emails + " -> " + fixedEmails.get(emails));
        }
    }
}