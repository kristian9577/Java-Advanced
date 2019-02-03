import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Comparator<Integer> comparator = ((a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1;
            } else if (b % 2 == 0 && a % 2 != 0) {
                return 1;
            }
            return a.compareTo(b);
        });
        numbers.stream().sorted(comparator).forEach(el -> System.out.print(el + " "));
    }
}
