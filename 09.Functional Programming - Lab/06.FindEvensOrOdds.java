import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BiPredicate<String, Integer> types = (type, number) -> {
            if (type.equals("even")) {
                return number % 2 == 0;
            } else {
                return number % 2 != 0;
            }
        };

        int[] bounds = Arrays.stream(reader.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String type = reader.readLine();

        IntStream.range(bounds[0], bounds[1] + 1)
                .filter(number -> types.test(type, number))
                .forEach(number -> {
            System.out.print(number + " ");
        });
    }
}
