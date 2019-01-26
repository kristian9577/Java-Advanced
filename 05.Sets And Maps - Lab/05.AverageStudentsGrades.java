import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, List<Double>> record = new TreeMap<>();

        int gradesCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < gradesCount; i++) {
            String[] parts = reader.readLine().split(" ");
            String name = parts[0];
            Double grade = Double.parseDouble(parts[1]);

            List<Double> currentGrades = new ArrayList<>();

            if (record.containsKey(name)) {
                currentGrades = record.get(name);
            }
            currentGrades.add(grade);
            record.put(name, currentGrades);
        }

        for (String studentName : record.keySet()) {
            System.out.print(studentName + " -> ");
            double gradeSum = 0;
            List<Double> studentGrades = record.get(studentName);
            for (Double grade : studentGrades) {
                gradeSum += grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)\n", Math.round(gradeSum / studentGrades.size() * 100) / 100.0);
        }
    }
}
