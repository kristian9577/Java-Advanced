import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] number = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String line = reader.readLine();

        Function<int[], int[]> add = x -> Arrays.stream(x).map(e -> ++e).toArray();
        UnaryOperator<int[]> sub = x -> Arrays.stream(x).map(e -> --e).toArray();
        UnaryOperator<int[]> multiply = x -> Arrays.stream(x).map(e -> e *= 2).toArray();
        Consumer<int[]> printer = x -> Arrays.stream(x).forEach(el -> System.out.print(el + " "));

        while (!line.equals("end")) {
            switch (line) {
                case "add":
                    number = add.apply(number);
                    break;
                case "subtract":
                    number = sub.apply(number);
                    break;
                case "multiply":
                    number = multiply.apply(number);
                    break;
                default:
                    printer.accept(number);
                    System.out.println();
            }

            line = reader.readLine();
        }
    }
}
