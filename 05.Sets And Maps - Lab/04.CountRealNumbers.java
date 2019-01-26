import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        LinkedHashMap<Double, Integer> occurrences = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (occurrences.containsKey(numbers[i])) {
                occurrences.put(numbers[i], occurrences.get(numbers[i]) + 1);
            } else {
                occurrences.put(numbers[i], 1);
            }
        }
        for (Double number : occurrences.keySet()) {
            System.out.printf("%.1f -> %d\n", number, occurrences.get(number));
        }
    }
}
