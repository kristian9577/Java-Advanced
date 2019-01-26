import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> guestList = new TreeSet<>();
        String input = reader.readLine();

        while (!input.equals("PARTY")) {
            guestList.add(input);
            input = reader.readLine();
        }
        while (!"END".equals(input = reader.readLine())) {
            guestList.remove(input);
        }

        System.out.println(guestList.size());
        for (String guest : guestList) {
            System.out.println(guest);
        }
    }
}
