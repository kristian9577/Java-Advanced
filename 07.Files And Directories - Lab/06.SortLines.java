import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "07.Files And Directories - Lab\\resources";
        String inputPath = basePath + "\\input2.txt";
        String outPath = basePath + "\\6output.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            Files.readAllLines(Paths.get(inputPath))
                    .stream()
                    .filter(s -> !s.isEmpty())
                    .sorted()
                    .forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
