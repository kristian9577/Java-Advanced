import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> users = new LinkedHashSet<>();
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String username = reader.readLine();
            users.add(username);
        }
        users.forEach(System.out::println);
    }
}
