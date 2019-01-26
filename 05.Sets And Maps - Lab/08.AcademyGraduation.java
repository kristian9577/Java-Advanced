import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Double> studentScores = new TreeMap<>();
        int rowCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rowCount; i++) {
            String studentName = reader.readLine();
            Double averageScore = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average().getAsDouble();

            studentScores.put(studentName, averageScore);
        }
        for (String studentName : studentScores.keySet()) {
            System.out.println(studentName + " is graduated with " + studentScores.get(studentName));
        }
    }
}
