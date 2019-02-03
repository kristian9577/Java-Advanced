import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> numbers = new ArrayList<>();

        BiPredicate<int[], Integer> anyMatch = (divisors, number) -> {
            for (int divisor : divisors) {
                if (number % divisor != 0) {
                    return false;
                }
            }
            return true;
        };
        int n = Integer.parseInt(reader.readLine());
        int[] divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();

        for (int i = 1; i <= n; i++) {
            if (anyMatch.test(divisors, i)) {
                numbers.add(i);
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
