import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(", ");

        Function<String, Integer> parse = Integer::parseInt;

        List<Integer> listNumbers = Arrays.stream(numbers)
                .map(parse)
                .collect(Collectors.toList());

        System.out.println("Count = " + listNumbers.size());
        int sum = listNumbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);
    }
}
