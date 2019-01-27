import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            String[] data = reader.readLine().split(" ");
            elements.addAll(Arrays.asList(data));
        }
        elements.forEach(el -> System.out.print(el + " "));
    }
}
