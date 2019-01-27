import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Map<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.put(name, number);
        }
        String name;
        while (!"stop".equals(name = reader.readLine())) {
            if (phonebook.containsKey(name)) {
                System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", name));
            }
        }

    }
}
