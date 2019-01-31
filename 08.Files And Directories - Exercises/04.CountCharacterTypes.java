import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\Krisko\\Documents\\JAVA\\JavaFund\\" +
                "08.Files And Directories - Exercises\\resources";

        String inputPath = basePath + "\\input.txt";
        String outPath = basePath + "\\2output.txt";

        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        List<String> punctuations = Arrays.asList("!", ",", ".", "?");

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.replaceAll("\\s+", "").split("");
                for (String token : tokens) {
                    if (vowels.contains(token)) {
                        vowelsCount += 1;
                    } else if (punctuations.contains(token)) {
                        punctuationCount += 1;
                    } else {
                        consonantsCount += 1;
                    }
                }
            }

            out.write(String.format("Vowels: %d\n", vowelsCount));
            out.write(String.format("Consonants: %d\n", consonantsCount));
            out.write(String.format("Punctuation: %d", punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
