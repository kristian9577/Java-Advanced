import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbers = reader.readLine().split(", ");
        List<Double> num = Arrays.stream(numbers)
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        for (Double n : num) {
            System.out.println(String.format("%1$.2f", addVat.apply(n)));
        }
    }
}
