import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> number = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(reader.readLine());
        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reverseAndExclude = ((arr, num) -> {
            Collections.reverse(arr);
            return arr.stream()
                    .filter(el -> el % num != 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        });

        reverseAndExclude.apply(number, n).forEach(el -> System.out.print(el + " "));
    }
}
