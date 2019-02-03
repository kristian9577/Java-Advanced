import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lengthName = Integer.parseInt(reader.readLine());

        BiPredicate<String, Integer> filterName = (name, length) -> name.length() <= length;

        Arrays.stream(reader.readLine().split(" "))
                .filter(name -> filterName.test(name, lengthName))
                .forEach(System.out::println);

    }
}
