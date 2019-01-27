import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class SetsofElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstSize = data[0];
        int secondSize = data[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();
        while (firstSize-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            firstSet.add(number);
        }
        while (secondSize-- > 0) {
            int number = Integer.parseInt(reader.readLine());
            secondSet.add(number);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(u -> System.out.print(u + " "));
    }
}
