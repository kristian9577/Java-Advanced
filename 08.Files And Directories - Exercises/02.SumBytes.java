import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "08.Files And Directories - Exercises\\resources\\input.txt";


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(input))) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

