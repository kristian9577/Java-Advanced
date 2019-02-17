package GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            System.out.printf("%s%n", new Box<>(reader.readLine()).toString());

        }
    }
}
