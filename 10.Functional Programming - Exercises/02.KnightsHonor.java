import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> getPrintln = s -> System.out.println(String.format("Sir %s", s));

        Arrays.stream(reader.readLine().split(" "))
                .forEach(getPrintln);
    }
}
